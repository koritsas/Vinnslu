package org.koritsas.vinnslu.repos;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.koritsas.vinnslu.models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
    classes = { DatabaseConfiguration.class },
    loader = AnnotationConfigContextLoader.class)
@Transactional
@EnableAutoConfiguration
*/
@RunWith(SpringRunner.class)
@DataJpaTest
public class CompanyRepositoryTest {
    Company company;

    @Autowired
    TestEntityManager manager;

    @Autowired
    CompanyRepository companyRepository;

    @Before
    public void setUp() {
        company = new Company(666L,"Hermes","Drama");
        manager.persist(company);
    }

    @After
    public void tearDown() {
        company=null;
    }

    @Test
    public void findById() {
        Company company = companyRepository.findById(5298);
        Assert.assertNotNull(company);
    }

    @Test
    public void findByName() {
        Company company = companyRepository.findByName("Hermes");
        Assert.assertNotNull(company);
    }

    @Test
    public void findByAfm() {
        Company company = companyRepository.findByAfm(666L);
        Assert.assertNotNull(company);
    }

    @Test
    public void findByAddress() {
        List<Company> company = companyRepository.findByAddress("Drama");
        Assert.assertFalse(company.isEmpty());
    }

    @Test
    public void findByAddressLike() {
        List<Company> company = companyRepository.findByAddressLike("Dramas");
        System.out.println(company.isEmpty());
        Assert.assertFalse(company.isEmpty());
    }

    @Test
    public void findByAddressIsNull(){
        List<Company> companies =companyRepository.findByAddressIsNull();
        Assert.assertTrue(companies.isEmpty());

    }
}