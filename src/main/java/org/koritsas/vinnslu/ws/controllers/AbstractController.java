package org.koritsas.vinnslu.ws.controllers;

import org.koritsas.vinnslu.utils.GeometryModelMapper;
import org.koritsas.vinnslu.ws.services.AbstractCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;
import java.util.List;

public class AbstractController<S extends AbstractCRUDService, E extends Serializable, PK extends Serializable, D extends Class<E>> {

    private S service;

    @Autowired
    private GeometryModelMapper mapper;

    public AbstractController(S service) {
	this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<E>> listAll() {

	return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<E> findCompanyById(@PathVariable long companyId) {
	return ResponseEntity.ok((E) service.find(companyId));
    }
/*
    @PostMapping("/create")
    public ResponseEntity<E> createCompany(@RequestBody CompanyDto dto){
	return ResponseEntity.status(201).body( (E) service.create(mapper.map(dto, D)));
    }

    @DeleteMapping("/delete/{companyId}")
    public ResponseEntity<String> delete(@PathVariable long companyId) {
	return ResponseEntity.ok("Deleted: " + service.delete(companyId));
    }

    @PutMapping("/update")
    public ResponseEntity<Company> update(@RequestBody CompanyDto dto){
	return ResponseEntity.status(204).body(service.update(dto.getId(), mapper.map(dto, E)));
    }
*/
}
