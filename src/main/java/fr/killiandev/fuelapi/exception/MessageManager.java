package fr.killiandev.fuelapi.exception;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class MessageManager {

    private static MessageManager instance;

    @Getter private final Map<String, String> messages = new HashMap<>();

    private MessageManager() {
        // Register the messages
        messages.put("FUEL:RADIUS-TOO-HIGH", "La distance de recherche est trop élevée");
        messages.put("FUEL:CITY-INVALID", "Le nom de la ville est invalide");
    }

    public String getMessage(String identifier) {
        return messages.getOrDefault(identifier, "Message non configuré {"+identifier+"}");
    }

    public static MessageManager getInstance() {
        return instance == null ? instance = new MessageManager() : instance;
    }
}
