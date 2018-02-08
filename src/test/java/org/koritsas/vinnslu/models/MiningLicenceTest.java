package org.koritsas.vinnslu.models;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.koritsas.vinnslu.models.types.Contract;

import java.util.Calendar;
import java.util.Date;

public class MiningLicenceTest {

    MiningLicense licence;

    @Before
    public void setUp() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000,5,15);

        licence = new MiningLicense.Builder(true,new Contract(666L,calendar.getTime(),null),null,90000.00).build();
    }

    @After
    public void tearDown() {
        licence = null;
    }

    @Test
    public void getEndDate() {
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2020,5,15);

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
        calendar2.set(2018,2,15);

        Calendar calendar3=Calendar.getInstance();
        calendar3.set(2020,11,15);

        System.out.println(licence.getRenewalDate());
        System.out.println(calendar2.getTime());




        Assert.assertTrue(calendar2.getTime().compareTo(licence.getRenewalDate())==0);
        Assert.assertFalse(calendar3.getTime().compareTo(licence.getRenewalDate())==0);
    }
}