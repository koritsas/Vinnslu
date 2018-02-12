package org.koritsas.vinnslu.ws.controllers;

import org.koritsas.vinnslu.ws.dto.CompanyDto;
import org.koritsas.vinnslu.ws.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService service;

    @Autowired
    public CompanyController(CompanyService service){this.service=service;}

    @PostMapping("/create")
    public void createCompany(@RequestBody CompanyDto dto){
        service.createCompany(dto);
    }

}
