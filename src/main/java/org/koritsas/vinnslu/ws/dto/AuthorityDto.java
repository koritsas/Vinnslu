package org.koritsas.vinnslu.ws.dto;

import org.koritsas.vinnslu.utils.AbstractDto;

public class AuthorityDto extends CompanyDto implements AbstractDto<Long> {
    @Override
    public Class getClaZZ() {
	return this.getClass();
    }
}
