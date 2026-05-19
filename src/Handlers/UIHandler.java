package src.Handlers;

import javax.swing.JFrame;

public class UIHandler {
    private static final Container container = new Container();

    // TODO: Implement
    // private static final ActionEvent actionEvent = new ActionEvent(container, 0, null);
    // };
    // private static final ActionListener actionListener = new ActionListener() {
        
    // };

    private static JFrame frame = new JFrame();

    private static JLabel header = new JLabel();

    private static JLabel r1Label = new JLabel();
    private static JLabel g1Label = new JLabel();
    private static JLabel b1Label = new JLabel();

    private static JLabel r2Label = new JLabel();
    private static JLabel g2Label = new JLabel();
    private static JLabel b2Label = new JLabel();

    private static JLabel r3Label = new JLabel();
    private static JLabel g3Label = new JLabel();
    private static JLabel b3Label = new JLabel();

    private static JTextField r1Input = new JTextField();
    private static JTextField g1Input = new JTextField();
    private static JTextField b1Input = new JTextField();

    private static JTextField r2Input = new JTextField();
    private static JTextField g2Input = new JTextField();
    private static JTextField b2Input = new JTextField();

    private static JTextField r3Input = new JTextField();
    private static JTextField g3Input = new JTextField();
    private static JTextField b3Input = new JTextField();

    private static JButton profileOneBtn = new JButton();
    private static JButton profileTwoBtn = new JButton();
    private static JButton profileThreeBtn = new JButton();

    static {
        // TODO: ADD CODE TO CONFIGURE BUTTONS/ POSITIONING

        addLabelsToFrame();
        addInputsToFrame();
        addButtonsToFrame();

        configureFrame();
    }

    private static void addLabelsToFrame() {
        frame.add(header);

        frame.add(r1Label);
        frame.add(b1Label);
        frame.add(g1Label);

        frame.add(r2Label);
        frame.add(b2Label);
        frame.add(g2Label);

        frame.add(r3Label);
        frame.add(b3Label);
        frame.add(g3Label);
    }

    private static void addInputsToFrame() {
        frame.add(r1Input);
        frame.add(b1Input);
        frame.add(g1Input);

        frame.add(r2Input);
        frame.add(b2Input);
        frame.add(g2Input);

        frame.add(r3Input);
        frame.add(b3Input);
        frame.add(g3Input);
    }

    private static void addButtonsToFrame() {
        frame.add(profileOneBtn);
        frame.add(profileTwoBtn);
        frame.add(profileThreeBtn);
    }

    private static void configureFrame() {
        frame.setLayout(GUIConstants.kFrameLayout);
        frame.setSize(GUIConstants.kFrameDimension);
        frame.setVisible(true);

    }
    // TODO: DECIDE ON IMPLEMENTATION
    // public static void turnOnScreen() {
    //     frame.setVisible(true);

    // }
}