package ledarduino.Threads;

import ledarduino.Handlers.ControllerHandler;
import ledarduino.Handlers.ControllerHandler.LEDStatus;

public class Controller extends Thread {
    // Used to determine the current profile to be sent to Arduino
    public static LEDStatus ledStatus = LEDStatus.none;

    // Code thread will continously execute. Has a try-catch because of 
    // intended sleep delay
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(50);
            } catch (Exception e) {}
            ControllerHandler.run(ledStatus);
        }
    }

}

