package org.koritsas.vinnslu.ws.controllers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.koritsas.vinnslu.models.Person;
import org.koritsas.vinnslu.repos.PersonRepository;
import org.koritsas.vinnslu.utils.GeometryModelMapper;
import org.koritsas.vinnslu.ws.services.PersonService;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {

    @MockBean
    GeometryModelMapper geometryModelMapper;

    @MockBean
    PersonService personService;

    @MockBean
    PersonRepository personRepository;

    @Autowired
    PersonController personController;

    @Autowired
    MockMvc mockMvc;

    Person person;

    @Before
    public void setUp() {

	MockitoAnnotations.initMocks(this);
	mockMvc = MockMvcBuilders
	    .standaloneSetup(personController)
	    .build();

	person = new Person.PersonBuilder("Ilias", "Koritsas")
	    .setFathername("Dimitrios")
	    .setMothername("Magdalini")
	    .setAfm(666L)
	    .setIdCardNumber("AB 3265")
	    .setPhone(666666L)
	    .setDepartment("Surveying")
	    .build();

	when(personRepository.findOne(1L)).thenReturn(person);

	when(personService.findPerson(1L)).thenReturn(person);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testFindAllPersons() throws Exception {

	mockMvc.perform(get("/find/all")).andExpect(status().isOk())
	    .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));

    }

    @Test
    public void testFindPerson() throws Exception {
	mockMvc.perform(get("/find/1")).andExpect(status().isOk())
	    .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
	    .andExpect(jsonPath("$.name", is("Ilias")))
	    .andExpect(jsonPath("$.surname", is("Koritsas")))
	    .andExpect(jsonPath("$.afm", is(666)));

    }

    @Test
    public void testDeletePerson() throws Exception {

	when(personService.deletePerson(1L)).thenReturn(person);

	when(personService.findPerson(1L)).thenReturn(person);

	mockMvc.perform(delete("/delete/1")).andExpect(status().isOk())
	    .andExpect(content().string("Deleted person with id: " + person.getId()));

    }
}