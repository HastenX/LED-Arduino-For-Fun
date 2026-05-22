package src.Handlers;

public class ControllerHandler {



    public enum LEDStatus {
        none(-1),
        custom(0),
        profileOne(1),
        profileTwo(2),
        profileThree(3);

        public final int index;
        private LEDStatus(int index) {
            this.index=index;
        }
    }
}