package fr.killiandev.fuelapi.fuel.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.killiandev.fuelapi.Constants;
import fr.killiandev.fuelapi.exception.type.FuelException;
import fr.killiandev.fuelapi.fuel.FuelService;
import fr.killiandev.fuelapi.fuel.models.FuelRequest;
import fr.killiandev.fuelapi.fuel.models.RecordField;
import fr.killiandev.fuelapi.util.URIBuilder;
import fr.killiandev.fuelapi.util.adapter.RecordFieldAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

@Service
public class FuelServiceImpl implements FuelService {

    public static final Logger LOGGER = LoggerFactory.getLogger(FuelService.class);

    private final Gson gson = new GsonBuilder().registerTypeAdapter(RecordField.class, new RecordFieldAdapter()).create();

    private final HttpClient client = HttpClient.newHttpClient();

    private final URIBuilder builder = URIBuilder.newBuilder()
            .baseURL(Constants.BASE_URL)
            .addParameter("dataset", Constants.DATASET)
            .addParameter("sort", "update")
            .addParameter("rows", "20");

    @Async
    @Override
    public CompletableFuture<FuelRequest> getFuelInformation(double latitude, double longitude, int radius) throws IOException, InterruptedException {
        if(radius > Constants.MAX_RADIUS)
            throw new FuelException("RADIUS-TOO-HIGH");

        // Use the default builder and build a URI with this params
        URI uri = builder.addParameter("geofilter.distance", latitude + "," + longitude + "," + radius).build();
        LOGGER.info("Send request with latitude/longitude/distance: " + uri);

        return CompletableFuture.completedFuture(sendRequest(uri));
    }

    @Override
    public CompletableFuture<FuelRequest> getFuelInformation(String city) throws IOException, InterruptedException {
        if(city == null || city.equals(""))
            throw new FuelException("CITY-INVALID");

        // Use the default builder and build a URI with the city
        URI uri = builder.addParameter("q", city).build();
        LOGGER.info("Send request with city: " + uri);

        return CompletableFuture.completedFuture(sendRequest(uri));
    }

    /**
     * Sends a request to the {@link Constants.BASE_URL} and returns the result
     *
     * @param uri the uri with his parameters
     * @return the result of the query
     * @throws IOException if an I/O error occurs when sending or receiving
     * @throws InterruptedException if the operation is interrupted
     */
    private FuelRequest sendRequest(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(uri)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return gson.fromJson(response.body(), FuelRequest.class);
    }

}
