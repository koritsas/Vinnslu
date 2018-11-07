package org.koritsas.vinnslu.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;
import org.koritsas.vinnslu.models.common.Company;
import org.koritsas.vinnslu.models.topo.Topo;
import org.koritsas.vinnslu.ws.dto.topo.TopoDTO;
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



        String community =node.get("properties").get("community").asText();
        String prefecture =node.get("properties").get("prefecture").asText();
        String location =node.get("properties").get("location").asText();
        String municipality =node.get("properties").get("municipality").asText();
        boolean forest = node.get("properties").get("forest").asBoolean();
        Long abl = node.get("properties").get("abl").asLong();

        //Get the polygon coordinates from geojson and create the JTSPolygon

        JsonNode array =node.get("geometry").get("coordinates");

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



        //   Company topoOwner =  mapper.map(node.get("properties").get("topoOwner"),Company.class);
        System.out.println("This is topoOwner");
        System.out.println(node.get("properties").get("topoOwner").asText());

//        Company areaOwner =  mapper.map(node.get("properties").get("areaOwner"),Company.class);


        topo.setPolygon(polygon);
        topo.setForest(forest);
        topo.setCommunity(community);
        topo.setLocation(location);
        topo.setPrefecture(prefecture);
        topo.setMunicipality(municipality);
        topo.setAbl(abl);
    //    topo.setTopoOwner(topoOwner);
     //   topo.setAreaOwner(areaOwner);

        System.out.println("LELELE");
        System.out.println(topo.toString());

        return topo;
    }
}
