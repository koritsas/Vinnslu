package org.koritsas.vinnslu.ws.dto;

public class CompanyDto {

    private Long afm;

    private String name;

    private String address;

    public Long getAfm() { return afm; }

    public void setAfm(Long afm) { this.afm = afm; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    @Override
    public String toString() {
        return "CompanyDto{" +
            "afm=" + afm +
            ", name='" + name + '\'' +
            ", address='" + address + '\'' +
            '}';
    }
}
