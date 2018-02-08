package org.koritsas.vinnslu.models;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

public class EnvironmentalTermsTest {
    EnvironmentalTerms environmentalTerms;

    @Before
    public void setUp() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2010,11,10);



        environmentalTerms= new EnvironmentalTerms.EnvironmentalTermsBuilder(null,calendar.getTime(),null).build();
    }

    @After
    public void tearDown() {
        environmentalTerms=null;
    }

    @Test
    public void getStart_date() {


    }

    @Test
    public void getEnd_date() {
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2020,11,10);

        Calendar calendar3=Calendar.getInstance();
        calendar3.set(2020,11,15);

        Assert.assertTrue(calendar2.getTime().compareTo(environmentalTerms.getEndDate())==0);
        Assert.assertFalse(calendar3.getTime().compareTo(environmentalTerms.getEndDate())==0);
    }

    @Test
    public void getRenewal_date() {
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2020,8,10);


        Calendar calendar3=Calendar.getInstance();
        calendar3.set(2020,8,15);

        Assert.assertTrue(calendar2.getTime().compareTo(environmentalTerms.getRenewalDate())==0);
        Assert.assertFalse(calendar3.getTime().compareTo(environmentalTerms.getRenewalDate())==0);

    }

}