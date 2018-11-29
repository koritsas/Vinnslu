package org.koritsas.vinnslu.main.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.ws.dto.topo.TopoDTO;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Autowired
    private GeometryModelMapper mapper;

    @Override
    public TopoDTO deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException {

        TopoDTO topo = new TopoDTO();

        ObjectCodec codec = parser.getCodec();
        JsonNode node = codec.readTree(parser);


        ObjectMapper objectMapper = new ObjectMapper();

        node = node.get(0);


        if (node.get("properties").get("community") != null) {
            topo.setCommunity(node.get("properties").get("community").asText());
        }

        if (node.get("properties").get("prefecture") != null) {
            topo.setPrefecture(node.get("properties").get("prefecture").asText());
        }

        if (node.get("properties").get("location") != null) {
            topo.setLocation(node.get("properties").get("location").asText());
        }

        if (node.get("properties").get("municipality") != null) {
            topo.setMunicipality((node.get("properties").get("municipality").asText()));
        }

        if (node.get("properties").get("forest") != null) {
            topo.setForest(node.get("properties").get("forest").asBoolean());
        }

        if (node.get("properties").get("topoOnwer") != null) {
            topo.setTopoOwner(objectMapper.readValue(node.get("properties").get("topoOnwer").asText(), Company.class));
        }


        if (node.get("properties").get("areaOnwer") != null) {
            topo.setTopoOwner(objectMapper.readValue(node.get("properties").get("areaOnwer").asText(), Company.class));
        }

        if (node.get("properties").get("abl") != null) {
            topo.setAbl(node.get("properties").get("abl").asLong());
        }


        //Get the polygon coordinates from geojson and create the JTSPolygon

        if (node.get("geometry").get("coordinates") != null) {
            JsonNode array = node.get("geometry").get("coordinates");

            Iterator jsonNodeIterator = array.get(0).iterator();

            List<Coordinate> coordinatesList = new ArrayList<>();

            while (jsonNodeIterator.hasNext()) {

                JsonNode aa = (JsonNode) jsonNodeIterator.next();

                int x = aa.get(0).asInt();
                int y = aa.get(1).asInt();

                coordinatesList.add(new Coordinate(x, y));

            }

            Coordinate[] coordinates = new Coordinate[coordinatesList.size()];

            for (int i = 0; i <= coordinates.length - 1; i++) {
                coordinates[i] = coordinatesList.get(i);
            }

            GeometryFactory factory = new GeometryFactory();

            Polygon polygon = factory.createPolygon(coordinates);

            topo.setPolygon(polygon);

        }



        return topo;
    }
}
