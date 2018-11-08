package org.koritsas.vinnslu.main.repos.topo;

import org.koritsas.vinnslu.main.models.topo.StandardEnvironmentalCommitments;
import org.koritsas.vinnslu.main.models.topo.StandardTechnicalCommitments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StandardTechnicalCommitmentsRepository extends JpaRepository<StandardTechnicalCommitments,Long> {

    StandardEnvironmentalCommitments findByProtocol(String protocol);
    StandardEnvironmentalCommitments findByAda(String ada);

    List<StandardEnvironmentalCommitments> findByActive(boolean active);
    List<StandardEnvironmentalCommitments> findByTopoIdAndActive(Long topo_id, boolean active);
}
