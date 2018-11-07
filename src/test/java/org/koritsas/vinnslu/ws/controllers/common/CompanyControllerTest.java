package org.koritsas.vinnslu.ws.controllers.common;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.koritsas.vinnslu.VinnsluApplication;
import org.koritsas.vinnslu.models.common.Company;
import org.koritsas.vinnslu.repos.common.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = VinnsluApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:test.properties")
public class CompanyControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private CompanyRepository repository;

    @Before
    public void setUp() {

        repository.save(new Company(666L,"Hermes","asda","drama",555L));
    }

    @Test
    public void when_exist_return200Ok()  {


        try {
            mvc.perform(get("/common/companies").contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                    .andExpect((ResultMatcher) jsonPath("$[0].name",is("hermes")));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void when_does_not_exist_return404()  {

        try {
            mvc.perform(get("common/companies/1").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



    @After
    public void tearDown() {

        repository = null;
    }
}