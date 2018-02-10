package org.koritsas.vinnslu.ws.controllers;

import org.koritsas.vinnslu.ws.dto.TopoDto;
import org.koritsas.vinnslu.ws.services.TopoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topos")
public class TopoController {

    private TopoService topoService;

    @Autowired
    public TopoController(TopoService topoService) { this.topoService = topoService; }

    @PostMapping("/create")
    public ResponseEntity<Void> createTopo(@RequestBody TopoDto dto) {
	return topoService.createTopo(dto);
    }


}
