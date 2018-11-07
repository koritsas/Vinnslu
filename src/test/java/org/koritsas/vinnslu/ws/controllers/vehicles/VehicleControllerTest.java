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
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(VehicleController.class)
public class VehicleControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    VehicleService service;

    @MockBean
    GeometryModelMapper mapper;


    Vehicle vehicle1;

    Vehicle vehicle2;

    @Before
    public void setUp() {

        vehicle1 = new Vehicle.Builder("XXX-111","fdsa545g6fds", VehicleType.JEEP).build();

        vehicle2 = new Vehicle.Builder("XXX-222","hgfd6546dfgh",VehicleType.CAR).build();

        vehicle1.setId(1L);

        vehicle2.setId(2L);

        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(vehicle1);

        vehicles.add(vehicle2);


        given(service.findAll()).willReturn(vehicles);

        given(service.find(1L)).willReturn(vehicle1);

        given(service.find(2L)).willReturn(vehicle2);



    }


    @Test
    public void givenVEhicles_whenGetAllVehicles_ReturnJsonArray(){

        try {
            mvc.perform(get("/assets/vehicles").contentType(MediaType.APPLICATION_JSON))
                    //.andExpect((ResultMatcher) jsonPath("$[0].licensePlate",is(vehicle1.getLicensePlate())));
                      .andExpect(status().isOk())
                      .andExpect(jsonPath("$",hasSize(2)))
                      .andExpect(jsonPath("$[0].licensePlate",is(vehicle1.getLicensePlate())));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void givenVehicles_whenGetOne_returnJsonObject(){
        try {
            mvc.perform(get("/assets/vehicles/1").contentType(MediaType.APPLICATION_JSON))
                      .andExpect(status().isOk())
                      .andExpect(jsonPath("$",hasSize(1)))
                      .andExpect(jsonPath("$[0].licensePlate",is(vehicle2.getLicensePlate())));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void whenDoesNotExist_return404(){
        try {
            mvc.perform(get("/assets/vehicles/4").contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @After
    public void tearDown() {
    }
}