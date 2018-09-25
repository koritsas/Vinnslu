package org.koritsas.vinnslu.ws.controllers;

import org.koritsas.vinnslu.models.vehicles.Vehicle;
import org.koritsas.vinnslu.ws.dto.VehicleDto;
import org.koritsas.vinnslu.ws.services.VehicleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assets/vehicle")
@CrossOrigin(origins = "http://localhost:4200")
public class VehicleController extends AbstractCRUDController<VehicleService,Vehicle,Long,VehicleDto> {
    public VehicleController(VehicleService service) {
        super(service);
    }
}
