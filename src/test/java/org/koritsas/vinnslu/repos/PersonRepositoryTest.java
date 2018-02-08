package org.koritsas.vinnslu.repos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.koritsas.vinnslu.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTest {

    Person person;

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    PersonRepository personRepository;

    @Before
    public void setUp(){

        this.person = new Person.PersonBuilder("Ilias","Koritsas").setBirthDate(new Date()).setDepartment("Surveying").setMothername("Magda").setFathername("Dimitrios").setAfm(666L).setPhone(6983836300L).build();

        entityManager.persist(person);
    }

    @Test
    public void findByNameAndSurname() {
        Person p=personRepository.findByNameAndSurname("Ilias","Koritsas");
        Assert.assertEquals(p,person);
    }

    @Test
    public void findByNameAndSurnameAndFathername() {
        Person p = personRepository.findByNameAndSurnameAndFathername("Ilias","Koritsas","Dimitrios");
	Assert.assertEquals(p,person);
    }

    @Test
    public void findByPhone() {
        Person p = personRepository.findByPhone(6983836300L);
	Assert.assertEquals(p,person);
    }

    @Test
    public void findBySurnameStartingWith() {
	List<Person> personList = personRepository.findBySurnameStartingWith("Kor");
	Assert.assertFalse(personList.isEmpty());
    }

    @Test
    public void findByNameStartingWith() {
	List<Person> personList = personRepository.findByNameStartingWith("Il");
	Assert.assertFalse(personList.isEmpty());
    }

    @Test
    public void findBySurnameLike() {
	List<Person> personList = personRepository.findBySurnameStartingWith("Kor");
	Assert.assertFalse(personList.isEmpty());
    }

    @Test
    public void findByBirthDate() {

    }

    @Test
    public void findByAfm(){
        Person p = (Person) personRepository.findByAfm(666L);
        Assert.assertEquals(p,person);
    }
}