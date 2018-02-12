package org.koritsas.vinnslu.ws.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.koritsas.vinnslu.ws.dto.CompanyDto;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class CompanyServiceTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Mock
    CompanyService service;

    @Mock
    CompanyDto dto;

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void createCompany() {

	System.out.println(dto.getName());
        service.createCompany(dto);

    }
}