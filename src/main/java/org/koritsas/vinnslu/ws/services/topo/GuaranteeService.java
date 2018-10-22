package org.koritsas.vinnslu.ws.services.topo;

import org.koritsas.vinnslu.models.topo.Guarantee;
import org.koritsas.vinnslu.repos.topo.GuaranteeRepository;
import org.koritsas.vinnslu.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class GuaranteeService extends AbstractCRUDService<GuaranteeRepository, Guarantee,Long> {
    public GuaranteeService(GuaranteeRepository repo) {
        super(repo);
    }
}
