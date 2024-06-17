package com.rocha.rx.demo.data;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CustomFilterDeserializer implements JsonDeserializer<Filter> {
    @Override
    public Filter deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonArray filtersArray = jsonObject.getAsJsonArray("filters");

        List<Data> filters = new ArrayList<>();
        for (JsonElement element : filtersArray) {
            JsonObject filterObject = element.getAsJsonObject();
            String id = filterObject.get("id").getAsString();
            String name = filterObject.get("name").getAsString();
            String type = filterObject.get("type").getAsString();
            filters.add(new Data(id, name, type));
        }

        return new Filter(filters);
    }
}

