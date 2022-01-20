package fr.killiandev.fuelapi.exception;

/**
 * Exception integrating the automatic management of messages {@link MessageManager}
 */
public class BaseException extends RuntimeException {

    public BaseException(String key) {
        super(MessageManager.getInstance().getMessage(key));
    }
}
