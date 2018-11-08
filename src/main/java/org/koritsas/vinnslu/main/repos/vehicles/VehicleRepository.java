package org.koritsas.vinnslu.main.repos.vehicles;

import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.common.Person;
import org.koritsas.vinnslu.main.models.vehicles.Vehicle;
import org.koritsas.vinnslu.main.models.types.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long>{

    Vehicle findByLicensePlate(String licensePlate);

    Vehicle findByLicensePlateStartsWith(String licensePlate);

    Vehicle findByFrameNumber(String frameNumber);

    Vehicle findByFrameNumberStartsWith(String frameNumber);

    List<Vehicle> findByTollsEnd(Date date);

    List<Vehicle> findByTollsEndAfter(Date date);

    List<Vehicle> findByTollsEndBefore(Date date);

    List<Vehicle> findByExhaustCardEnd(Date date);

    List<Vehicle> findByExhaustCardEndAfter(Date date);

    List<Vehicle> findByExhaustCardEndBefore(Date date);

    List<Vehicle> findBySecurityEnd(Date date);

    List<Vehicle> findBySecurityEndAfter(Date date);

    List<Vehicle> findBySecurityEndBefore(Date date);

    List<Vehicle> findByDriver(Person driver);

    List<Vehicle> findByOwnerCompany(Company ownerCompany);

    List<Vehicle> findByVehicleType(VehicleType vehicleType);

    List<Vehicle> findByBrand(String brand);

    List<Vehicle> findByModel(String model);

}
