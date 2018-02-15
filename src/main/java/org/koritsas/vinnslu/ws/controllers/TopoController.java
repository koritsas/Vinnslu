package org.koritsas.vinnslu.ws.controllers;

import org.koritsas.vinnslu.models.Topo;
import org.koritsas.vinnslu.utils.GeometryModelMapper;
import org.koritsas.vinnslu.ws.dto.TopoDto;
import org.koritsas.vinnslu.ws.services.TopoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topos")
public class TopoController {

    @Autowired
    private GeometryModelMapper mapper;

    private TopoService topoService;

    @Autowired
    private TopoController(TopoService topoService) { this.topoService = topoService; }

    @GetMapping(value = "/getAllTopos")
    public ResponseEntity<List<Topo>> getAllTopos(){
        return ResponseEntity.ok(topoService.getAllTopos());
    }

    @PostMapping("/create")
    public ResponseEntity<Topo> createTopo(@RequestBody TopoDto dto){
        return ResponseEntity.ok(topoService.createTopo(mapper.map(dto,Topo.class)));
    }


    @DeleteMapping(value = "/delete/{topoId}")
    public ResponseEntity<String> delete(@PathVariable long topoId) {
        return ResponseEntity.ok("Deleted: " + topoService.deleteTopo(topoId).getId());
    }

    @GetMapping("/findTopo/{topoId}")
    public ResponseEntity<Topo> findTopo(@PathVariable long topoId){
        return ResponseEntity.ok(topoService.findById(topoId));
    }


}
