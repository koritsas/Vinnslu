package org.koritsas.vinnslu.models;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.koritsas.vinnslu.models.types.Contract;

import java.util.Calendar;
import java.util.Date;


public class ResearchLicenceTest {

    ResearchLicense licence;

    @Before
    public void setUp() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000,5,15);

        Contract contract = new Contract(1L,calendar.getTime(),null);

        Contract contract2 = new Contract(2L,calendar.getTime(),null);

        licence= new ResearchLicense.Builder(true,contract,null,4231).setArea(10000.150).setActive(false).setContract(contract2).build();


    }

    @After
    public void tearDown() {
        licence = null;
    }

    @Test
    public void getEndDate() {
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2000,11,15);

        Calendar calendar3=Calendar.getInstance();
        calendar3.set(2020,11,15);

        System.out.println(licence.getEndDate());
        System.out.println(calendar2.getTime());

        Date end=licence.getEndDate();


        Assert.assertTrue(calendar2.getTime().compareTo(end)==0);
        Assert.assertFalse(calendar3.getTime().compareTo(licence.getEndDate())==0);

    }

    @Test
    public void getRenewalDate() {

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2000,10,15);

        Calendar calendar3=Calendar.getInstance();
        calendar3.set(2020,11,15);

        System.out.println(licence.getRenewalDate());
        System.out.println(calendar2.getTime());




        Assert.assertTrue(calendar2.getTime().compareTo(licence.getRenewalDate())==0);
        Assert.assertFalse(calendar3.getTime().compareTo(licence.getRenewalDate())==0);
    }

    @Test
    public void getActive() {
        Assert.assertFalse(licence.getActive());
    }

    @Test
    public void getTopo() {


    }

    @Test
    public void getContract() {
        Assert.assertNotNull(licence.getContract());
        Assert.assertTrue(licence.getContract().getContractId()==2);
    }



    @Test
    public void getArea() {
        Assert.assertTrue(licence.getArea()==10000.150);
    }
}