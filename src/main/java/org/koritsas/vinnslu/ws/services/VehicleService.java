package org.koritsas.vinnslu.ws.services;

import org.koritsas.vinnslu.models.vehicles.Vehicle;
import org.koritsas.vinnslu.repos.VehicleRepository;
import org.springframework.stereotype.Service;

@Service
public class VehicleService extends AbstractCRUDService<VehicleRepository,Vehicle,Long> {
    public VehicleService(VehicleRepository repo) {
        super(repo);
    }
}
