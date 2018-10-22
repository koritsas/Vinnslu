package org.koritsas.vinnslu.ws.services.common;

import org.koritsas.vinnslu.models.common.Document;
import org.koritsas.vinnslu.repos.common.DocumentRepository;
import org.koritsas.vinnslu.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class DocumentService extends AbstractCRUDService<DocumentRepository, Document, Long> {
    public DocumentService(DocumentRepository repo) {
	super(repo);
    }
}
