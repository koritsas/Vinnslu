package org.koritsas.vinnslu.main.ws.services.vehicles;

import org.koritsas.vinnslu.main.models.vehicles.Machine;
import org.koritsas.vinnslu.main.repos.vehicles.MachineRepository;
import org.koritsas.vinnslu.main.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class MachineService extends AbstractCRUDService<MachineRepository, Machine, Long> {
    public MachineService(MachineRepository repo) {
	super(repo);
    }
}
