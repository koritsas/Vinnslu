package org.koritsas.vinnslu.repos;

import org.koritsas.vinnslu.models.common.Company;
import org.koritsas.vinnslu.models.common.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document,Long>{

    Document findById(final int id);
    Document findByDate(final Date date);
    Document findByProtocol(final String protocolNumber);
    Document findBySenderAndDateAndProtocol(final Company company, final Date date, final String protocol);

    List<Document> findBySender(final Company company);
    List<Document> findByReceiver(final Company company);
    List<Document> findByDateBefore(final Date date);
    List<Document> findByDateAfter(final Date date);

}
