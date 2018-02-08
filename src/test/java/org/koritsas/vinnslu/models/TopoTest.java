package org.koritsas.vinnslu.models;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TopoTest {

    private Topo topo;
    @Before
    public void setUp() {

        GeometryFactory factory = new GeometryFactory();
        Polygon polygon = factory.createPolygon(new Coordinate[]{new Coordinate(0,0),new Coordinate(0,1),new Coordinate(1,1),new Coordinate(0,0)});

        Company company = new Company.CompanyBuilder("drama").build();
        Person person = new Person.PersonBuilder("Ilias","koritsas").build();


        topo = new Topo.TopoBuilder(polygon).setLocation("Bouri").setPrefecture("Drama").setForest(false).setCommunity("Pyrgoi").setAbl(666).setOwner(company).setTopoOwner(
            person).build();



    }

    @After
    public void tearDown() {
        topo=null;
    }

    @Test
    public void getAbl() {

        Assert.assertNotNull(topo.getAbl());
    }

    @Test
    public void getPolygon() {
        Assert.assertNotNull(topo.getPolygon());
    }

    @Test
    public void getCommunity() {
        Assert.assertNotNull(topo.getCommunity());
    }

    @Test
    public void getLocation() {
        Assert.assertNotNull(topo.getLocation());
    }

    @Test
    public void getPrefecture() {
        Assert.assertNotNull(topo.getPrefecture());
    }

    @Test
    public void getForest() {
        Assert.assertNotNull(topo.getForest());
    }

    @Test
    public void getTopoOwner() {
        Assert.assertNotNull(topo.getTopoOwner());
    }

    @Test
    public void getOwner() {
        Assert.assertNotNull(topo.getOwner());
    }
}