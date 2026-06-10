package ledarduino;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**Handles UI Objects-- specifically using AWT and Swing */
public interface UIObjects {
    public class TextObjects {
        private static ArrayList<JTextArea> texts = new ArrayList<JTextArea>();
        public final JTextArea textObject;

        /**Constructs JTextArea using a constructor */
        public TextObjects(
            String text,
            Rectangle rectangle, 
            Color backColor,
            Color textColor,
            Font font,
            Insets margin
        ) {
            textObject= new JTextArea(text);
            textObject.setBounds(rectangle);
            textObject.setBackground(backColor);
            textObject.setFont(font);
            textObject.setForeground(textColor);
            textObject.setMargin(margin);
            textObject.setEditable(false);
            texts.add(textObject);
        }

        public static JFrame appendAllText(JFrame frame) {
            for(JTextArea i : texts) {
                frame.add(i);
            }
            return frame;
        }
    }

    public class InputObjects {
        private static ArrayList<JTextField> inputs = new ArrayList<JTextField>();
        public final JTextField inputObject;

        /**Constructs JTextField using a constructor */
        public InputObjects(
            String text,
            Rectangle rectangle, 
            Color backColor,
            Color textColor,
            Font font,
            Insets margin
        ) {
            inputObject= new JTextField(text);
            inputObject.setBounds(rectangle);
            inputObject.setBackground(backColor);
            inputObject.setFont(font);
            inputObject.setForeground(textColor);
            inputObject.setMargin(margin);
            inputObject.setEditable(true);
            inputs.add(inputObject);
        }

        public static JFrame appendAllText(JFrame frame) {
            for(JTextField i : inputs) {
                frame.add(i);
            }
            return frame;
        }
    }

    /**Constructs JButton using a constructor */
    public class ButtonObjects {
        private static ArrayList<JButton> buttons = new ArrayList<JButton>();
        public final JButton buttonObject;

        public ButtonObjects(
            String text,
            Rectangle rectangle, 
            Color backColor,
            Color textColor,
            Font font,
            Insets margin
        ) {
            buttonObject= new JButton(text);
            buttonObject.setBounds(rectangle);
            buttonObject.setBackground(backColor);
            buttonObject.setFont(font);
            buttonObject.setForeground(textColor);
            buttonObject.setMargin(margin);
            buttons.add(buttonObject);
        }

        public static JFrame appendAllText(JFrame frame) {
            for(JButton i : buttons) {
                frame.add(i);
            }
            return frame;
        }
    }
}