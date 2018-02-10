package org.koritsas.vinnslu.repos;

import org.koritsas.vinnslu.models.MiningLicense;
import org.koritsas.vinnslu.models.Person;
import org.koritsas.vinnslu.models.Topo;
import org.koritsas.vinnslu.models.types.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MiningLicenseRepository extends JpaRepository<MiningLicense,Long>{

    MiningLicense findByTopo(Topo topo);

    MiningLicense findByContract(Contract contract);

    MiningLicense findByEndDate(Date endDate);

    MiningLicense findByRenewalDate(Date renewalDate);

    List<MiningLicense> findByActiveTrue();

    List<MiningLicense> findByEndDateAfter(Date date);

    List<MiningLicense> findByEndDateBefore(Date date);

    List<MiningLicense> findByRenewalDateAfter(Date date);

    List<MiningLicense> findByRenewalDateBefore(Date date);

    List<MiningLicense> findByArea(double area);

    List<MiningLicense> findByAreaGreaterThan(Double area);

    List<MiningLicense> findByAreaLessThan(Double area);

    List<MiningLicense> findByAreaGreaterThanEqual(Double area);

    List<MiningLicense> findByAreaLessThanEqual(Double area);

    MiningLicense findByContractContractDate(Date date);

    List<MiningLicense> findByContractContractDateAfter(Date date);

    List<MiningLicense> findByContractContractDateBefore(Date date);

    List<MiningLicense> findByContractNotary(Person notary);

    List<MiningLicense> findByContractContractId(Long contractId);


}
