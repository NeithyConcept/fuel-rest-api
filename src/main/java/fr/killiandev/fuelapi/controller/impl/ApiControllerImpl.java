package fr.killiandev.fuelapi.controller.impl;

import fr.killiandev.fuelapi.controller.ApiController;
import fr.killiandev.fuelapi.fuel.FuelService;
import fr.killiandev.fuelapi.fuel.models.FuelRequest;
import fr.killiandev.fuelapi.fuel.models.FuelType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@RestController
public class ApiControllerImpl implements ApiController {

    public final FuelService fuelService;

    public ApiControllerImpl(FuelService fuelService) {
        this.fuelService = fuelService;
    }

    @Override
    public CompletableFuture<ResponseEntity<FuelRequest>> search(double latitude, double longitude, int radius) throws IOException, InterruptedException {
        return fuelService.getFuelInformation(latitude, longitude, radius).thenApply(fuelRequest -> new ResponseEntity<>(fuelRequest, HttpStatus.OK));
    }

    @Override
    public CompletableFuture<ResponseEntity<FuelRequest>> search(String city) throws IOException, InterruptedException {
        return fuelService.getFuelInformation(city).thenApply(fuelRequest -> new ResponseEntity<>(fuelRequest, HttpStatus.OK));
    }

    @Override
    public ResponseEntity<FuelType[]> fuels() {
        return new ResponseEntity<>(FuelType.values(), HttpStatus.OK);
    }
}
