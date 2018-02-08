package org.koritsas.vinnslu.models;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class PersonTest {

    Person person;

    @Before
    public void setUp() {
        person = new Person.PersonBuilder("Ilias","koritsas").setDepartment("fdsaf").setFathername("dimitrios").setMothername("magda").setIdCardNumber("AT 45665").setAfm(5646L).setAddress("drama").setBirthDate(new Date()).setPhone(6983836300L).build();
    }

    @After
    public void tearDown() {
        person =null;
    }

    @Test
    public void getFathername() {
        Assert.assertNotNull(person.getFathername());
    }

    @Test
    public void getMothername() {
        Assert.assertNotNull(person.getMothername());
    }

    @Test
    public void getIdCardNumber() {
        Assert.assertNotNull(person.getIdCardNumber());
    }

    @Test
    public void getDepartment() {
        Assert.assertNotNull(person.getJob());
    }

    @Test
    public void getAfm() {
        Assert.assertNotNull(person.getAfm());
    }

    @Test
    public void getName() {
        Assert.assertNotNull(person.getAfm());
    }

    @Test
    public void getPhone() {
        Assert.assertNotNull(person.getPhone());
    }
    @Test
    public void getBirthDate() {
        Assert.assertNotNull(person.getBirthDate());
    }

}