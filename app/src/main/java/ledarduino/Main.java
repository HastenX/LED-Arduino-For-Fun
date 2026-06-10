package ledarduino;

import ledarduino.Constants.ControllerConstants;
import ledarduino.Threads.Controller;
import ledarduino.Threads.UI;

public class Main {
    public static final UI ui = new UI();
    public static final Controller controller = new Controller();

    public static void main(String[] args) {
        // Starts threads to (1) Handle UI and (2) Communicate to Arduino

        ui.start();
        controller.start();
        
        // Adds values to Hashmaps
        ControllerConstants.updateHashmaps();
    }
}