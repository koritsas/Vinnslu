package org.koritsas.vinnslu.security.ws.controllers;

import org.koritsas.vinnslu.security.ws.dto.UserDTO;
import org.koritsas.vinnslu.security.ws.services.UserService;
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