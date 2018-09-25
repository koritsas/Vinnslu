package org.koritsas.vinnslu.ws.controllers;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.geom.PrecisionModel;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.koritsas.vinnslu.models.common.Person;
import org.koritsas.vinnslu.models.topo.Topo;
import org.koritsas.vinnslu.repos.TopoRepository;
import org.koritsas.vinnslu.utils.GeometryModelMapper;
import org.koritsas.vinnslu.ws.services.TopoService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(TopoController.class)
public class TopoControllerTest {

    @MockBean
    GeometryModelMapper geometryModelMapper;

    @MockBean
    TopoService topoService;

    @MockBean
    TopoRepository topoRepository;

    @Autowired
    TopoController topoController;

    @Mock
    Topo topo1;

    @Mock
    Topo topo2;

    String JSON = "{ \"abl\": 1000, \"community\": \"SomeCommunity\", \"location\": \"SomeLocation\", \"polygon\": \"0 0,0 1,1 1\", \"prefecture\": \"SomePrefecture\" }";

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {

	//Init Mocks
	MockitoAnnotations.initMocks(this);
	mockMvc = MockMvcBuilders
	    .standaloneSetup(topoController)
	    .build();

	//Create mock objects for testing

	Person emp = new Person.PersonBuilder("sdfa", "Sdafsa").setAddress("sdf").setBirthDate(new Date()).build();

	GeometryFactory factory = new GeometryFactory(new PrecisionModel(), 2100);

	Polygon polygon1 = factory.createPolygon(
	    new Coordinate[] { new Coordinate(0, 0), new Coordinate(0, 1), new Coordinate(1, 0), new Coordinate(1, 0),
		new Coordinate(0, 0) });

	polygon1.setSRID(2100);

	Polygon polygon2 = factory.createPolygon(
	    new Coordinate[] { new Coordinate(0, 1), new Coordinate(0.5, 5), new Coordinate(5, 5),
		new Coordinate(7, 0.5), new Coordinate(1, 0), new Coordinate(1, 1),
		new Coordinate(0, 1) });

	polygon2.setSRID(2100);

	topo1 = new Topo.TopoBuilder(polygon1).setPrefecture("Δράμα").setLocation("Βράχια").setCommunity("Προσοτσάνη")
	    .setAbl(666L).build();

	topo1.setId(1L);

	topo2 = new Topo.TopoBuilder(polygon2).setPrefecture("Λάρισα").setLocation("Σαρλίκι").setCommunity("Νέες Καρυές")
	    .setAbl(667L).build();

	topo2.setId(2L);


	Mockito.when(topoRepository.findByAbl(666)).thenReturn(topo1);

	Mockito.when(topoRepository.findByAbl(667)).thenReturn(topo2);
    }

    @Test
    public void testGetAllTopos() throws Exception {

	List<Topo> topos = Arrays.asList(topo1, topo2);

	when(topoService.findAll()).thenReturn(topos);

	List<Topo> ts = topoService.findAll();

	mockMvc.perform(get("/topos")).andExpect(status().isOk())
	    .andExpect(status().is2xxSuccessful());

	mockMvc.perform(get("/topos")
	    .contentType(MediaType.APPLICATION_JSON))
	    .andExpect(status().isOk())
	    .andExpect(jsonPath("$[0].abl",is(666)))
	    .andExpect(jsonPath("$[0].prefecture", is("Δράμα")))
	    .andExpect(jsonPath("$[0].location", is("Βράχια")))
	    .andExpect(jsonPath("$[0].community", is("Προσοτσάνη")))
	    .andExpect(jsonPath("$[0].polygon", Matchers.notNullValue()))
	    .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));

    }

    @Test
    public void testCreateTopo() throws Exception {

	mockMvc.perform(post("/topos").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(JSON))
	    .andExpect(status().is(201));
    }

    @Test
    public void testDeleteTopo() throws Exception {


		when(topoRepository.findOne(1L)).thenReturn(topo1);

	when(topoService.delete(1L)).thenReturn(topo1);

	mockMvc.perform(delete("/topos/1")).andExpect(status().isOk());

	mockMvc.perform(delete("/topos/fds")).andExpect(status().is4xxClientError());

	mockMvc.perform(get("/topos/fds")).andExpect(status().is4xxClientError());

	mockMvc.perform(put("/topos/fds")).andExpect(status().is4xxClientError());

	mockMvc.perform(post("/topos/fds")).andExpect(status().is4xxClientError());

    }

    @Test
    public void testFindTopoById() throws Exception {

        when(topoRepository.findOne(1L)).thenReturn(topo1);

	when(topoService.find(1L)).thenReturn(topo1);

	mockMvc.perform(get("/topos/1")).andExpect(status().isOk());

	// mockMvc.perform(put("/topos/1")).andExpect(status().is(405));

	// mockMvc.perform(post("/topos/1")).andExpect(status().is(405));

	// mockMvc.perform(delete("/topos/1")).andExpect(status().is(405));

    }

    @Test
    public void testUpdateTopo() throws Exception {

	when(topoService.update(2L, topo2)).thenReturn(topo2);

	when(topoRepository.findOne(2L)).thenReturn(topo2);
        topo2.setCommunity("Λάρισα");

        GeometryModelMapper gmm = new GeometryModelMapper();

	String json = "{\n"
	    + "    \"id\": 1,\n"
	    + "    \"abl\": 666,\n"
	    + "    \"community\": \"Fdsad\",\n"
	    + "    \"location\": \"dfad\",\n"
	    + "    \"prefecture\": \"fdasdf\",\n"
	    + "    \"forest\": false,\n"
	    + "    \"topoOwner\": {\n"
	    + "        \"id\": 1,\n"
	    + "        \"afm\": 4532,\n"
	    + "        \"name\": \"sdfasdf\",\n"
	    + "        \"address\": \"54543\"\n"
	    + "    },\n"
	    + "    \"owner\": {\n"
	    + "        \"id\": 3,\n"
	    + "        \"afm\": 777,\n"
	    + "        \"name\": \"sadf\",\n"
	    + "        \"address\": null,\n"
	    + "        \"fathername\": null,\n"
	    + "        \"mothername\": null,\n"
	    + "        \"idCardNumber\": null,\n"
	    + "        \"job\": null,\n"
	    + "        \"surname\": \"sadfasd\",\n"
	    + "        \"phone\": null,\n"
	    + "        \"birthDate\": null\n"
	    + "    }\n"
	    + "}";

	mockMvc.perform(put("/topos").contentType("application/json").content(json)).andExpect(status().is(204));


    }

}