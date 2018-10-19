package org.koritsas.vinnslu.repos;

import org.koritsas.vinnslu.models.topo.ResearchLicense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ResearchLicenseRepository extends JpaRepository<ResearchLicense,Long> {

    ResearchLicense findByProtocol(String protocol);
    ResearchLicense findByAda(String ada);
    ResearchLicense findByStartDate(Date date);


    List<ResearchLicense> findByStartDateBefore(Date date);

    List<ResearchLicense> findByEndDateBefore(Date date);

    List<ResearchLicense> findByStartDateAfter(Date date);

    List<ResearchLicense> findByEndDateAfter(Date date);

    List<ResearchLicense> findByActive(boolean active);

}
