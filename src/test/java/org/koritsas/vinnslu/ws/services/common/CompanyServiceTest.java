package org.koritsas.vinnslu.ws.services.common;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.koritsas.vinnslu.models.common.Company;
import org.koritsas.vinnslu.repos.common.CompanyRepository;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class CompanyServiceTest {

    @TestConfiguration
    static class CompanyServiceImplContextConfig{


    }

    @Autowired
    CompanyService companyService;

    @MockBean
    CompanyRepository companyRepository;


    @Before
    public void setUp() {

        Company company = new Company(666666L,"Hermes","Drama","Quarry",666666L);

        Mockito.when(companyRepository.findByName("Hermes")).thenReturn(company);
        Mockito.when(companyRepository.findByAfm(666666L)).thenReturn(company);

        Mockito.when(companyRepository.findByName("Danae")).thenReturn(null);


    }

    @After
    public void tearDown() {
    }
}