package fr.killiandev.fuelapi.fuel.models;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor @Getter
public class Parameters {

    @SerializedName("q")
    private String citySearch;
    private int rows;
    private List<String> sort;
}
