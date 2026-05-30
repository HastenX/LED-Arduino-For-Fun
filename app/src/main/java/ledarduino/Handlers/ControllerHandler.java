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

        signals=indexColorArray(ledStatus.index, LEDStatus.generateStopIndexes(), ledStatus.color);
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

    private static ArrayList<Integer> indexColorArray(Integer index, Integer stopIndexes, Color color) {
        Integer r=color.getRed();
        Integer g=color.getGreen();
        Integer b=color.getBlue();

        ArrayList<Integer> totalArray = new ArrayList<Integer>();

        totalArray.add(index);
        totalArray.add(stopIndexes);
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

        // Has 3 total circuits
        private static int[] stopIndexes= new int[3]; 
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

        public void setStopIndex(int position, int val) {
            stopIndexes[position] = val;
        }

        // Overcomplicated, but basically maps every possible index state (on/off) to a value
        // that will be passed to C++ arduino stuff :3

        public static int generateStopIndexes() {
            switch(stopIndexes[0]) {
                case 0:
                    switch(stopIndexes[1]) {
                        case 0:
                            switch(stopIndexes[2]) {
                                case 0:
                                    return 0;
                                case 1:
                                    return 3;
                            }
                        case 1:
                            switch(stopIndexes[2]) {
                                case 0:
                                    return 2;
                                case 1:
                                    return 6;
                            }
                    }
                case 1:
                    switch(stopIndexes[1]) {
                        case 0:
                            switch(stopIndexes[2]) {
                                case 0:
                                    return 1;
                                case 1:
                                    return 5;
                            }
                        case 1:
                            switch(stopIndexes[2]) {
                                case 0:
                                    return 4;
                                case 1:
                                    return 7;
                            }
                    }                    
            }
            System.out.println("ERROR: generateStopIndexes FAILED!!!");
            return -1;
        }

        public String getOffString() {
            String returnVal = "Off: ";
            int stopIndexeKeys = generateStopIndexes();
            int[] stopIndexes = ControllerConstants.indexToOffArray.get(stopIndexeKeys);
            for(int i=0; i<stopIndexes.length; i++) {  
                returnVal+=stopIndexes[i];
                if(i<stopIndexes.length-1) {
                    returnVal+=", ";
                }
            }
            return returnVal;
        }

        public String getOnString() {
            String returnVal = "On: ";
            int stopIndexKeys = generateStopIndexes();
            int[] stopIndexes = ControllerConstants.indexToOnArray.get(stopIndexKeys);
            for(int i=0; i<stopIndexes.length; i++) {  
                returnVal+=stopIndexes[i];
                if(i<stopIndexes.length-1) {
                    returnVal+=", ";
                }
            }
            return returnVal;
        }
    }
}