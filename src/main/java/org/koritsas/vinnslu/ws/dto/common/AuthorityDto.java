package org.koritsas.vinnslu.ws.dto.common;

import org.koritsas.vinnslu.ws.dto.AbstractDto;

public class AuthorityDto extends CompanyDto implements AbstractDto<Long> {
    @Override
    public Class getClaZZ() {
	return this.getClass();
    }
}
