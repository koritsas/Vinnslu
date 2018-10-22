package org.koritsas.vinnslu.ws.services.vehicles;

import org.koritsas.vinnslu.models.vehicles.Vehicle;
import org.koritsas.vinnslu.repos.vehicles.VehicleRepository;
import org.koritsas.vinnslu.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class VehicleService extends AbstractCRUDService<VehicleRepository,Vehicle,Long> {
    public VehicleService(VehicleRepository repo) {
        super(repo);
    }
}
