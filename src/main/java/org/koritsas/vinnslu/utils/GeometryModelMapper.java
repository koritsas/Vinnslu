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
    }

}