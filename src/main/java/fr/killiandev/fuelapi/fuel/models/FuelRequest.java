package fr.killiandev.fuelapi.fuel.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor @Getter
public class FuelRequest {

    private Parameters parameters;
    private List<Record> records;
}
