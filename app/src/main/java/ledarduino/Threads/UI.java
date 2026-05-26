package ledarduino.Threads;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ledarduino.Constants.UIConstants;
import ledarduino.Handlers.UIHandler;

import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI extends Thread {
    public static boolean isRunning=false;
    
    @Override
    public void run() {
        isRunning=true;
        UIHandler.init();
        
    }

}
