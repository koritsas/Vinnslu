package org.koritsas.vinnslu;

import com.github.kuros.random.jpa.Database;
import com.github.kuros.random.jpa.JPAContext;
import com.github.kuros.random.jpa.JPAContextFactory;
import com.github.kuros.random.jpa.types.CreationPlan;
import com.github.kuros.random.jpa.types.Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionImplementor;
import org.koritsas.vinnslu.main.models.topo.Test;
import org.koritsas.vinnslu.main.models.topo.Test_;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


@SpringBootApplication
public class VinnsluApplication {

    public static void main(String[] args) {

	ApplicationContext context = SpringApplication.run(VinnsluApplication.class, args);

        EntityManagerFactory factory= (EntityManagerFactory) context.getBean("entityManagerFactory");

        EntityManager entityManager = factory.createEntityManager();


        System.out.println("----------------------Starting kuros-----------------------------------");


        Session session = entityManager.unwrap( Session.class );
        SessionImplementor sessionImplementor = entityManager.unwrap( SessionImplementor.class );

        SessionFactory sessionFactory = entityManager.getEntityManagerFactory().unwrap( SessionFactory.class );

        sessionFactory.openSession();


        session.beginTransaction();


        JPAContext jpaContext = JPAContextFactory.newInstance(Database.POSTGRES, session)
                .generate();


        CreationPlan creationPlan = jpaContext.create(
                Entity.of(Test.class, 2),

                Entity.of(Test.class, 2).with(Test_.field2, "AAAAAAAAAAAAAAAA"),
                Entity.of(Test.class, 2).with(Test_.field3, "AAAAAAAAAAAAAAAA"),
                Entity.of(Test.class, 2).with(Test_.field4, "AAAAAAAAAAAAAAAA"),
                Entity.of(Test.class, 2).with(Test_.field5, "AAAAAAAAAAAAAAAA"),
                Entity.of(Test.class, 2).with(Test_.field6, "AAAAAAAAAAAAAAAA"),
                Entity.of(Test.class, 2).with(Test_.field7, "AAAAAAAAAAAAAAAA")

        );


        //creationPlan.set(Test_.field1,"asdfsad");

        jpaContext.persist(creationPlan);


        session.getTransaction().commit();
    }

}
