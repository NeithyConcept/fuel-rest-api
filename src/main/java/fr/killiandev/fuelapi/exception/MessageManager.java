package fr.killiandev.fuelapi.exception;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class MessageManager {

    private static MessageManager instance;

    @Getter private final Map<String, String> messages = new HashMap<>();

    private MessageManager() {
        messages.put("FUEL:DISTANCE-TOO-HIGH", "La distance de recherche est trop élevée");
    }

    public String getMessage(String identifier) {
        return messages.getOrDefault(identifier, "Message non configuré {"+identifier+"}");
    }

    public static MessageManager getInstance() {
        return instance == null ? instance = new MessageManager() : instance;
    }
}
