package com.projectpandas.ridemory.util;

import java.io.IOException;
import java.util.List;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class ObjectIdListSerializer extends JsonSerializer<List<ObjectId>> {
    @Override
    public void serialize(List<ObjectId> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartArray();
        value.forEach(obj -> {
            try {
                gen.writeString(obj.toHexString());
            } catch (IOException e) {
            }
        });
        gen.writeEndArray();
    }
}