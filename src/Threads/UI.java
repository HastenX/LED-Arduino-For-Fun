package src.Threads;

import src.Constants.GUIConstants;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI extends Thread {

    
    public void run() {

        
    }

    public void restart() {
        this.interrupt();
        this.start();

    }

}
