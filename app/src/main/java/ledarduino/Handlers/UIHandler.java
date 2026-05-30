package ledarduino.Handlers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ledarduino.Constants.UIConstants;
import ledarduino.Handlers.ControllerHandler.LEDStatus;
import ledarduino.Threads.Controller;
import ledarduino.UIObjects.*;

public class UIHandler {
    private static JFrame frame = new JFrame("LED-UI");

    private static TextObjects header = new TextObjects(
        "LED-Selector!", 
        new Rectangle(250,40,230,60), 
        UIConstants.kWhiteFiller, 
        new Color(255,0,0),
        UIConstants.kLargeFont, 
        UIConstants.kDefaultMargins
    );

    private static TextObjects rText = new TextObjects(
        "Red Value:", 
        new Rectangle(80,120,150,50), 
        UIConstants.kWhiteFiller, 
        new Color(255,0,0),
        UIConstants.kDefaultFont, 
        UIConstants.kDefaultMargins
    );

    private static TextObjects gText = new TextObjects(
        "Green Value:", 
        new Rectangle(70,300,180,50), 
        UIConstants.kWhiteFiller, 
        new Color(0,255,0),
        UIConstants.kDefaultFont, 
        UIConstants.kDefaultMargins
    );
    private static TextObjects bText = new TextObjects(
        "Blue Value:", 
        new Rectangle(75,480,160,50), 
        UIConstants.kWhiteFiller, 
        new Color(0,0,255),
        UIConstants.kDefaultFont, 
        UIConstants.kDefaultMargins
    );

    private static TextObjects indexText = new TextObjects(
        "Index:", 
        new Rectangle(440,350,100,50), 
        UIConstants.kWhiteFiller, 
        new Color(255,0,0),
        UIConstants.kDefaultFont, 
        UIConstants.kDefaultMargins
    );

    private static TextObjects onCurrentText = new TextObjects(
        "On: 0, 1, 2", 
        new Rectangle(20,10,200,50), 
        UIConstants.kWhiteFiller, 
        new Color(255,0,0),
        UIConstants.kDefaultFont, 
        UIConstants.kDefaultMargins
    );

    private static TextObjects stopCurrentText = new TextObjects(
        "Off: ", 
        new Rectangle(20,60,200,50), 
        UIConstants.kWhiteFiller, 
        new Color(255,0,0),
        UIConstants.kDefaultFont, 
        UIConstants.kDefaultMargins
    );

    private static InputObjects rInput = new InputObjects(
        "", 
        new Rectangle(75,200,160,50), 
        UIConstants.kWhiteFiller, 
        new Color(0,0,255),
        UIConstants.kDefaultFont, 
        UIConstants.kDefaultMargins
    );

    private static InputObjects gInput = new InputObjects(
        "", 
        new Rectangle(75,380,160,50), 
        UIConstants.kWhiteFiller, 
        new Color(0,0,255),
        UIConstants.kDefaultFont, 
        UIConstants.kDefaultMargins
    );
    
    private static InputObjects bInput = new InputObjects(
        "", 
        new Rectangle(75,560,160,50), 
        UIConstants.kWhiteFiller, 
        new Color(0,0,255),
        UIConstants.kDefaultFont, 
        UIConstants.kDefaultMargins
    );

    private static InputObjects indexInput = new InputObjects(
        "", 
        new Rectangle(440,410,100,50), 
        UIConstants.kWhiteFiller, 
        new Color(0,0,0),
        UIConstants.kDefaultFont, 
        UIConstants.kDefaultMargins
    );

    private static ButtonObjects startIndexBtn = new ButtonObjects(
        "Start Index", 
        new Rectangle(350,470,300,50), 
        UIConstants.kWhiteFiller, 
        new Color(0,255,0),
        UIConstants.kDefaultFont, 
        UIConstants.kDefaultMargins
    );

    private static ButtonObjects stopIndexBtn = new ButtonObjects(
        "Stop Index", 
        new Rectangle(350,570,300,50), 
        UIConstants.kWhiteFiller, 
        new Color(255,0,0),
        UIConstants.kDefaultFont, 
        UIConstants.kDefaultMargins
    );

    private static ButtonObjects setRGBBtn = new ButtonObjects(
        "Update >:3c", 
        new Rectangle(60,640,200,50), 
        UIConstants.kWhiteFiller, 
        new Color(0,0,0),
        UIConstants.kDefaultFont, 
        UIConstants.kDefaultMargins
    );


    private static ButtonObjects profileOneBtn = new ButtonObjects(
        "Uniform LEDS", 
        new Rectangle(350,160,300,50), 
        UIConstants.kWhiteFiller, 
        new Color(0,0,0),
        UIConstants.kDefaultFont, 
        UIConstants.kDefaultMargins
    );

    private static ButtonObjects profileTwoBtn = new ButtonObjects(
        "Alternating LEDS", 
        new Rectangle(350,280,300,50), 
        UIConstants.kWhiteFiller, 
        new Color(0,0,0),
        UIConstants.kDefaultFont, 
        UIConstants.kDefaultMargins
    );

    private static ButtonObjects stopAllBtn = new ButtonObjects(
        "STOP ALL", 
        new Rectangle(350,620,300,50), 
        UIConstants.kWhiteFiller, 
        new Color(255,0,0),
        UIConstants.kDefaultFont, 
        UIConstants.kDefaultMargins
    );

    private static ButtonObjects startAllBtn = new ButtonObjects(
        "START ALL", 
        new Rectangle(350,520,300,50), 
        UIConstants.kWhiteFiller, 
        new Color(0,255,0),
        UIConstants.kDefaultFont, 
        UIConstants.kDefaultMargins
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
                    LEDStatus.custom.setColor(new Color(
                        Integer.valueOf(rInput.inputObject.getText()),
                        Integer.valueOf(gInput.inputObject.getText()),
                        Integer.valueOf(bInput.inputObject.getText())
                    ));

                    setRGBBtn.buttonObject.setForeground(LEDStatus.custom.getColor());
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

        stopIndexBtn.buttonObject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String currentIndex=indexInput.inputObject.getText();
                if(isValidNum(currentIndex) 
                    && Integer.valueOf(currentIndex)<=2
                    && Integer.valueOf(currentIndex)>=0
                ) {
                    Controller.ledStatus.setStopIndex(Integer.valueOf(currentIndex),1);
                    stopCurrentText.textObject.setText(Controller.ledStatus.getOffString());
                    onCurrentText.textObject.setText(Controller.ledStatus.getOnString());
                }
            }
        });

        startIndexBtn.buttonObject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               String currentIndex=indexInput.inputObject.getText();
                if(isValidNum(currentIndex)
                    && Integer.valueOf(currentIndex)<=2
                    && Integer.valueOf(currentIndex)>=0
                ) {
                    Controller.ledStatus.setStopIndex(Integer.valueOf(currentIndex),0);
                    stopCurrentText.textObject.setText(Controller.ledStatus.getOffString());
                    onCurrentText.textObject.setText(Controller.ledStatus.getOnString());
                }
            }
        });

        stopAllBtn.buttonObject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Controller.ledStatus.setStopIndex(0,1);
                Controller.ledStatus.setStopIndex(1,1);
                Controller.ledStatus.setStopIndex(2,1);
                stopCurrentText.textObject.setText(Controller.ledStatus.getOffString());
                onCurrentText.textObject.setText(Controller.ledStatus.getOnString());
            }
        });

        startAllBtn.buttonObject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Controller.ledStatus.setStopIndex(0,0);
                Controller.ledStatus.setStopIndex(1,0);
                Controller.ledStatus.setStopIndex(2,0);
                stopCurrentText.textObject.setText(Controller.ledStatus.getOffString());
                onCurrentText.textObject.setText(Controller.ledStatus.getOnString());
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
            if(Integer.valueOf(str) > 255 || str.contains(",") || str.contains(".")) {
                throw new Exception();
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static void togglePowerBtn() {
        
    }

    private static void toggleOnBtn() {

    }

    private static void toggleOffBtn() {

    }
}