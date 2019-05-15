package FunctionLayer;

public class LoginSampleException extends Exception {

    private String shortMessage;

    public LoginSampleException(String msg, String shortMessage) {
        super(msg);
        this.shortMessage = shortMessage;
    }

    public LoginSampleException(String msg) {
        super(msg);
        this.shortMessage = "";
    }

    public String getShortMessage() {
        return shortMessage;
    }
}
