package org.koritsas.vinnslu.ws.services.vehicles;

import org.koritsas.vinnslu.models.vehicles.Machine;
import org.koritsas.vinnslu.repos.vehicles.MachineRepository;
import org.koritsas.vinnslu.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class MachineService extends AbstractCRUDService<MachineRepository, Machine, Long> {
    public MachineService(MachineRepository repo) {
	super(repo);
    }
}
