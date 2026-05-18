package src.Threads;

public class Controller extends Thread {
    public void run() {


    }

    public void restart() {
        this.interrupt();
        this.start();
    }

}

