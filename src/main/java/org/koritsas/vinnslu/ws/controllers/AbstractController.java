package org.koritsas.vinnslu.ws.controllers;

import org.koritsas.vinnslu.utils.GeometryModelMapper;
import org.koritsas.vinnslu.ws.services.AbstractCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public abstract class AbstractController<S extends AbstractCRUDService, E extends Serializable>
    extends ResourceSupport {

    protected S service;

    @Autowired
    GeometryModelMapper mapper;

    private Class<S> sClass;

    public AbstractController(S service) {
	this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<E>> findAll() {
	Link selfLink = linkTo(this).withRel("/lelelele");
	this.add(selfLink);
	return ResponseEntity.ok(service.findAll());
    }

}
