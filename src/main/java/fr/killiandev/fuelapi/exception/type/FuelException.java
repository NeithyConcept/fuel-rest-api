package fr.killiandev.fuelapi.exception.type;

import fr.killiandev.fuelapi.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class FuelException extends BaseException {

    public FuelException(String key) {
        super("FUEL:" + key);
    }
}
