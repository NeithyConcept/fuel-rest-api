package fr.killiandev.fuelapi.fuel.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor @Data
public class RecordField {

    private Point point;
    private String city;
    private String brand;
    private String name;
    private String address;
    private String cp;
    private String lastUpdate;
    private final Map<FuelType, Double> fuels = new HashMap<>();
}
