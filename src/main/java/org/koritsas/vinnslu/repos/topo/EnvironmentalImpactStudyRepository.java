package org.koritsas.vinnslu.repos.topo;

import org.koritsas.vinnslu.models.topo.EnvironmentalImpactStudy;
import org.koritsas.vinnslu.models.topo.Topo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface EnvironmentalImpactStudyRepository extends JpaRepository<EnvironmentalImpactStudy, Long> {

    EnvironmentalImpactStudy findByAda(final String ada);

    EnvironmentalImpactStudy findByProtocol(final String protocol);


    List<EnvironmentalImpactStudy> findByActive(final boolean active);

    List<EnvironmentalImpactStudy> findByStartDateBefore(final Date date);

    List<EnvironmentalImpactStudy> findByStartDateAfter(final Date date);

    List<EnvironmentalImpactStudy> findByEndDateBefore(final Date date);

    List<EnvironmentalImpactStudy> findByEndDateAfter(final Date date);

    List<EnvironmentalImpactStudy> findByTopoId(final Long topoId);

}
