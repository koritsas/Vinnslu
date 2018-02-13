package org.koritsas.vinnslu.ws.controllers;

import org.koritsas.vinnslu.models.Topo;
import org.koritsas.vinnslu.ws.services.TopoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topos")
public class TopoController {

    private TopoService topoService;

    @Autowired
    public TopoController(TopoService topoService) { this.topoService = topoService; }

    @GetMapping("/getAllTopos")
    public ResponseEntity<List<Topo>> getAllTopos(){
        return ResponseEntity.ok(topoService.getAllTopos());
    }





}
