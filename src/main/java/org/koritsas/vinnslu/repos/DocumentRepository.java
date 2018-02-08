package org.koritsas.vinnslu.repos;

import org.koritsas.vinnslu.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document,Long>{

    Document findById(final int id);
    Document findByDocumentDate(final Date date);
    Document findByDocumentDateAfter(final Date date);

    Document findByProtocolNumber(final String protocolNumber);
    List<Document> findByReductor(final String reductor);
    List<Document> findByOrganization(final String organization);
}
