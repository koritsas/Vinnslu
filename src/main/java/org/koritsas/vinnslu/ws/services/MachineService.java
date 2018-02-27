package org.koritsas.vinnslu.ws.services;

import org.koritsas.vinnslu.models.Machine;
import org.koritsas.vinnslu.repos.MachineRepository;

public class MachineService extends AbstractCRUDService<MachineRepository, Machine, Long> {
    public MachineService(MachineRepository repo) {
	super(repo);
    }
}
