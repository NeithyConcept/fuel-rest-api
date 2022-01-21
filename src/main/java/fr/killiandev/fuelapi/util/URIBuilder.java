package fr.killiandev.fuelapi.util;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Class to create a URI for GET requests
 */
public class URIBuilder implements Cloneable {

    private String baseUrl;
    private Map<String, String> parameters = new HashMap<>();

    /**
     * Sets the base url
     *
     * @param baseUrl the base url
     * @return this builder
     */
    public URIBuilder baseURL(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    /**
     * Adds a parameter
     *
     * @param key the parameter's key
     * @param value the parameter's value
     * @return this builder
     */
    public URIBuilder addParameter(String key, String value) {
        parameters.put(key, value);
        return this;
    }

    /**
     * Returns a new {@link URI} built from the current state of this builder
     *
     * @return a new {@link URI}
     */
    public URI build() {
        StringBuilder stringBuilder = new StringBuilder(baseUrl);

        AtomicBoolean atomicBoolean = new AtomicBoolean();
        parameters.forEach((s, s2) -> {
            stringBuilder.append(atomicBoolean.get() ? '&' : '?').append(s).append('=').append(s2);
            atomicBoolean.set(true);
        });

        return URI.create(stringBuilder.toString());
    }

    /**
     * Clone this builder
     *
     * @return a new {@link URIBuilder} cloned
     */
    @Override
    public URIBuilder clone() {
        try {
            URIBuilder builder = (URIBuilder) super.clone();
            builder.parameters = new HashMap<>(this.parameters);
            return builder;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Create a new {@link URIBuilder}
     *
     * @return an {@link URIBuilder}
     */
    public static URIBuilder newBuilder() {
        return new URIBuilder();
    }
}
