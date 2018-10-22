package org.koritsas.vinnslu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
public class VinnsluApplication {


    private EntityManager entityManager;

    public static void main(String[] args) {

	ApplicationContext context = SpringApplication.run(VinnsluApplication.class, args);



/*
    EntityManager entityManager = (EntityManager) context.getBean("entityManager");

        System.out.println(entityManager);


        System.out.println("----------------------Starting kuros-----------------------------------");


        JPAContext jpaContext = JPAContextFactory.newInstance(Database.POSTGRES, entityManager)
                .generate();

        CreationPlan creationPlan = jpaContext.create(
                Entity.of(Vehicle.class, 2),
                Entity.of(Machine.class,3));


        FakeData fakeData = new FakeData();

        fakeData.printEm();

*/


/*
	Person emp = new Person.PersonBuilder("sdfa", "Sdafsa").setAddress("sdf").setBirthDate(new Date()).build();
	GeometryFactory factory = new GeometryFactory(new PrecisionModel(), 2100);
	Polygon polygon = factory.createPolygon(
	    new Coordinate[] { new Coordinate(0, 0), new Coordinate(0, 1), new Coordinate(1, 1),
		new Coordinate(0, 0) });

	polygon.setSRID(2100);

	Polygon polygon2 = factory.createPolygon(
	    new Coordinate[] { new Coordinate(0, 0), new Coordinate(0, 1), new Coordinate(1, 1),
		new Coordinate(0, 0) });

	polygon2.setSRID(2100);



	Authority auth1 = new Authority(668L, "sadf", "sdf");

	Authority auth2 = new Authority(669L, "sadfsdf", "sdf");

	Topo topo = new Topo.TopoBuilder(polygon).setPrefecture("fdasdf").setLocation("adf").setCommunity("Fdsad")
	    .setLocation("dfad").setAbl(666L).build();


	Topo topo2 = new Topo.TopoBuilder(polygon).setPrefecture("fdasdf").setLocation("adf").setCommunity("Fdsad")
	    .setLocation("dfad").setAbl(667L).build();

	Vehicle vehicle1 = new Vehicle.Builder("XXX-666","sadfasdf", VehicleType.JEEP).build();
	Vehicle vehicle2 = new Vehicle.Builder("XXX-667","rrrrrrrr", VehicleType.CAR).setBrand("Toyota").build();

	Document doc = new Document("asdfa", "Sfdgsd", "dfgsdfg", new Date(), null);

	SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");

	context.getBean("session");
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	Company company = new Company(666L, "Hermes", "Drama");


	Person p = new Person.PersonBuilder("sadf", "sadfasd").setAfm(777L).build();

	topo.setAreaOwner(p);

	Company company1 = new Company(4532L,"sdfasdf","54543");
	session.saveOrUpdate(company1);
	session.saveOrUpdate(company);
	topo.setTopoOwner(company1);

	Vehicle v1 = new Vehicle.Builder("XXX-666","fda8343asxcsa",VehicleType.CAR).setBrand("Toyota").setColor("#f44336").setModel("RAV").setOwnerCompany(company).setExhaustCardEnd(new Date()).setSecurityEnd(new Date()).setTollsEnd(new Date()).setDriver(p).setFuel(Fuel.GASOLINE).build();

        Vehicle v2 = new Vehicle.Builder("XXX-667","fdadsafxcsa",VehicleType.CAR).setBrand("Chevrolette").setColor("#e91e63").setModel("Aveo").setOwnerCompany(company1).setExhaustCardEnd(new Date()).setSecurityEnd(new Date()).setTollsEnd(new Date()).setDriver(p).setFuel(Fuel.GAS).build();

        Vehicle v3 = new Vehicle.Builder("XXX-668","fda83kjhfsxcsa",VehicleType.CAR).setBrand("Suzuki").setColor("#4caf50").setModel("Jimny").setOwnerCompany(company).setExhaustCardEnd(new Date()).setSecurityEnd(new Date()).setTollsEnd(new Date()).setDriver(p).setFuel(Fuel.PETROL).build();

        session.save(v1);
        session.save(v2);
        session.save(v3);

	polygon.setSRID(2100);
	session.save(p);
	session.saveOrUpdate(topo);
	session.saveOrUpdate(topo2);

	session.save(auth1);
	session.save(auth2);

	//session.save(vehicle1);
	//session.save(vehicle2);

	session.save(doc);

	session.getTransaction().commit();
	session.close();



	System.out.println(polygon);

	Point point = factory.createPoint(new Coordinate(0,0));
	System.out.println(polygon.contains(point));

	//System.out.println(polygon1);
	System.out.println(
	    "llllllllllllllllllllleleleleeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeelllllllllllllllllllllllllllllllllllllllllllleeeeeeeeeeee");




	String coord="50 12,15 36,  54 89,12 45,45 89";

	GeometryModelMapper mm = new GeometryModelMapper();



	TopoDTO dto =mm.map(topo,TopoDTO.class);

	//Topo t = mm.map(dto,Topo.class);

	CompanyDto cdto = mm.map(company, CompanyDto.class);
	System.out.println(dto.getPolygon().toString());
*/
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
