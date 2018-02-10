package org.koritsas.vinnslu;

import com.vividsolutions.jts.geom.*;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import org.geolatte.geom.codec.Wkt;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.koritsas.vinnslu.models.Company;
import org.koritsas.vinnslu.models.Person;
import org.koritsas.vinnslu.models.Topo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

@SpringBootApplication
public class VinnsluApplication {

    public static void main(String[] args) {

	ApplicationContext context = SpringApplication.run(VinnsluApplication.class, args);

	Person emp = new Person.PersonBuilder("sdfa", "Sdafsa").setAddress("sdf").setBirthDate(new Date()).build();
	GeometryFactory factory = new GeometryFactory(new PrecisionModel(), 2100);
	Polygon polygon = factory.createPolygon(
	    new Coordinate[] { new Coordinate(0, 0), new Coordinate(0, 1), new Coordinate(1, 1),
		new Coordinate(0, 0) });

	polygon.setSRID(2100);

	org.geolatte.geom.Polygon polygon1 = (org.geolatte.geom.Polygon) Wkt.fromWkt("POLYGON (" +
	    "(30 10, 40 40, 20 40, 10 20, 30 10), " +
	    "(20 30, 35 35, 30 20, 20 30))");

	WKTReader reader = new WKTReader();

	try {
	    polygon = (Polygon) reader.read("POLYGON (" +
		"(30 10, 40 40, 20 40, 10 20, 30 10), " +
		"(20 30, 35 35, 30 20, 20 30))");
	} catch (ParseException e) {
	    e.printStackTrace();
	}

	Topo topo = new Topo.TopoBuilder(polygon).setPrefecture("fdasdf").setLocation("adf").setCommunity("Fdsad")
	    .setLocation("dfad").setAbl(666).build();

	SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	Company company = new Company(666L, "safdsa", "sadfasd");

	Person p = new Person.PersonBuilder("sadf", "sadfasd").setAfm(777L).build();

	topo.setOwner(p);

	Company company1 = new Company(4532L,"sdfasdf","54543");
	session.saveOrUpdate(company1);
	topo.setTopoOwner(company1);


	polygon.setSRID(2100);
	session.save(p);
	session.saveOrUpdate(topo);

	session.getTransaction().commit();
	session.close();

	System.out.println(polygon);

	Point point = factory.createPoint(new Coordinate(0,0));
	System.out.println(polygon.contains(point));

	//System.out.println(polygon1);
	System.out.println(
	    "llllllllllllllllllllleleleleeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeelllllllllllllllllllllllllllllllllllllllllllleeeeeeeeeeee");





    }

}
