package org.koritsas.vinnslu.ws.controllers;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.geom.PrecisionModel;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.koritsas.vinnslu.models.Person;
import org.koritsas.vinnslu.models.Topo;
import org.koritsas.vinnslu.repos.TopoRepository;
import org.koritsas.vinnslu.utils.GeometryModelMapper;
import org.koritsas.vinnslu.ws.dto.TopoDto;
import org.koritsas.vinnslu.ws.services.TopoService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.modelmapper.ModelMapper;
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
	    .setAbl(666).build();

	topo1.setId(1L);

	topo2 = new Topo.TopoBuilder(polygon2).setPrefecture("Λάρισα").setLocation("Σαρλίκι").setCommunity("Νέες Καρυές")
	    .setAbl(667).build();

	topo2.setId(2L);


	Mockito.when(topoRepository.findByAbl(666)).thenReturn(topo1);

	Mockito.when(topoRepository.findByAbl(667)).thenReturn(topo2);
    }

    @Test
    public void testGetAllTopos() throws Exception {

	List<Topo> topos = Arrays.asList(topo1, topo2);

	when(topoService.getAllTopos()).thenReturn(topos);

	List<Topo> ts = topoService.getAllTopos();

	mockMvc.perform(get("/topos/all")).andExpect(status().isOk())
	    .andExpect(status().is2xxSuccessful());

	mockMvc.perform(get("/topos/all")
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

	mockMvc.perform(post("/topos/create").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(JSON))
	    .andExpect(status().isOk());
    }

    @Test
    public void testDeleteTopo() throws Exception {


		when(topoRepository.findOne(1L)).thenReturn(topo1);

		when(topoService.deleteTopo(1L)).thenReturn(topo1);

        mockMvc.perform(delete("/topos/delete/1")).andExpect(status().isOk()).andExpect(content().string("Deleted: " + topo1.getId()));

        mockMvc.perform(delete("/topos/delete/fds")).andExpect(status().is4xxClientError());

        mockMvc.perform(get("/topos/delete/fds")).andExpect(status().is(405));

        mockMvc.perform(put("/topos/delete/fds")).andExpect(status().is(405));

        mockMvc.perform(post("/topos/delete/fds")).andExpect(status().is(405));

    }

    @Test
    public void testFindTopoById() throws Exception {

        when(topoRepository.findOne(1L)).thenReturn(topo1);

        when(topoService.findById(1L)).thenReturn(topo1);

        mockMvc.perform(get("/topos/find/1")).andExpect(status().isOk());

        mockMvc.perform(put("/topos/find/1")).andExpect(status().is(405));

        mockMvc.perform(post("/topos/find/1")).andExpect(status().is(405));

        mockMvc.perform(delete("/topos/find/1")).andExpect(status().is(405));

    }
/*
    @Test
    public void testUpdateTopo() throws Exception {

        when(topoService.updateTopo(topo2)).thenReturn(topo2);

        topo2.setCommunity("Λάρισα");

        GeometryModelMapper gmm = new GeometryModelMapper();

        mockMvc.perform(put("/topos/update/1").contentType("application/json").content(gmm.map(topo2, TopoDto.class).toString())).andExpect(status().isOk()).andExpect(jsonPath("$.community",is("Λάρισα")));

    }
    */
}