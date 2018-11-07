package org.koritsas.vinnslu.ws.controllers.vehicles;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.koritsas.vinnslu.models.types.VehicleType;
import org.koritsas.vinnslu.models.vehicles.Vehicle;
import org.koritsas.vinnslu.utils.GeometryModelMapper;
import org.koritsas.vinnslu.ws.services.vehicles.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;


import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.*;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@WebMvcTest(VehicleController.class)
public class VehicleControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private GeometryModelMapper mapper;

    @MockBean
    private VehicleService service;





    Vehicle vehicle1;

    Vehicle vehicle2;

    @Before
    public void setUp() {

        vehicle1 = new Vehicle.Builder("XXX-111","fds45as21f153sd", VehicleType.CAR).build();

        vehicle2 = new Vehicle.Builder("XXX-222","dfasdf545654asfd",VehicleType.JEEP).build();

        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);

        given(service.findAll()).willReturn(vehicles);

        given(service.find(1L)).willReturn(vehicle1);



    }


    @Test
    public void givenVehicles_whenGetAllVehicles_returnJsonArray(){


        try {
            mvc.perform(get("/assets/vehicles").contentType(MediaType.APPLICATION_JSON_UTF8))
                    .andExpect(status().isOk())
                    .andExpect((ResultMatcher) jsonPath(("$[0].licensePlate"),is("Asfdf")));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @After
    public void tearDown() {
    }
}