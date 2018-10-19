package org.koritsas.vinnslu.repos;

import org.koritsas.vinnslu.models.topo.StandardEnvironmentalCommitments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StandardEnvironmentalCommitmentsRepository extends JpaRepository<StandardEnvironmentalCommitments,Long> {


    StandardEnvironmentalCommitments findByProtocol(String protocol);
    StandardEnvironmentalCommitments findByAda(String ada);


    List<StandardEnvironmentalCommitments> findByActive(boolean active);
    List<StandardEnvironmentalCommitments> findByTopoIdAndActive(Long topo_id, boolean active);

}