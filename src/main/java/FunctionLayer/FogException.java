package FunctionLayer;

public class FogException extends Exception {

    private String shortMessage;

    public FogException(String msg, String shortMessage) {
        super(msg);
        this.shortMessage = shortMessage;
    }

    public FogException(String msg) {
        super(msg);
        this.shortMessage = "";
    }

    public String getShortMessage() {
        return shortMessage;
    }
}
