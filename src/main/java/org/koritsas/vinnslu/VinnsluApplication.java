package org.koritsas.vinnslu;

import com.github.kuros.random.jpa.Database;
import com.github.kuros.random.jpa.JPAContext;
import com.github.kuros.random.jpa.JPAContextFactory;
import com.github.kuros.random.jpa.link.Dependencies;
import com.github.kuros.random.jpa.link.Link;
import com.github.kuros.random.jpa.types.CreationPlan;
import com.github.kuros.random.jpa.types.Entity;
import com.github.kuros.random.jpa.types.Plan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionImplementor;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.common.Opinion;
import org.koritsas.vinnslu.main.models.common.Person;
import org.koritsas.vinnslu.main.models.metamodels.Company_;
import org.koritsas.vinnslu.main.models.metamodels.Person_;
import org.koritsas.vinnslu.main.models.metamodels.Topo_;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


@SpringBootApplication
public class VinnsluApplication {

    public static void main(String[] args) {

	ApplicationContext context = SpringApplication.run(VinnsluApplication.class, args);

    String[] names = context.getBeanDefinitionNames();

        System.out.println("----------------------------------BEANS----------------------------------------");
    for(String name:names){
      //  System.out.println(name);
    }





       // Topo_ t= mapper.map(topoGeoJson,Topo_.class);


/*
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule("GeoJsonDeserializer");

        simpleModule.addDeserializer(TopoDTO.class,new GeoJsonDeserializer());

        objectMapper.registerModule(simpleModule);

        try {
            TopoDTO topo = objectMapper.readValue(topoGeoJson, TopoDTO.class);

            System.out.println(topo.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
*/


   EntityManagerFactory factory= (EntityManagerFactory) context.getBean("entityManagerFactory");

    EntityManager entityManager= factory.createEntityManager();





        Session session = entityManager.unwrap( Session.class );
        SessionImplementor sessionImplementor = entityManager.unwrap( SessionImplementor.class );

        SessionFactory sessionFactory = entityManager.getEntityManagerFactory().unwrap( SessionFactory.class );



        sessionFactory.openSession();
        session.beginTransaction();




        Plan plan = Plan.create();

        Dependencies dependencies = Dependencies.newInstance();
       // dependencies.withLink(Link.newLink(Company_.id,Topo_.id));
      //  dependencies.withLink(Link.newLink(Company_.id,Topo_.id));

        JPAContext jpaContext = JPAContextFactory.newInstance(Database.POSTGRES, session).with(dependencies)
                .generate();


        CreationPlan creationPlan = jpaContext.create(
               Entity.of(Company.class,10),
             Entity.of(Person_.class,10)
             //  Entity.of(Topo.class,10)
        );


        jpaContext.persist(creationPlan);



        session.getTransaction().commit();

        session.close();









/*

	Person emp = new Person(5563,"fsadfas","sadfasf","sdafasfasd",56312,"ASdfas","asdfasdf","sdfasdfsa","Sdfasdf","asdfasdfas",new Date());
	GeometryFactory factory = new GeometryFactory(new PrecisionModel(), 2100);
	Polygon polygon = factory.createPolygon(
	    new Coordinate[] { new Coordinate(0, 0), new Coordinate(0, 1), new Coordinate(1, 1),
		new Coordinate(0, 0) });

	polygon.setSRID(2100);

	Polygon polygon2 = factory.createPolygon(
	    new Coordinate[] { new Coordinate(0, 0), new Coordinate(0, 1), new Coordinate(1, 1),
		new Coordinate(0, 0) });

	polygon2.setSRID(2100);



	Authority auth1 = new Authority(556544,"sadfasdf","ASdfasdfas","dfsadfa",4565);

	Authority auth2 = new Authority(885, "sadfsdf", "sdf","asdfasdf",4532);


        Company company = new Company(666, "Hermes", "Drama","fdasfsa",5524);


        Person p = new Person();

        p.setName("sdfsaf");



        Company company1 = new Company(4532,"sdfasdf","54543","Asdfsad",565685);

	Topo_ topo = new Topo_(polygon);
	topo.setCommunity("sdfa");
	topo.setMunicipality("sadfasd");
	topo.setLocation("sdfasdfsa");
	topo.setAbl(666L);
	topo.setTopoOwner(company);
	topo.setAreaOwner(auth2);


        Topo_ topo2 = new Topo_(polygon2);
        topo.setCommunity("sdfa");
        topo.setMunicipality("sadfasd");
        topo.setLocation("sdfasdfsa");
        topo.setAbl(667L);
        topo.setTopoOwner(company1);
        topo.setAreaOwner(auth2);





	Vehicle vehicle1 = new Vehicle.Builder("XXX-666","sadfasdf", VehicleType.JEEP).build();
	Vehicle vehicle2 = new Vehicle.Builder("XXX-667","rrrrrrrr", VehicleType.CAR).setBrand("Toyota").build();

        topo.setTopoOwner(company1);

        Vehicle v1 = new Vehicle.Builder("XXX-666","fda8343asxcsa",VehicleType.CAR).setBrand("Toyota").setColor("#f44336").setModel("RAV").setOwnerCompany(company).setExhaustCardEnd(new Date()).setSecurityEnd(new Date()).setTollsEnd(new Date()).setDriver(p).setFuel(Fuel.GASOLINE).build();

        Vehicle v2 = new Vehicle.Builder("XXX-667","fdadsafxcsa",VehicleType.CAR).setBrand("Chevrolette").setColor("#e91e63").setModel("Aveo").setOwnerCompany(company1).setExhaustCardEnd(new Date()).setSecurityEnd(new Date()).setTollsEnd(new Date()).setDriver(p).setFuel(Fuel.GAS).build();

        Vehicle v3 = new Vehicle.Builder("XXX-668","fda83kjhfsxcsa",VehicleType.CAR).setBrand("Suzuki").setColor("#4caf50").setModel("Jimny").setOwnerCompany(company).setExhaustCardEnd(new Date()).setSecurityEnd(new Date()).setTollsEnd(new Date()).setDriver(p).setFuel(Fuel.PETROL).build();


        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");

	context.getBean("session");
	Session session = sessionFactory.openSession();
	session.beginTransaction();


	session.saveOrUpdate(company1);
	session.saveOrUpdate(company);

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



	session.getTransaction().commit();
	session.close();



	System.out.println(polygon);


	//System.out.println(polygon1);
	System.out.println(
	    "llllllllllllllllllllleleleleeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeelllllllllllllllllllllllllllllllllllllllllllleeeeeeeeeeee");








    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
        */
    }

}
