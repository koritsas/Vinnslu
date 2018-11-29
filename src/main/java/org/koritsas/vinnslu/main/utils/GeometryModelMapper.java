package org.koritsas.vinnslu.main.utils;


import com.fasterxml.jackson.databind.JsonNode;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeometryModelMapper extends ModelMapper {


    public GeometryModelMapper() {


        Converter<JsonNode, Topo> converter = new Converter<JsonNode, Topo>() {
            @Override
            public Topo convert(MappingContext<JsonNode, Topo> context) {

                System.out.println(context.getSource());

                String community = context.getSource().get("properties").get("community").asText();
                String prefecture = context.getSource().get("properties").get("prefecture").asText();
                String location = context.getSource().get("properties").get("location").asText();
                String municipality = context.getSource().get("properties").get("municipality").asText();
                boolean forest = context.getSource().get("properties").get("forest").asBoolean();
                Long abl = context.getSource().get("properties").get("abl").asLong();

                //Get the polygon coordinates from geojson and create the JTSPolygon

                JsonNode array = context.getSource().get("geometry").get("coordinates");

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

                Topo topo = new Topo();

                topo.setPolygon(polygon);
                topo.setForest(forest);
                topo.setCommunity(community);
                topo.setLocation(location);
                topo.setPrefecture(prefecture);
                topo.setMunicipality(municipality);
                topo.setAbl(abl);

                return topo;
            }
        };


        this.addConverter(converter);

    }


}