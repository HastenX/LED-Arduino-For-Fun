package ledarduino;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;

public class Constants {
    public static final class UIConstants {
        public static final Dimension kFrameDimension = new Dimension(750,750);
        public static final FlowLayout kFrameLayout = null;

        public static final Color kWhiteFiller = new Color(255,255,255);
        public static final Font kDefaultFont = new Font("Arial", Font.BOLD, 32);
        public static final Insets kDefaultMargins = new Insets(10, 10, 10, 10);

        // public static final class 
    }

    public static final class ControllerConstants {
        public static final String kPortDescriptor = "/dev/ttyACM0";

        public static final int kBaudRate = 57600;
        public static final int kNewDataBits = 8;
        public static final int kNewStopBits = 1;

        public static final Color kColorFiller = new Color(0,0,0);
    }
}
