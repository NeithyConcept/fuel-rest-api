package fr.killiandev.fuelapi.controller;

import fr.killiandev.fuelapi.fuel.models.FuelRequest;
import fr.killiandev.fuelapi.fuel.models.FuelType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@RequestMapping("/")
public interface ApiController {

    /**
     * @param latitude the latitude
     * @param longitude the lontitude
     * @param radius the radius in meters
     * @return the result of the query
     */
    @GetMapping("/search/{latitude}/{longitude}/{radius}")
    CompletableFuture<ResponseEntity<FuelRequest>> search(@PathVariable() double latitude, @PathVariable() double longitude,
                                                          @PathVariable() int radius) throws IOException, InterruptedException;

    /**
     * @param city the city
     * @return the result of the query
     */
    @GetMapping("/search/{city}")
    CompletableFuture<ResponseEntity<FuelRequest>> search(@PathVariable() String city) throws IOException, InterruptedException;

    /**
     * @return all the fuels supported
     */
    @GetMapping("/fuels")
    ResponseEntity<FuelType[]> fuels();
}
