package org.koritsas.vinnslu.repos.topo;

import org.koritsas.vinnslu.models.topo.TechnicalStudy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TechnicalStudyRepository extends JpaRepository<TechnicalStudy,Long> {

    TechnicalStudy findByAda(final String ada);

    TechnicalStudy findByProtocol(final String protocol);


    List<TechnicalStudy> findByActive(final boolean active);

    List<TechnicalStudy> findByStartDateBefore(final Date date);

    List<TechnicalStudy> findByStartDateAfter(final Date date);

    List<TechnicalStudy> findByTopoId(final Long topoId);
}
