package org.koritsas.vinnslu.utils;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;
import org.koritsas.vinnslu.models.exceptions.BadPolygonFormatException;

public class PolygonParser {
    private static String SPLIT_POINT_DELIMETER = ",";

    private static String SPLIT_COORDS_DELIMETER = "\\s+";

    private static String MESSAGE = " Wrong polygon string format! The correct format is: x1 y1,x2 y2, ... ,xn yn";


    public static Polygon parse(String polygonString) throws BadPolygonFormatException {

	String[] pointTokens = polygonString.trim().split(SPLIT_POINT_DELIMETER);

	Coordinate[] coordinates = new Coordinate[pointTokens.length+1];

	GeometryFactory geometryFactory = new GeometryFactory();
    try {

	for (int i = 0; i < pointTokens.length; i++) {

	    String[] coords = pointTokens[i].trim().split(SPLIT_COORDS_DELIMETER);

	    coordinates[i] = new Coordinate(Double.parseDouble(coords[0]), Double.parseDouble(coords[1]));
	}

	coordinates[coordinates.length-1] = coordinates[0];



    }catch (Exception e){
	throw new BadPolygonFormatException(MESSAGE);
    }

	Polygon polygon =geometryFactory.createPolygon(coordinates);

    	polygon.setSRID(2100);
	return polygon;


	//Stream.of(polygon).map(s -> s.split(SPLIT_POINT_DELIMETER)).forEach(strings -> Stream.of(strings).map(s -> s.split(SPLIT_COORDS_DELIMETER)).toArray(String[]::new));
    }
}
