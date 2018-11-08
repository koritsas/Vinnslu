package org.koritsas.vinnslu.main.ws.services.common;

import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.repos.common.DocumentRepository;
import org.koritsas.vinnslu.main.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class DocumentService extends AbstractCRUDService<DocumentRepository, Document, Long> {
    public DocumentService(DocumentRepository repo) {
	super(repo);
    }
}
