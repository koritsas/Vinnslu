package org.koritsas.vinnslu.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.vividsolutions.jts.geom.Polygon;
import org.koritsas.vinnslu.models.common.Company;
import org.koritsas.vinnslu.models.topo.Topo;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.spi.MappingContext;

public class GeometryModelMapper extends ModelMapper {

    public GeometryModelMapper(){

        this.addConverter(converter());

      //  this.addMappings(createTopoPropertyMap());


    }

    private Converter<String,Polygon> converter(){

        Converter<String,Polygon> converter = new Converter<String, Polygon>() {
            @Override
            public Polygon convert(MappingContext<String, Polygon> context) {



                return  context.getSource() == null ?null: PolygonParser.parse(context.getSource());
            }
        };

        return converter;
    }


    private PropertyMap<JsonNode, Topo> createTopoPropertyMap(){
        PropertyMap<JsonNode,Topo> propertyMap = new PropertyMap<JsonNode, Topo>() {
            @Override
            protected void configure() {

                map().setMunicipality(getMunicipality(this.source));
                map().setAbl(getAbl(this.source));
                map().setLocation(getLocation(this.source));
                map().setCommunity(getCommunity(this.source));
                map().setArea(getArea(this.source));
                map().setForest(getForest(this.source));
                map().setPrefecture(getPrefecture(this.source));
                map().setTopoOwner(getTopoOwner(this.source));
                map().setAreaOwner(getAreaOwner(this.source));



            }
        };

        return propertyMap;
    }


    private String getMunicipality(JsonNode node){

        return node.get("municipality").asText();
    }

    private String getLocation(JsonNode node){
        return node.get("location").asText();
    }

    private String getCommunity(JsonNode node){
        return node.get("community").asText();
    }

    private String getPrefecture(JsonNode node){
        return node.get("prefecture").asText();
    }

    private Long getAbl(JsonNode node){
        return node.get("abl").asLong();
    }

    private double getArea(JsonNode node){
        return node.get("area").asDouble();
    }

    private boolean getForest(JsonNode node){
        return node.get("forest").asBoolean();
    }

    private Company getTopoOwner(JsonNode node){
        Company topoOwner = new Company(node.get("topoOwner").get("afm").asLong(),node.get("topoOwner").get("name").asText(),node.get("topoOwner").get("address").asText(),node.get("topoOwner").get("department").asText(),node.get("topoOwner").get("phone").asLong());

        return topoOwner;

    }

    private Company getAreaOwner(JsonNode node){
        Company areaOwner = new Company(node.get("areaOwner").get("afm").asLong(),node.get("topoOwner").get("name").asText(),node.get("topoOwner").get("address").asText(),node.get("topoOwner").get("department").asText(),node.get("topoOwner").get("phone").asLong());

        return areaOwner;
    }
}