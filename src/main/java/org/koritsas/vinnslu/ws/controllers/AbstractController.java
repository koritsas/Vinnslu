package org.koritsas.vinnslu.ws.controllers;

import org.koritsas.vinnslu.utils.AbtractDto;
import org.koritsas.vinnslu.utils.GeometryModelMapper;
import org.koritsas.vinnslu.ws.services.AbstractCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

public class AbstractController<S extends AbstractCRUDService, E extends Serializable, PK extends Serializable, D extends Class<E>, DTO extends AbtractDto<PK>> {

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

    @GetMapping("/{id}")
    public ResponseEntity<E> findCompanyById(@PathVariable PK id) {
	return ResponseEntity.ok((E) service.find(id));
    }

    @PostMapping()
    public ResponseEntity<E> createCompany(@RequestBody DTO dto) {
	return ResponseEntity.status(201).body((E) service.create(mapper.map(dto, (Class<E>) dto.getClaZZ())));
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<String> delete(@PathVariable long companyId) {
	return ResponseEntity.ok("Deleted: " + service.delete(companyId));
    }

    @PutMapping()
    public ResponseEntity<E> update(@RequestBody DTO dto) {
	return ResponseEntity.status(204)
	    .body((E) service.update(dto.getId(), mapper.map(dto, (Class<D>) dto.getClaZZ())));
    }

}
