package org.koritsas.vinnslu.repos;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.koritsas.vinnslu.models.MiningLicense;
import org.koritsas.vinnslu.models.Person;
import org.koritsas.vinnslu.models.types.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MiningLicenseRepositoryTest {

    private MiningLicense MiningLicense1;

    private Contract contract1;

    private Person notary1;

    private MiningLicense MiningLicense2;

    private Contract contract2;

    private Person notary2;


    @Autowired
    TestEntityManager entityManager;

    @Autowired
    MiningLicenseRepository MiningLicenseRepository;

    @Before
    public void setUp() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000,1,1);

        notary1 = new Person.PersonBuilder("ilias","koritsas").build();

        contract1 = new Contract(666L,calendar.getTime(),notary1);

        MiningLicense1 = new MiningLicense.Builder(true,contract1,null,5000.00).build();

        entityManager.persist(notary1);
        // entityManager.persist(contract1);
        entityManager.persist(MiningLicense1);


        calendar = Calendar.getInstance();
        calendar.set(2010,1,1);

        notary2 = new Person.PersonBuilder("ilias","koritsas").build();

        contract2 = new Contract(777L,calendar.getTime(),notary2);

        MiningLicense2 = new MiningLicense.Builder(true,contract2,null,10000.00).build();

        entityManager.persist(notary2);
        //entityManager.persist(contract2);
        entityManager.persist(MiningLicense2);
    }

    @After
    public void tearDown() {
        contract1=null;

        contract2=null;

        MiningLicense1=null;
        MiningLicense2=null;

        notary1=null;
        notary2=null;

    }

    @Test
    public void findByTopo() {
    }

    @Test
    public void findByContract() {
        MiningLicense lic = MiningLicenseRepository.findByContract(contract1);
        Assert.assertNotNull(lic);

    }

    @Test
    public void findByEndDate() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2000,7,1);

        MiningLicense license =MiningLicenseRepository.findByEndDate(calendar.getTime());
        Assert.assertNotNull(license);



    }

    @Test
    public void findByRenewalDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000,6,1);
        MiningLicense license =MiningLicenseRepository.findByRenewalDate(calendar.getTime());

        System.out.println(MiningLicense2.getEndDate());
        System.out.println(MiningLicense1.getEndDate());
        Assert.assertNotNull(license);
    }

    @Test
    public void findIsActive() {
        List<MiningLicense> licenses=MiningLicenseRepository.findByActiveTrue();
        Assert.assertTrue(!licenses.isEmpty());
    }

    @Test
    public void findByEndDateAfter() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2007,6,1);

        List<MiningLicense> licenses = MiningLicenseRepository.findByEndDateAfter(calendar.getTime());

        Assert.assertTrue(licenses.size()==1);
        Assert.assertEquals(licenses.get(0),MiningLicense2);


    }

    @Test
    public void findByEndDateBefore() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2008,6,1);

        List<MiningLicense> licenses = MiningLicenseRepository.findByEndDateAfter(calendar.getTime());
        System.out.println(MiningLicense1.getEndDate());

        Assert.assertTrue(licenses.size()==1);
	//Assert.assertEquals(licenses.find(0),MiningLicense1);

    }

    @Test
    public void findByRenewalDateAfter() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1999,8,1);

        List<MiningLicense> licenses = MiningLicenseRepository.findByRenewalDateAfter(calendar.getTime());
        System.out.println(MiningLicense1.getRenewalDate());
        System.out.println(MiningLicense2.getRenewalDate());
        System.out.println(licenses.size());


        Assert.assertTrue(licenses.size()==2);


    }

    @Test
    public void findByRenewalDateBefore() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2008,8,1);

        List<MiningLicense> licenses = MiningLicenseRepository.findByRenewalDateAfter(calendar.getTime());
        System.out.println(MiningLicense1.getRenewalDate());
        System.out.println(MiningLicense2.getRenewalDate());
        System.out.println(licenses.size());


        Assert.assertTrue(licenses.size()==1);

    }

    @Test
    public void findByStartDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000,1,1);

        MiningLicense license = MiningLicenseRepository.findByContractContractDate(calendar.getTime());
        System.out.println(license.getContract().getContractDate());
        Assert.assertNotNull(license);

    }

    @Test
    public void findByStartDateAfter() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2008,1,1);

        List<MiningLicense> license = MiningLicenseRepository.findByContractContractDateAfter(calendar.getTime());

        Assert.assertTrue(license.size()==1);
    }

    @Test
    public void findByStartDateBefore() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2017,1,1);

        List<MiningLicense> license = MiningLicenseRepository.findByContractContractDateBefore(calendar.getTime());

        Assert.assertTrue(license.size()==2);
    }

    @Test
    public void findByArea() {
        List<MiningLicense> licenses = MiningLicenseRepository.findByArea(5000.00);
        Assert.assertTrue(licenses.size()==1);

    }

    @Test
    public void findByAreaGreaterOrThan() {
        List<MiningLicense> licenses = MiningLicenseRepository.findByAreaGreaterThan(6000.00);
        Assert.assertTrue(licenses.size()==1);

    }

    @Test
    public void findByAreaLessThan() {
        List<MiningLicense> licenses = MiningLicenseRepository.findByAreaLessThan(12000.00);
        Assert.assertTrue(licenses.size()==2);

        List<MiningLicense> licenses2 = MiningLicenseRepository.findByAreaLessThan(6000.00);
        Assert.assertTrue(licenses2.size()==1);

    }

    @Test
    public void findByAreaGreaterThanEqual() {
        List<MiningLicense> licenses = MiningLicenseRepository.findByAreaGreaterThanEqual(10000.00);
        Assert.assertTrue(licenses.size()==1);


    }

    @Test
    public void findByAreaLessThanEqual() {

        List<MiningLicense> licenses = MiningLicenseRepository.findByAreaLessThanEqual(5000.00);
        Assert.assertTrue(licenses.size()==1);
    }
}