package org.koritsas.vinnslu.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;
import org.koritsas.vinnslu.models.topo.Topo;
import org.koritsas.vinnslu.ws.dto.topo.TopoDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeoJsonDeserializer extends StdDeserializer<TopoDTO> {
    public GeoJsonDeserializer() {
        this(null);
    }

    public GeoJsonDeserializer(Class<Topo> t) {
        super(t);
    }


    @Override
    public TopoDTO deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException {

        TopoDTO topo = new TopoDTO();

        ObjectCodec codec = parser.getCodec();
        JsonNode node = codec.readTree(parser);



        String community =node.get("properties").get("community").asText();
        String prefecture =node.get("properties").get("prefecture").asText();
        String location =node.get("properties").get("location").asText();
        String municipality =node.get("properties").get("municipality").asText();
        boolean forest = node.get("properties").get("forest").asBoolean();
        Long abl = node.get("properties").get("abl").asLong();

        boolean isArray =node.get("geometry").get("coordinates").isArray();

        JsonNode array =node.get("geometry").get("coordinates");

        JsonNode a = array.get(0).get(0).get(0);

        JsonNode b = array.get(0).get(1).get(1);


        Iterator jsonNodeIterator = array.get(0).iterator();

        List<Coordinate> coordinatesList = new ArrayList<>();

        while (jsonNodeIterator.hasNext()){

            JsonNode aa = (JsonNode) jsonNodeIterator.next();

           int x =aa.get(0).asInt();
           int y = aa.get(1).asInt();

           coordinatesList.add(new Coordinate(x,y));

        }

        Coordinate[] coordinates = new Coordinate[coordinatesList.size()];

        for (int i=0;i<=coordinates.length-1;i++){
            coordinates[i] = coordinatesList.get(i);
        }

        GeometryFactory factory = new GeometryFactory();

        Polygon polygon = factory.createPolygon(coordinates);


        topo.setPolygon(polygon);
        topo.setForest(forest);
        topo.setCommunity(community);
        topo.setLocation(location);
        topo.setPrefecture(prefecture);
        topo.setMunicipality(municipality);
        topo.setAbl(abl);

        System.out.println("LELELE");
        System.out.println(topo.toString());

        return topo;
    }
}
