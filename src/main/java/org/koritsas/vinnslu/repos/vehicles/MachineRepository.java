package org.koritsas.vinnslu.repos.vehicles;

import org.koritsas.vinnslu.models.common.Company;
import org.koritsas.vinnslu.models.vehicles.Machine;
import org.koritsas.vinnslu.models.types.MachineryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MachineRepository extends JpaRepository<Machine, Long> {

    List<Machine> findByCategory(MachineryType category);

    List<Machine> findByCompany(Company company);

    List<Machine> findByModel(String model);

    List<Machine> findByWeightGreaterThan(double weight);

    List<Machine> findByWeightGreaterThanEqual(double weight);

    List<Machine> findByWeightLessThan(double weight);

    List<Machine> findByWeightLessThanEqual(double weight);

    List<Machine> findByLicenseDate(Date date);

    List<Machine> findByLicenseDateAfter(Date date);

    List<Machine> findByLicenseDateBefore(Date date);

    List<Machine> findByKw(double kw);

    List<Machine> findByKwGreaterThan(double kw);

    List<Machine> findByKwLessThan(double kw);

    List<Machine> findByLicenseDateBetween(Date start, Date end);

    Machine findByEngineNumber(String engineNumber);

    Machine findByFrameNumber(String frameNumber);

    Machine findByLicensePlate(String licensePlate);

}
