package org.koritsas.vinnslu.ws.services;

import org.koritsas.vinnslu.models.Guarantee;
import org.koritsas.vinnslu.repos.GuaranteeRepository;

public class GuaranteeService extends AbstractCRUDService<GuaranteeRepository, Guarantee, Guarantee.GuaranteeLetter> {
    public GuaranteeService(GuaranteeRepository repo) {
	super(repo);
    }
}
