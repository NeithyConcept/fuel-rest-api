package fr.killiandev.fuelapi.exception;

public class BaseException extends RuntimeException {

    public BaseException(String key) {
        super(MessageManager.getInstance().getMessage(key));
    }
}
