package org.koritsas.vinnslu.ws.controllers.common;

import org.koritsas.vinnslu.models.common.Person;
import org.koritsas.vinnslu.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.ws.dto.common.PersonDto;
import org.koritsas.vinnslu.ws.services.common.PersonService;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/person")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController extends AbstractCRUDController<PersonService,Person,Long,PersonDto> {

    public PersonController(PersonService service) {
        super(service);
    }
}
