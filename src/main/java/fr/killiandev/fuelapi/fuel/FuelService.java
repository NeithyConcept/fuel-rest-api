package fr.killiandev.fuelapi.fuel;

import fr.killiandev.fuelapi.exception.type.FuelException;
import fr.killiandev.fuelapi.fuel.models.FuelRequest;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public interface FuelService {

    /**
     * Returns a Future with the result of the query obtained with the parameters.
     *
     * @param latitude the latitude
     * @param longitude the longitude
     * @param radius the radius in meters
     * @return the result of the query
     * @throws IOException if an I/O error occurs when sending or receiving
     * @throws InterruptedException if the operation is interrupted
     * @throws FuelException if the radius is invalid
     */
    CompletableFuture<FuelRequest> getFuelInformation(double latitude, double longitude, int radius) throws IOException, InterruptedException;

    /**
     * Returns a Future with the result of the query obtained with the city.
     *
     * @param city the city
     * @return the result of the query
     * @throws IOException if an I/O error occurs when sending or receiving
     * @throws InterruptedException if the operation is interrupted
     * @throws FuelException if the radius is invalid
     */
    CompletableFuture<FuelRequest> getFuelInformation(String city) throws IOException, InterruptedException;
}
