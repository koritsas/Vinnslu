package org.koritsas.vinnslu.ws.controllers;

import org.koritsas.vinnslu.models.common.Document;
import org.koritsas.vinnslu.ws.dto.DocumentDto;
import org.koritsas.vinnslu.ws.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/document")
public class DocumentController extends AbstractCRUDController<DocumentService,Document,Long,DocumentDto>{


    public DocumentController(DocumentService service) {
        super(service);
    }
}
