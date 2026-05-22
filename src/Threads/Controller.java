package src.Threads;

import src.Handlers.ControllerHandler.LEDStatus;

public class Controller extends Thread {
    public static LEDStatus ledStatus = LEDStatus.none;

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println("ERROR: TRY CATCH IN CONTROLLER (ln 12)");
            }
            if(ledStatus == LEDStatus.none) {
                continue;
            }
            System.out.println(ledStatus.index);
        }
    }

}

