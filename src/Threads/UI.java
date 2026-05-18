package src.Threads;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI extends Thread {
    private static final FlowLayout layout = new FlowLayout();
    private static final Container container = new Container();

    // TODO: Implement
    // private static final ActionEvent actionEvent = new ActionEvent(container, 0, null);
    // };
    // private static final ActionListener ActionListener = new ActionListener() {
        
    // };

    private static JFrame frame = new JFrame();
    private static JButton button = new JButton();
    private static JLabel label = new JLabel();
    private static JTextField text = new JTextField();
    
    public void run() {
        frame.setLayout(layout);
        
    }

    public void restart() {
        this.interrupt();
        this.start();

    }

}
