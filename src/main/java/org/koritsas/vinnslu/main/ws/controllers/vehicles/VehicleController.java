package org.koritsas.vinnslu.main.ws.controllers.vehicles;

import org.koritsas.vinnslu.main.models.vehicles.Vehicle;
import org.koritsas.vinnslu.main.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.main.ws.dto.vehicles.VehicleDto;
import org.koritsas.vinnslu.main.ws.services.vehicles.VehicleService;
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
