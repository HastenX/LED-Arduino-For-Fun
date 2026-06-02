package ledarduino;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.util.HashMap;

public class Constants {
    public static final class UIConstants {
        public static final Dimension kFrameDimension = new Dimension(750,750);
        public static final FlowLayout kFrameLayout = null;

        public static final Color kWhiteFiller = new Color(255,255,255);
        public static final Font kDefaultFont = new Font("Arial", Font.BOLD, 24);
        public static final Font kLargeFont = new Font("Arial", Font.BOLD, 24);
        public static final Insets kDefaultMargins = new Insets(10, 10, 10, 10);

    }

    public static final class ControllerConstants {
        public static final String kPortDescriptor = "/dev/ttyACM0";
        // public static final String kPortDescriptor = "COM6";

        public static final int kBaudRate = 57600;
        public static final int kNewDataBits = 8;
        public static final int kNewStopBits = 1;

        public static final Color kColorFiller = new Color(0,0,0);

        public static final HashMap<Integer,int[]> indexToOffArray = new HashMap<Integer,int[]>();
        public static final HashMap<Integer,int[]> indexToOnArray = new HashMap<Integer,int[]>();

        public static final void updateHashmaps() {
            indexToOffArray.put(0,new int[0]);
            indexToOffArray.put(1,new int[]{0});
            indexToOffArray.put(2,new int[]{1});
            indexToOffArray.put(3,new int[]{2});
            indexToOffArray.put(4,new int[]{0,1});
            indexToOffArray.put(5,new int[]{0,2});
            indexToOffArray.put(6,new int[]{1,2});
            indexToOffArray.put(7,new int[]{0,1,2});


            indexToOnArray.put(0,new int[]{0,1,2});
            indexToOnArray.put(1,new int[]{1,2});
            indexToOnArray.put(2,new int[]{0,2});
            indexToOnArray.put(3,new int[]{0,1});
            indexToOnArray.put(4,new int[]{2});
            indexToOnArray.put(5,new int[]{1});
            indexToOnArray.put(6,new int[]{0});
            indexToOnArray.put(7,new int[0]);
        }
    }
}
