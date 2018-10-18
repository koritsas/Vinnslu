package org.koritsas.vinnslu.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.vividsolutions.jts.geom.Coordinate;
import org.koritsas.vinnslu.models.topo.Topo;

import java.io.IOException;

public class GeoJsonSerializer extends StdSerializer<Topo> {

    public GeoJsonSerializer() {
        this(null);
    }

    public GeoJsonSerializer(Class<Topo> t) {
        super(t);
    }

    @Override
    public void serialize(Topo value, JsonGenerator gen, SerializerProvider provider) throws IOException {

        //{
        gen.writeStartObject();


            // "type":"Feature"
            gen.writeStringField("type","Feature");

        gen.writeFieldName("geometry");
        gen.writeStartObject();
        gen.writeStringField("type",value.getPolygon().getGeometryType());
        gen.writeFieldName("coordinates");
        gen.writeStartArray();
        gen.writeStartArray();
        for (Coordinate coordinate:value.getPolygon().getCoordinates()){
            gen.writeArray(new double[]{coordinate.x, coordinate.y},0,2);
        }
        gen.writeEndArray();
        gen.writeEndArray();
        gen.writeEndObject();
        //properties
        gen.writeFieldName("properties");
        gen.writeStartObject();
        gen.writeNumberField("id",value.getId());
        gen.writeNumberField("abl",value.getAbl());
        gen.writeStringField("community",value.getCommunity());
        gen.writeStringField("location",value.getLocation());
        gen.writeStringField("prefecture",value.getPrefecture());
        gen.writeBooleanField("forest",value.isForest());
        gen.writeObjectField("topoOwner",value.getTopoOwner());
        gen.writeObjectField("owner",value.getAreaOwner());
        gen.writeEndObject();






        //}
        gen.writeEndObject();

    }
}
