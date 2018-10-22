package org.koritsas.vinnslu.repos;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.koritsas.vinnslu.models.common.Company;
import org.koritsas.vinnslu.models.common.Person;
import org.koritsas.vinnslu.models.topo.Topo;
import org.koritsas.vinnslu.repos.topo.TopoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TopoRepositoryTest{


    Person person;

    Company company;

    GeometryFactory geometryFactory;

    Topo topo;


    @Autowired
    TestEntityManager manager;

    @Autowired
    TopoRepository topoRepository;

    @Before
    public void setUp(){
	geometryFactory = new GeometryFactory();

	WKTReader reader = new WKTReader();

	Polygon polygon=null;

	try {
	    //polygon = (Polygon) reader.read("POLYGON (" +
		//"(500335.242 4568795.566, 500534.389 4568858.461, 500531.180 4568584.069, 500349.825 4568517.968, 500335.242 4568795.566)");
	    polygon = (Polygon) reader.read("POLYGON (" +
		"(30 10, 40 40, 20 40, 10 20, 30 10), " +
		"(20 30, 35 35, 30 20, 20 30))");
	} catch (ParseException e) {
	    e.printStackTrace();
	}

	company = new Company(666L,"hermes","drama");
	person = new Person.PersonBuilder("ilias","koritsas").setBirthDate(new Date()).build();
	topo = new Topo.TopoBuilder(polygon).setAbl(1234L).setOwner(company).setCommunity("Braxia")
	    .setLocation("Prosotsani").setTopoOwner(person).setForest(true).setPrefecture("Drama").build();
	Topo topo2 = new Topo.TopoBuilder(polygon).setAbl(2134L).setOwner(company).setCommunity("Braxia")
	    .setForest(false).setLocation("Prosotsani").setTopoOwner(person).setPrefecture("Drama").build();
	Topo topo3 = new Topo.TopoBuilder(polygon).setAbl(3214L).setOwner(company).setCommunity("Braxia")
	    .setForest(false).setLocation("Prosotsani").setTopoOwner(person).setPrefecture("Drama").build();


	this.manager.persist(company);
	this.manager.persist(person);
	this.manager.persist(topo);
	this.manager.persist(topo2);
	this.manager.persist(topo3);

	//topoRepository.save(topo);
	//topoRepository.save(topo2);
	//topoRepository.save(topo3);



    }

    @After
    public void tearDown(){

    }

    @Test
    public void findById(){
        Topo t = topoRepository.findOne(topo.getId());

	System.out.println(topo.toString());
        Assert.assertNotNull(t);

    }

    @Test
    public void findByAbl() {

        Topo topo = this.topoRepository.findByAbl(1234);
	Assert.assertNotNull(topo);
	Assert.assertEquals(java.util.Optional.ofNullable(topo.getAbl()), 1234L);
    }

    @Test
    public void findByForest() {
	List<Topo> topos = this.topoRepository.findByForest(true);
	Assert.assertNotNull(topos);
	Assert.assertFalse(topos.isEmpty());

	topos=this.topoRepository.findByForest(false);
	Assert.assertTrue(topos.isEmpty() == false);
	Assert.assertTrue(topos.size() == 2);


    }

    @Test
    public void findByCommunity() {
        List<Topo> topos = this.topoRepository.findByCommunity("Braxia");
        Assert.assertFalse(topos.isEmpty());
    }

    @Test
    public void findByLocation() {
        List<Topo> topos = this.topoRepository.findByLocation("Prosotsani");
	Assert.assertFalse(topos.isEmpty());
	Assert.assertTrue(topos.size() == 3);
    }

    @Test
    public void findByPrefecture() {
	List<Topo> topos = this.topoRepository.findByPrefecture("Drama");
	Assert.assertFalse(topos.isEmpty());
	Assert.assertTrue(topos.size() == 3);
    }

    @Test
    public void findByTopoOwner() {
	List<Topo> topos = this.topoRepository.findByTopoOwner(person);
	Assert.assertTrue(topos.get(0).getTopoOwner().getName() == "ilias");

    }



    @Test
    public void findByPoint() {
	Point point = geometryFactory.createPoint(new Coordinate(20,20));

	System.out.println(point.intersects(geometryFactory.createGeometry(point)));
	point.getBoundary();

        Topo topo = topoRepository.findByPolygonContains(point);
        Assert.assertNotNull(topo);
    }


    @Test
    public void findByIntersection() {

    }
}