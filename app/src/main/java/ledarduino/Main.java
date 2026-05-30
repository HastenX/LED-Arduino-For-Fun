package ledarduino;

import ledarduino.Constants.ControllerConstants;
import ledarduino.Threads.Controller;
import ledarduino.Threads.UI;

public class Main {
    public static final UI ui = new UI();
    public static final Controller controller = new Controller();

    public static void main(String[] args) {
        ui.start();
        controller.start();
        
        ControllerConstants.updateHashmaps();
    }
}