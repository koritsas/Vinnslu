package org.koritsas.vinnslu.ws.dto;

import org.koritsas.vinnslu.utils.AbtractDto;

public class AuthorityDto extends CompanyDto implements AbtractDto<Long> {
    @Override
    public Class getClaZZ() {
	return this.getClass();
    }
}
