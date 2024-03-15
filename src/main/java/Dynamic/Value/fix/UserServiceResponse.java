package Dynamic.Value.fix;

public class UserServiceResponse {
    public static final int DATABASE_ERROR = 2;
    private UserServiceResponseCode errorCode;
    private int errorMessage;

    public UserServiceResponseCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(UserServiceResponseCode errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(int errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return errorCode == UserServiceResponseCode.Success;
    }
}