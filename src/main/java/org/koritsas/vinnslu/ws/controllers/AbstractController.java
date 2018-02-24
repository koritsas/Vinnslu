package org.koritsas.vinnslu.ws.controllers;

import org.koritsas.vinnslu.utils.GeometryModelMapper;
import org.koritsas.vinnslu.ws.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public class AbstractController<S extends AbstractService> extends ResourceSupport {

    @Autowired
    GeometryModelMapper mapper;

    private Class<? extends AbstractController> sClass = this.getClass();

    @Autowired
    private S service;

    public AbstractController(S service) {
	this.service = service;
	this.sClass = this.getClass();

    }

    @GetMapping()
    public ResponseEntity<List<S>> findAll() {

	Link selfLink = linkTo(sClass).withSelfRel();
	this.add(selfLink);

	return ResponseEntity.ok(service.findAll());
    }

}
