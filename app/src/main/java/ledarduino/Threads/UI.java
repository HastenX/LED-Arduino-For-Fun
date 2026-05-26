package ledarduino.Threads;

import ledarduino.Handlers.UIHandler;

public class UI extends Thread {
    
    @Override
    public void run() {
        UIHandler.init();
    }

}
