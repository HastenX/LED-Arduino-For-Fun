package src;

import src.Threads.Controller;
import src.Threads.UI;

public class Main {
    public static final UI ui = new UI();
    public static final Controller controller = new Controller();

    public static void main(String[] args) {
        ui.start();
        controller.start();
    }
}