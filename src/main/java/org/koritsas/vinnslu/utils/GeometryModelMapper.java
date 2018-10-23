package org.koritsas.vinnslu.utils;

import com.vividsolutions.jts.geom.Polygon;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;

public class GeometryModelMapper extends ModelMapper {

    public GeometryModelMapper(){
        this.addConverter(converter());
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

}