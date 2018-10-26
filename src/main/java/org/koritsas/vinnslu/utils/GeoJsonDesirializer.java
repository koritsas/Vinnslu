package org.koritsas.vinnslu.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;
import org.koritsas.vinnslu.models.topo.Topo;

import java.io.IOException;

public class GeoJsonDesirializer extends StdDeserializer<Topo> {
    public GeoJsonDesirializer() {
        this(null);
    }

    public GeoJsonDesirializer(Class<Topo> t) {
        super(t);
    }


    @Override
    public Topo deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException {

        Topo topo = new Topo();

        ObjectCodec codec = parser.getCodec();
        JsonNode node = codec.readTree(parser);



        String community =node.get("properties").get("community").asText();
        String prefecture =node.get("properties").get("prefecture").asText();
        String location =node.get("properties").get("location").asText();
        boolean forest = node.get("properties").get("forest").asBoolean();
        Long abl = node.get("properties").get("abl").asLong();



        topo.setForest(forest);
        topo.setCommunity(community);
        topo.setLocation(location);
        topo.setPrefecture(prefecture);
        topo.setAbl(abl);

        System.out.println("LELELE");
        System.out.println(topo.toString());

        return topo;
    }
}
