package org.koritsas.vinnslu.ws.services;

import org.koritsas.vinnslu.models.vehicles.Machine;
import org.koritsas.vinnslu.repos.MachineRepository;
import org.springframework.stereotype.Service;

@Service
public class MachineService extends AbstractCRUDService<MachineRepository, Machine, Long> {
    public MachineService(MachineRepository repo) {
	super(repo);
    }
}
