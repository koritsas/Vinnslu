package org.koritsas.vinnslu.repos;

import org.koritsas.vinnslu.models.Person;
import org.koritsas.vinnslu.models.ResearchLicense;
import org.koritsas.vinnslu.models.Topo;
import org.koritsas.vinnslu.models.types.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ResearchLicenseRepository extends JpaRepository<ResearchLicense,Long>{

    ResearchLicense findByTopo(Topo topo);

    ResearchLicense findByContract(Contract contract);

    ResearchLicense findByEndDate(Date endDate);

    ResearchLicense findByRenewalDate(Date renewalDate);

    List<ResearchLicense> findByActiveTrue();

    List<ResearchLicense> findByEndDateAfter(Date date);

    List<ResearchLicense> findByEndDateBefore(Date date);

    List<ResearchLicense> findByRenewalDateAfter(Date date);

    List<ResearchLicense> findByRenewalDateBefore(Date date);

    List<ResearchLicense> findByArea(double area);

    List<ResearchLicense> findByAreaGreaterThan(Double area);

    List<ResearchLicense> findByAreaLessThan(Double area);

    List<ResearchLicense> findByAreaGreaterThanEqual(Double area);

    List<ResearchLicense> findByAreaLessThanEqual(Double area);

    ResearchLicense findByContractContractDate(Date date);

    List<ResearchLicense> findByContractContractDateAfter(Date date);

    List<ResearchLicense> findByContractContractDateBefore(Date date);

    List<ResearchLicense> findByContractNotary(Person notary);

    List<ResearchLicense> findByContractContractId(Long contractId);


}
