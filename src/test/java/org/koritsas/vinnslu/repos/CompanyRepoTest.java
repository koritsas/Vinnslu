package org.koritsas.vinnslu.repos;

import com.github.kuros.random.jpa.Database;
import com.github.kuros.random.jpa.JPAContext;
import com.github.kuros.random.jpa.JPAContextFactory;
import com.github.kuros.random.jpa.persistor.model.ResultMap;
import com.github.kuros.random.jpa.types.Entity;
import org.junit.runner.RunWith;
import org.koritsas.vinnslu.repos.common.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CompanyRepoTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CompanyRepository repository;

}
