package org.koritsas.vinnslu.ws.controllers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.koritsas.vinnslu.models.Company;
import org.koritsas.vinnslu.repos.CompanyRepository;
import org.koritsas.vinnslu.utils.GeometryModelMapper;
import org.koritsas.vinnslu.ws.services.CompanyService;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(CompanyController.class)
public class CompanyControllerTest {

    @MockBean
    GeometryModelMapper geometryModelMapper;

    @MockBean
    CompanyService companyService;

    @MockBean
    CompanyRepository companyRepository;

    @Autowired
    CompanyController companyController;

    @Autowired
    MockMvc mockMvc;

    Company company1;

    Company company2;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(companyController)
                .build();

        company1 = new Company(666L,"Ερμής","Δράμα");
        company1.setId(1L);

        company2 = new Company(667L,"Μπύρος","Δράμα");
        company2.setId(2L);

        when(companyRepository.findById(1L)).thenReturn(company1);
        when(companyRepository.findByAfm(666L)).thenReturn(company1);
        when(companyRepository.findByName("Ερμής")).thenReturn(company1);


        when(companyRepository.findById(2L)).thenReturn(company2);
        when(companyRepository.findByAfm(667L)).thenReturn(company2);
        when(companyRepository.findByName("Μπύρος")).thenReturn(company2);

        when(companyService.findCompanyById(1L)).thenReturn(company1);
        when(companyService.createCompany(company1)).thenReturn(company1);
        when(companyService.deleteCompany(1L)).thenReturn(company1);
        when(companyService.updateCompany(company1)).thenReturn(company1);

        when(companyService.findCompanyById(2L)).thenReturn(company2);
        when(companyService.createCompany(company2)).thenReturn(company2);
        when(companyService.deleteCompany(2L)).thenReturn(company2);
        when(companyService.updateCompany(company2)).thenReturn(company2);

        when(companyService.getCompanies()).thenReturn(Arrays.asList(company1,company2));

        when(companyRepository.findByAddress("Δράμα")).thenReturn(Arrays.asList(company1,company2));



    }

    @After
    public void tearDown() {
    }

    @Test
    public void findCompanyById() throws Exception{

        mockMvc.perform(get("/companies/find/1")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id",is(1)))
                .andExpect(jsonPath("$.afm",is(666)))
                .andExpect(jsonPath("$.name",is("Ερμής")))
                .andExpect(jsonPath("$.address",is("Δράμα")));

      verify(companyService,atLeastOnce()).findCompanyById(1L);

     mockMvc.perform(get("/companies/find/11")).andExpect(status().isOk());

    }

    @Test
    public void findAllCompanies() throws  Exception {

        mockMvc.perform(get("/companies/find/all")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));

    }

    @Test
    public void deleteCompany() throws Exception {

        when(companyService.deleteCompany(1L)).thenReturn(company1);

        when(companyRepository.findOne(1L)).thenReturn(company1);

        mockMvc.perform(delete("/companies/delete/1")).andExpect(status().isOk())
                .andExpect(content().string("Deleted: " + company1.getId()));

    }


}