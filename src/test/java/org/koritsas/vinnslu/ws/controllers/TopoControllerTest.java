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
import org.koritsas.vinnslu.ws.services.TopoService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(TopoController.class)
public class TopoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    GeometryModelMapper geometryModelMapper;

    @MockBean
    TopoService topoService;

    @MockBean
    TopoRepository topoRepository;

    @Autowired
    TopoController topoController;


    Topo topo1;

    Topo topo2;

    String JSON= "{ \"abl\": 1000, \"community\": \"SomeCommunity\", \"location\": \"SomeLocation\", \"polygon\": \"0 0,0 1,1 1\", \"prefecture\": \"SomePrefecture\" }";



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
	    new Coordinate[] { new Coordinate(0, 0), new Coordinate(0, 1), new Coordinate(1, 0),new Coordinate(1, 0),
		new Coordinate(0, 0) });

	polygon1.setSRID(2100);

	Polygon polygon2 = factory.createPolygon(
	    new Coordinate[] { new Coordinate(0, 1), new Coordinate(0.5, 5), new Coordinate(5, 5), new Coordinate(7, 0.5),new Coordinate(1, 0),new Coordinate(1, 1),
		new Coordinate(0, 1) });

	polygon2.setSRID(2100);

	topo1 = new Topo.TopoBuilder(polygon1).setPrefecture("Δράμα").setLocation("Βράχια").setCommunity("Προσοτσάνη")
	    .setAbl(666).build();


	topo2 = new Topo.TopoBuilder(polygon2).setPrefecture("Δράμα").setLocation("Βράχια").setCommunity("Προσοτσάνη")
	    .setAbl(667).build();


	Mockito.when(topoRepository.findByAbl(666)).thenReturn(topo1);

	Mockito.when(topoRepository.findByAbl(667)).thenReturn(topo2);
    }

    @Test
    public void testGetAllTopos() throws Exception {

	List<Topo> topos = Arrays.asList(topo1,topo2);



	when(topoService.getAllTopos()).thenReturn(topos);

	List<Topo> ts = topoService.getAllTopos();

        mockMvc.perform(get("/topos/getAllTopos")).andExpect(status().isOk())
	    .andExpect(status().is2xxSuccessful());

	mockMvc.perform(get("/topos/getAllTopos")
	    .contentType(MediaType.APPLICATION_JSON))
	    .andExpect(status().isOk())
	    .andExpect(jsonPath("$[0].prefecture", is("Δράμα")))
	    .andExpect(jsonPath("$[0].location",is("Βράχια")))
	    .andExpect(jsonPath("$[0].community",is("Προσοτσάνη")))
	    .andExpect(jsonPath("$[0].polygon", Matchers.notNullValue()));


    }


}