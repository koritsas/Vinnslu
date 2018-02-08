package org.koritsas.vinnslu.models;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

public class TechinalStudyTest {

    TechinalStudy techinalStudy;
    @Before
    public void setUp() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2004,11,11);

        //TechinalStudy.TechincalStudyBuilder builder = new TechinalStudy.TechincalStudyBuilder(null,true);


        techinalStudy = new TechinalStudy.TechincalStudyBuilder(null,true,null).setStartDate(calendar.getTime()).build();
    }

    @After
    public void tearDown() {
        techinalStudy=null;
    }

    @Test
    public void getStart_date() {


    }


    @Test
    public void getEndDate() {
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2019,11,11);

        Calendar calendar3=Calendar.getInstance();
        calendar3.set(2020,11,15);

        System.out.println(calendar2.getTime());
        System.out.println(techinalStudy.getEndDate());

        Assert.assertTrue(calendar2.getTime().compareTo(techinalStudy.getEndDate())==0);
        Assert.assertFalse(calendar3.getTime().compareTo(techinalStudy.getEndDate())==0);
    }

    @Test
    public void getRenewalDate() {
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2019,8,11);

        Calendar calendar3=Calendar.getInstance();
        calendar3.set(2020,8,15);

        Assert.assertTrue(calendar2.getTime().compareTo(techinalStudy.getRenewalDate())==0);
        Assert.assertFalse(calendar3.getTime().compareTo(techinalStudy.getRenewalDate())==0);

    }

}