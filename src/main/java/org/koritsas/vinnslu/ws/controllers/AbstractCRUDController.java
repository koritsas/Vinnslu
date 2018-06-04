package org.koritsas.vinnslu.ws.controllers;

import org.koritsas.vinnslu.utils.AbstractDto;
import org.koritsas.vinnslu.utils.GeometryModelMapper;
import org.koritsas.vinnslu.ws.services.AbstractCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

public class AbstractCRUDController<S extends AbstractCRUDService, E extends Serializable, PK extends Serializable, DTO extends AbstractDto<PK>> {

    private S service;

    @Autowired
    private GeometryModelMapper mapper;

    public AbstractCRUDController(S service) {
	this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<E>> listAll() {

	return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<E> findCompanyById(@PathVariable PK id) {
	return ResponseEntity.ok((E) service.find(id));
    }

    @PostMapping()
    public ResponseEntity<E> createCompany(@RequestBody DTO dto) {
	return ResponseEntity.status(201).body((E) service.create(mapper.map(dto, (Class<E>) dto.getClaZZ())));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long companyId) {
	return ResponseEntity.ok("Deleted: " + service.delete(companyId));
    }

    @PutMapping()
    public ResponseEntity<E> update(@RequestBody DTO dto) {
	return ResponseEntity.status(204)
	    .body((E) service.update(dto.getId(), mapper.map(dto, (Class<E>) dto.getClaZZ())));
    }

}
