package org.koritsas.vinnslu.ws.controllers;

import org.koritsas.vinnslu.models.Document;
import org.koritsas.vinnslu.ws.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    DocumentService service;

    @GetMapping("/{id}")
    public ResponseEntity<Document> find(@PathVariable long id) {

	Document doc = service.find(id);
	Link selfLink = linkTo(DocumentController.class).slash(doc.getEntityId()).withSelfRel();
	doc.add(selfLink);

	return ResponseEntity.ok(doc);
    }

}
