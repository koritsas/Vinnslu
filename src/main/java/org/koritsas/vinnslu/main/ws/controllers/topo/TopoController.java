package org.koritsas.vinnslu.main.ws.controllers.topo;

import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.main.ws.dto.topo.TopoDTO;
import org.koritsas.vinnslu.main.ws.services.topo.TopoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topos")
public class TopoController extends AbstractCRUDController<TopoService, Topo, Long, TopoDTO> {
    public TopoController(TopoService service) {
	super(service);
    }
/*
    @Autowired
    private GeometryModelMapper mapper;

    private TopoService topoService;

    @Autowired
    private TopoController(TopoService topoService) { this.topoService = topoService; }

    @GetMapping(value = "/find/all")
    public ResponseEntity<List<Topo>> getAllTopos(){
        return ResponseEntity.ok(topoService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<Topo> createTopo(@RequestBody TopoDTO dto){
        return ResponseEntity.status(201).body((topoService.create(mapper.map(dto, Topo.class))));
    }


    @DeleteMapping(value = "/delete/{topoId}")
    public ResponseEntity<String> delete(@PathVariable long topoId) {
        return ResponseEntity.ok("Deleted: " + topoService.delete(topoId).getId());
    }

    @GetMapping("/find/{topoId}")
    public ResponseEntity<Topo> findTopo(@PathVariable long topoId){
        return ResponseEntity.ok(topoService.find(topoId));
    }

    @PutMapping("/update")
    public ResponseEntity<Topo> updateTopo(@RequestBody TopoDTO dto){
        return ResponseEntity.status(204).body(topoService.update(dto.getId(), mapper.map(dto, Topo.class)));
    }
*/
}
