package src.Handlers;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;

import src.Main;
import src.UIObjects;
import src.Constants.UIConstants;
import src.Handlers.ControllerHandler.LEDStatus;
import src.Threads.Controller;
import src.UIObjects.*;

public class UIHandler {
    private static JFrame frame = new JFrame("LED-UI");

    private static TextObjects header = new TextObjects(
        "LED-Selector!", 
        new Rectangle(250,40,230,60), 
        new Color(255,255,255), 
        new Color(255,0,0),
        new Font("Arial", Font.BOLD, 32), 
        new Insets(10,10,10,10)
    );

    private static TextObjects rText = new TextObjects(
        "Red Value:", 
        new Rectangle(80,120,150,50), 
        new Color(255,255,255), 
        new Color(255,0,0),
        new Font("Arial", Font.BOLD, 24), 
        new Insets(10,10,10,10)
    );

    private static TextObjects gText = new TextObjects(
        "Green Value:", 
        new Rectangle(70,300,180,50), 
        new Color(255,255,255), 
        new Color(0,255,0),
        new Font("Arial", Font.BOLD, 24), 
        new Insets(10,10,10,10)
    );
    private static TextObjects bText = new TextObjects(
        "Blue Value:", 
        new Rectangle(75,480,160,50), 
        new Color(255,255,255), 
        new Color(0,0,255),
        new Font("Arial", Font.BOLD, 24), 
        new Insets(10,10,10,10)
    );

    private static InputObjects rInput = new InputObjects(
        "", 
        new Rectangle(75,200,160,50), 
        new Color(255,255,255), 
        new Color(0,0,255),
        new Font("Arial", Font.BOLD, 24), 
        new Insets(10,10,10,10)
    );

    private static InputObjects gInput = new InputObjects(
        "", 
        new Rectangle(75,380,160,50), 
        new Color(255,255,255), 
        new Color(0,0,255),
        new Font("Arial", Font.BOLD, 24), 
        new Insets(10,10,10,10)
    );
    
    private static InputObjects bInput = new InputObjects(
        "", 
        new Rectangle(75,560,160,50), 
        new Color(255,255,255), 
        new Color(0,0,255),
        new Font("Arial", Font.BOLD, 24), 
        new Insets(10,10,10,10)
    );
    

    private static ButtonObjects setRGBBtn = new ButtonObjects(
        "Update >:3c", 
        new Rectangle(60,640,200,50), 
        new Color(255,255,255), 
        new Color(0,0,0),
        new Font("Arial", Font.BOLD, 24), 
        new Insets(10,10,10,10)
    );

    private static ButtonObjects profileOneBtn = new ButtonObjects(
        "Uniform LEDS", 
        new Rectangle(350,160,300,50), 
        new Color(255,255,255), 
        new Color(0,0,0),
        new Font("Arial", Font.BOLD, 24), 
        new Insets(10,10,10,10)
    );

    private static ButtonObjects profileTwoBtn = new ButtonObjects(
        "Alternating LEDS", 
        new Rectangle(350,340,300,50), 
        new Color(255,255,255), 
        new Color(0,0,0),
        new Font("Arial", Font.BOLD, 24), 
        new Insets(10,10,10,10)
    );

    private static ButtonObjects profileThreeBtn = new ButtonObjects(
        "Tri-Alternating LEDS", 
        new Rectangle(350,520,300,50), 
        new Color(255,255,255), 
        new Color(0,0,0),
        new Font("Arial", Font.BOLD, 24), 
        new Insets(10,10,10,10)
    );

    private static ButtonObjects stopBtn = new ButtonObjects(
        "STOP", 
        new Rectangle(350,600,300,50), 
        new Color(255,255,255), 
        new Color(255,0,0),
        new Font("Arial", Font.BOLD, 24), 
        new Insets(10,10,10,10)
    );

    public static void init() {
        frame= TextObjects.appendAllText(frame);
        frame= InputObjects.appendAllText(frame);
        frame= ButtonObjects.appendAllText(frame);

        configureEvents();
        configureFrame();
        frame.setVisible(true);
    }

    private static void configureEvents() {
        setRGBBtn.buttonObject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if(
                    isValidNum(rInput.inputObject.getText())
                        && isValidNum(bInput.inputObject.getText())
                        && isValidNum(gInput.inputObject.getText())
                ) {
                    Controller.ledStatus=LEDStatus.custom;
                }
            }
        });

        profileOneBtn.buttonObject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Controller.ledStatus=LEDStatus.profileOne;
            }
        });

        profileTwoBtn.buttonObject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Controller.ledStatus=LEDStatus.profileTwo;
            }
        });

        profileThreeBtn.buttonObject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Controller.ledStatus=LEDStatus.profileThree;
            }
        });

        stopBtn.buttonObject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Controller.ledStatus=LEDStatus.none;
            }
        });
    }

    private static void configureFrame() {
        frame.setLayout(UIConstants.kFrameLayout);

        frame.setSize(UIConstants.kFrameDimension);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(750, 200);
        frame.setResizable(false);

    }

    private static boolean isValidNum(String str) {
        try {
            if(Integer.valueOf(str) > 255) {
                throw new Exception();
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}