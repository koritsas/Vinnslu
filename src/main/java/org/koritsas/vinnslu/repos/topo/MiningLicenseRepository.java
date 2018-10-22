package org.koritsas.vinnslu.repos.topo;

import org.koritsas.vinnslu.models.topo.Guarantee;
import org.koritsas.vinnslu.models.topo.MiningLicense;
import org.koritsas.vinnslu.models.types.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MiningLicenseRepository extends JpaRepository<MiningLicense, Long> {

    MiningLicense findByAda(final String ada);

    MiningLicense findByTopoId(final String id);

    MiningLicense findByContract(final Contract contract);

    MiningLicense findByTopoAbl(final Long abl);

    MiningLicense findByEnvironmentalGuarantee(Guarantee environmentalGuarantee);

    MiningLicense findByLeaseGuarantee(Guarantee environmentalGuarantee);

    List<MiningLicense> findByEndDateBefore(final Date endDate);

    List<MiningLicense> findByEndDateAfter(final Date endDate);



    List<MiningLicense> findByActive(final boolean active);
}
