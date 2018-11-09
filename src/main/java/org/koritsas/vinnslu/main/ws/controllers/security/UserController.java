package org.koritsas.vinnslu.main.ws.controllers.security;

import org.koritsas.vinnslu.main.ws.dto.security.UserDTO;
import org.koritsas.vinnslu.main.ws.services.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller("/users")
public class UserController {

    @Autowired
    UserService service;


    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO){

        service.registerNewUser(userDTO);

        return ResponseEntity.status(201).body("VinnsluUser successfully registered");
    }



}
