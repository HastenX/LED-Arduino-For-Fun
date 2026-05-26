package ledarduino.Handlers;

import java.awt.Color;
import java.util.ArrayList;

import com.fazecast.jSerialComm.SerialPort;

import ledarduino.Constants.ControllerConstants;

public class ControllerHandler {
    private static SerialPort serialPort = SerialPort.getCommPort(ControllerConstants.kPortDescriptor);

    static {
        serialPort.setComPortParameters(ControllerConstants.kBaudRate,ControllerConstants.kNewDataBits,ControllerConstants.kNewStopBits,0);
        serialPort.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
    }

    private static ArrayList<Integer> signals;
    private static byte[] readBuffer = new byte[1024];

    public static void run(LEDStatus ledStatus) {
        if(!serialPort.isOpen()) {
            serialPort.openPort();
            return;
        }

        signals=indexColorArray(ledStatus.index, ledStatus.color);
        int bytes = serialPort.readBytes(readBuffer, readBuffer.length);
        try {
            if(bytes==-1 || bytes==0) {
                return;
            } 

            for(Integer i : signals) {
                serialPort.getOutputStream().write(i.byteValue());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static ArrayList<Integer> indexColorArray(Integer index, Color color) {
        Integer r=color.getRed();
        Integer g=color.getGreen();
        Integer b=color.getBlue();

        ArrayList<Integer> totalArray = new ArrayList<Integer>();

        totalArray.add(index);
        totalArray.add(r);
        totalArray.add(g);
        totalArray.add(b);

        return totalArray;
    }


    public enum LEDStatus {
        none(0, ControllerConstants.kColorFiller),
        custom(0,ControllerConstants.kColorFiller),
        profileOne(1, ControllerConstants.kColorFiller),
        profileTwo(2, ControllerConstants.kColorFiller);

        private Color color;
        public final int index;
        private LEDStatus(int index, Color color) {
            this.index=index;
            this.color=color;
        }

        public void setColor(Color color) {
            this.color=color;
        }
        public Color getColor() {
            return this.color;
        }
    }
}