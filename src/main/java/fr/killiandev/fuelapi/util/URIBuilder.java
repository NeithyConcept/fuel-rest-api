package fr.killiandev.fuelapi.util;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class URIBuilder {

    private String baseUrl;
    private final Map<String, String> parameters = new HashMap<>();

    public URIBuilder baseURL(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public URIBuilder addParameter(String key, String value) {
        parameters.put(key, value);
        return this;
    }

    public URI build() {
        StringBuilder stringBuilder = new StringBuilder(baseUrl);

        AtomicBoolean atomicBoolean = new AtomicBoolean();
        parameters.forEach((s, s2) -> {
            stringBuilder.append(atomicBoolean.get() ? '&' : '?').append(s).append('=').append(s2);
            atomicBoolean.set(true);
        });

        return URI.create(stringBuilder.toString());
    }

    public static URIBuilder newBuilder() {
        return new URIBuilder();
    }
}
