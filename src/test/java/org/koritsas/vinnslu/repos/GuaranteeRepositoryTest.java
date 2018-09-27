package org.koritsas.vinnslu.repos;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.koritsas.vinnslu.models.common.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
public class GuaranteeRepositoryTest {

    Company company;

    Guarantee guarantee;

    Guarantee.GuaranteeLetter letter;

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    GuaranteeRepository guaranteeRepository;

    @Before
    public void setUp() {
        letter = new Guarantee.GuaranteeLetter(5000.00,"National","666");

        company = new Company(666L,"Hermes","Drama");

        guarantee = new Guarantee(letter,company,false, GuaranteeLetterType.ENVIRONMENTAL,null);

        entityManager.persist(company);
        entityManager.persist(guarantee);
    }

    @After
    public void tearDown() {
        guarantee = null;
    }

    @Test
    public void findByGuaranteeLetter() {

	Guarantee guarantee = guaranteeRepository.findByGuaranteeLetter(this.letter);
	Assert.assertEquals(guarantee,this.guarantee);

    }

    @Test
    public void findByCompany() {
        List<Guarantee> guarantee = guaranteeRepository.findByCompany(company);
        Assert.assertFalse(guarantee.isEmpty());
        Assert.assertEquals(guarantee.get(0),this.guarantee);

    }

    @Test
    public void findByGuaranteeLetterType() {
        List<Guarantee> guarantees =guaranteeRepository.findByGuaranteeLetterType(GuaranteeLetterType.ENVIRONMENTAL);
        Assert.assertTrue(!guarantees.isEmpty());

    }

    @Test
    public void findByComplementary() {
	List<Guarantee> guarantees =guaranteeRepository.findByComplementary(false);
	Assert.assertTrue(!guarantees.isEmpty());
    }

    @Test
    public void findByLetterNumber() {
        Guarantee guarantee = guaranteeRepository.findByLetterNumber("666");
        Assert.assertEquals(this.guarantee,guarantee);
    }

    @Test
    public void findByMoneyAmount() {
        List<Guarantee> guarantee =  guaranteeRepository.findByMoneyAmount(5000.00);
	Assert.assertTrue(!guarantee.isEmpty());
    }

    @Test
    public void findByOrganization() {
        List<Guarantee> guarantees = guaranteeRepository.findByOrganization("National");
	Assert.assertTrue(!guarantees.isEmpty());
    }
}