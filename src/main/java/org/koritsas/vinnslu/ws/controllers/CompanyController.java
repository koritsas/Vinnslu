package org.koritsas.vinnslu.ws.controllers;

import org.koritsas.vinnslu.models.Company;
import org.koritsas.vinnslu.utils.GeometryModelMapper;
import org.koritsas.vinnslu.ws.dto.CompanyDto;
import org.koritsas.vinnslu.ws.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService service;

    @Autowired
    public CompanyController(CompanyService service){this.service=service;}

    @Autowired
    GeometryModelMapper mapper;

    @GetMapping("/find/all")
    public ResponseEntity<List<Company>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/find/{companyId}")
    public ResponseEntity<Company> findCompanyById(@PathVariable long companyId){
        return ResponseEntity.ok(service.find(companyId));
    }

    @PostMapping("/create")
    public ResponseEntity<Company> createCompany(@RequestBody CompanyDto dto){
        return ResponseEntity.status(201).body(service.create(mapper.map(dto, Company.class)));
    }

    @DeleteMapping("/delete/{companyId}")
    public ResponseEntity<String> delete(@PathVariable long companyId) {
        return ResponseEntity.ok("Deleted: " + service.delete(companyId));
    }

    @PutMapping("/update")
    public ResponseEntity<Company> update(@RequestBody CompanyDto dto){
        return ResponseEntity.status(204).body(service.update(dto.getId(), mapper.map(dto, Company.class)));
    }


}
