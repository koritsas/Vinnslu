package org.koritsas.vinnslu.ws.controllers.vehicles;

import org.koritsas.vinnslu.models.vehicles.Machine;
import org.koritsas.vinnslu.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.ws.dto.vehicles.MachineDTO;
import org.koritsas.vinnslu.ws.services.AbstractCRUDService;
import org.koritsas.vinnslu.ws.services.vehicles.MachineService;

public class MachineController extends AbstractCRUDController<MachineService, Machine,Long, MachineDTO> {

    public MachineController(MachineService service) {
        super(service);
    }
}
