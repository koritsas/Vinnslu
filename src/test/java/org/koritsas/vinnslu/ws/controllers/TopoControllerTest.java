package org.koritsas.vinnslu.ws.controllers;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.geom.PrecisionModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.koritsas.vinnslu.models.Person;
import org.koritsas.vinnslu.models.Topo;
import org.koritsas.vinnslu.ws.services.TopoService;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)

public class TopoControllerTest {

    private MockMvc mockMvc;

    @Mock
    TopoService topoService;

    @Mock
    //@InjectMocks
    TopoController topoController;


    Topo topo1;

    Topo topo2;


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



    }

    @Test
    public void testGetAllTopos() throws Exception {

	List<Topo> topos = Arrays.asList(topo1,topo2);

	when(topoService.getAllTopos()).thenReturn(topos);



        mockMvc.perform(get("/topos/getAllTopos")).andExpect(status().isOk()) .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));



        verify(topoController,times(1)).getAllTopos();

        verifyNoMoreInteractions(topoService);
    }

    @Test
    public void TestTopoController(){
	System.out.println(mockMvc.toString());
    }


}