package ledarduino.Threads;

import ledarduino.Handlers.ControllerHandler;
import ledarduino.Handlers.ControllerHandler.LEDStatus;

public class Controller extends Thread {
    public static LEDStatus ledStatus = LEDStatus.none;

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(50);
            } catch (Exception e) {}
            ControllerHandler.run(ledStatus);
        }
    }

    public boolean shouldStop() {
        return ledStatus == LEDStatus.none;
    }

    public boolean shouldSwap(LEDStatus status) {
        return ledStatus != status;
    }

}

