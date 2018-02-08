package org.koritsas.vinnslu.models;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CompanyTest {

    Company company;
    @Before
    public void setUp() {

        company= new Company.CompanyBuilder("hermes").setAddress("dfasd").setAfm(111L).build();
    }

    @After
    public void tearDown() {
        company=null;
    }

    @Test
    public void getAfm() {
        Assert.assertNotNull(company.getAfm());
    }

    @Test
    public void getName() {
        Assert.assertNotNull(company.getAfm());
    }

    @Test
    public void getAddress() {
        Assert.assertNotNull(company.getAddress());
    }
}