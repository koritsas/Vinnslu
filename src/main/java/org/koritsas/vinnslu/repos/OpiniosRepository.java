package org.koritsas.vinnslu.repos;

import org.hibernate.validator.constraints.EAN;
import org.koritsas.vinnslu.models.common.Opinions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpiniosRepository extends JpaRepository<Opinions,Long> {

    List<Opinions> findAllByCityPlanningCommission(boolean cityPlanningCommission);
    List<Opinions> findAllByArcheology(boolean archeology);
    List<Opinions> findAllBySpeleology(boolean speleology);
    List<Opinions> findAllByMiningInspection(boolean miningInspection);
}
