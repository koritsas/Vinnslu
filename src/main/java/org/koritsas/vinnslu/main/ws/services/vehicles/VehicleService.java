package org.koritsas.vinnslu.main.ws.services.vehicles;

import org.koritsas.vinnslu.main.models.vehicles.Vehicle;
import org.koritsas.vinnslu.main.repos.vehicles.VehicleRepository;
import org.koritsas.vinnslu.main.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class VehicleService extends AbstractCRUDService<VehicleRepository,Vehicle,Long> {
    public VehicleService(VehicleRepository repo) {
        super(repo);
    }
}
