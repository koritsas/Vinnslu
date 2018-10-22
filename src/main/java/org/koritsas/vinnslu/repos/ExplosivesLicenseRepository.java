package org.koritsas.vinnslu.repos;

import org.koritsas.vinnslu.models.common.Authority;
import org.koritsas.vinnslu.models.common.Person;
import org.koritsas.vinnslu.models.topo.ExplosivesLicense;
import org.koritsas.vinnslu.models.topo.Topo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ExplosivesLicenseRepository extends JpaRepository<ExplosivesLicense,Long> {

    ExplosivesLicense findByTopo(Topo topo);

    List<ExplosivesLicense> findByLicenseHolder(Person person);

    List<ExplosivesLicense> findByBlaster(Person person);

    List<ExplosivesLicense> findByPoliceStation(Authority authority);

    List<ExplosivesLicense> findByRetardantsGreaterThan(final int retardants);

    List<ExplosivesLicense> findByRetardantsLessThan(final int retardants);

    List<ExplosivesLicense> findByInstantFuseGreaterThan(final int instantFuse);

    List<ExplosivesLicense> findByinstantFuseLessThan(final int instantFuse);

    List<ExplosivesLicense> findByShortFuseGreaterThan(final int shortFuse);

    List<ExplosivesLicense> findByShortFuseLessThan(final int shortFuse);

    List<ExplosivesLicense> findByNonelGreaterThan(final int nonel);

    List<ExplosivesLicense> findByNonelLessThan(final int nonel);


    List<ExplosivesLicense> findByCommonCartridgeGreaterThan(final int commonCartridge);

    List<ExplosivesLicense> findByCommonCartridgeLessThan(final int commonCartridge);

    List<ExplosivesLicense> findByAnfoGreaterThan(final double anfo);

    List<ExplosivesLicense> findByAnfoLessThan(final double anfo);

    List<ExplosivesLicense> findByGeligniteGreaterThan(final double gelignite);

    List<ExplosivesLicense> findByGeligniteLessThan(final double gelignite);

    List<ExplosivesLicense> findByStartDateAfter(final Date startDate);

    List<ExplosivesLicense> findByStartDateBefore(final Date startDate);

    List<ExplosivesLicense> findByEndDateAfter(final Date endDate);

    List<ExplosivesLicense> findByEndDateBefore(final Date endDate);

    List<ExplosivesLicense> findByRenewalDateAfter(final Date endDate);

    List<ExplosivesLicense> findByRenewalDateBefore(final Date endDate);
}
