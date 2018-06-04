package org.koritsas.vinnslu.ws.controllers;

import org.koritsas.vinnslu.models.Person;
import org.koritsas.vinnslu.utils.GeometryModelMapper;
import org.koritsas.vinnslu.ws.dto.PersonDto;
import org.koritsas.vinnslu.ws.services.AbstractCRUDService;
import org.koritsas.vinnslu.ws.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/person")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController extends AbstractCRUDController<PersonService,Person,Long,PersonDto>{

    public PersonController(PersonService service) {
        super(service);
    }
}
