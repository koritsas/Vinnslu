package org.koritsas.vinnslu.ws.services;

import org.koritsas.vinnslu.models.common.Document;
import org.koritsas.vinnslu.repos.DocumentRepository;
import org.springframework.stereotype.Service;

@Service
public class DocumentService extends AbstractCRUDService<DocumentRepository, Document, Long> {
    public DocumentService(DocumentRepository repo) {
	super(repo);
    }
}
