package pers.benjamin;

public class MyException extends RuntimeException{
    private static final long serialVersionUID = 5402353342758315792L;
    private String code;

    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String code, String message) {
        super(message);
        this.code = code;
    }

    public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(Throwable cause) {
        super(cause);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
