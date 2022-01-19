package fr.killiandev.fuelapi.controller;

import fr.killiandev.fuelapi.fuel.FuelService;
import fr.killiandev.fuelapi.fuel.models.FuelRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/")
public class ApiController {

    public final FuelService fuelService;

    public ApiController(FuelService fuelService) {
        this.fuelService = fuelService;
    }

    @GetMapping("/search/{latitude}/{longitude}/{distance}")
    public CompletableFuture<ResponseEntity<FuelRequest>> search(@PathVariable() double latitude, @PathVariable()
            double longitude, @PathVariable() int distance) throws IOException, InterruptedException {
        return fuelService.getFuelInformation(latitude, longitude, distance).thenApply(fuelRequest -> new ResponseEntity<>(fuelRequest, HttpStatus.OK));
    }

    @GetMapping("/search/{city}")
    public CompletableFuture<ResponseEntity<FuelRequest>> search(@PathVariable() String city) throws IOException, InterruptedException {
        return fuelService.getFuelInformation(city).thenApply(fuelRequest -> new ResponseEntity<>(fuelRequest, HttpStatus.OK));
    }
}
