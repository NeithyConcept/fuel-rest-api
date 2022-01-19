package fr.killiandev.fuelapi.util.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import fr.killiandev.fuelapi.fuel.models.FuelType;
import fr.killiandev.fuelapi.fuel.models.Point;
import fr.killiandev.fuelapi.fuel.models.RecordField;

import java.io.IOException;

public class RecordFieldAdapter extends TypeAdapter<RecordField> {
    @Override
    public void write(JsonWriter jsonWriter, RecordField recordField) {
        throw new UnsupportedOperationException("write RecordField to json not supported");
    }

    @Override
    public RecordField read(JsonReader reader) throws IOException {
        RecordField recordField = new RecordField();
        reader.beginObject();

        while (reader.hasNext()) {
            switch (reader.nextName()) {
                case "geo_point":
                    reader.beginArray();
                    double[] points = new double[2];
                    for (int i = 0; reader.hasNext(); i++) {
                        points[i] = reader.nextDouble();
                    }
                    recordField.setPoint(new Point(points));
                    reader.endArray();
                    break;
                case "city":
                    recordField.setCity(reader.nextString());
                    break;
                case "brand":
                    recordField.setBrand(reader.nextString());
                    break;
                case "name":
                    recordField.setName(reader.nextString());
                    break;
                case "address":
                    recordField.setAddress(reader.nextString());
                    break;
                case "cp":
                    recordField.setCp(reader.nextString());
                    break;
                case "update":
                    recordField.setLastUpdate(reader.nextString());
                    break;
                case "price_e10":
                    recordField.getFuels().put(FuelType.E10, reader.nextDouble());
                    break;
                case "price_e85":
                    recordField.getFuels().put(FuelType.E85, reader.nextDouble());
                    break;
                case "price_gazole":
                    recordField.getFuels().put(FuelType.GAZOLE, reader.nextDouble());
                    break;
                case "price_sp98":
                    recordField.getFuels().put(FuelType.SP98, reader.nextDouble());
                    break;
                case "price_gplc":
                    recordField.getFuels().put(FuelType.GLPC, reader.nextDouble());
                    break;
                default:
                    reader.skipValue();
            }
        }

        reader.endObject();
        return recordField;
    }
}
