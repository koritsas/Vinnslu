package org.koritsas.vinnslu.ws.controllers.vehicles;

import org.koritsas.vinnslu.models.vehicles.Vehicle;
import org.koritsas.vinnslu.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.ws.dto.vehicles.VehicleDto;
import org.koritsas.vinnslu.ws.services.vehicles.VehicleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assets/vehicles")
@CrossOrigin(origins = "http://localhost:4200")
public class VehicleController extends AbstractCRUDController<VehicleService,Vehicle,Long,VehicleDto> {
    public VehicleController(VehicleService service) {
        super(service);
    }
}
