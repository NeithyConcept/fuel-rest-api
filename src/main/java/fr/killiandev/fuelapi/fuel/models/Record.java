package fr.killiandev.fuelapi.fuel.models;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor @Getter
public class Record {

    @SerializedName("recordid")
    private String id;
    private RecordField fields;
}
