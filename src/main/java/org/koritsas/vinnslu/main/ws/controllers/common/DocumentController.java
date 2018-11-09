package org.koritsas.vinnslu.main.ws.controllers.common;

import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.main.ws.dto.common.DocumentDto;
import org.koritsas.vinnslu.main.ws.services.common.DocumentService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/document")
public class DocumentController extends AbstractCRUDController<DocumentService,Document,Long,DocumentDto> {


    public DocumentController(DocumentService service) {
        super(service);
    }
}
