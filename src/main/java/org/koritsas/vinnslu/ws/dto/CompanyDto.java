package org.koritsas.vinnslu.ws.dto;

import org.koritsas.vinnslu.models.Company;
import org.koritsas.vinnslu.utils.AbstractDto;

public class CompanyDto implements AbstractDto<Long> {

    private Long id;

    private Long afm;

    private String name;

    private String address;

    public Long getId() {
        return id;
    }

    @Override
    public Class getClaZZ() {
        return Company.class;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAfm() { return afm; }

    public void setAfm(Long afm) { this.afm = afm; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    @Override
    public String toString() {
        return "CompanyDto{" +
                "id=" + id +
                ", afm=" + afm +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
