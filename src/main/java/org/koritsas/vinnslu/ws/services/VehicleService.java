package org.koritsas.vinnslu.ws.services;

import org.koritsas.vinnslu.models.Vehicle;
import org.koritsas.vinnslu.repos.VehicleRepository;
import org.springframework.stereotype.Service;

@Service
public class VehicleService extends AbstractCrudService<VehicleRepository, Vehicle, Long> {

    public VehicleService(VehicleRepository repository) {
	super(repository);
    }

}
