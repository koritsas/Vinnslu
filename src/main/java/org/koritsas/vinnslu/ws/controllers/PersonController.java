package org.koritsas.vinnslu.ws.controllers;

import org.koritsas.vinnslu.models.Person;
import org.koritsas.vinnslu.utils.GeometryModelMapper;
import org.koritsas.vinnslu.ws.dto.PersonDto;
import org.koritsas.vinnslu.ws.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService service;

    @Autowired
    GeometryModelMapper mapper;

    private PersonController(PersonService service) {this.service = service;}

    @GetMapping("/find/all")
    public ResponseEntity<List<Person>> findAll() {

	return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/find/{personId}")
    public ResponseEntity<Person> findPerson(@PathVariable long personId) {
	return ResponseEntity.ok(service.find(personId));
    }

    @PostMapping("/create")
    public ResponseEntity<Person> createPerson(@RequestBody PersonDto dto) {
	return ResponseEntity.status(201).body(service.create(mapper.map(dto, Person.class)));
    }

    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<String> deletePerson(@PathVariable long personId) {
	return ResponseEntity.ok("Deleted person with id: " + service.delete(personId).getId());
    }

    @PutMapping("/update")
    public ResponseEntity<Person> update(@RequestBody Person dto) {
	return ResponseEntity.status(204).body(service.update(dto.getId(), mapper.map(dto, Person.class)));
    }
}
