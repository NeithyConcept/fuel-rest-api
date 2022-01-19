package fr.killiandev.fuelapi.fuel;

import fr.killiandev.fuelapi.fuel.models.FuelRequest;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public interface FuelService {

    CompletableFuture<FuelRequest> getFuelInformation(double latitude, double longitude, int distance) throws IOException, InterruptedException;

    CompletableFuture<FuelRequest> getFuelInformation(String city) throws IOException, InterruptedException;
}
