package org.koritsas.vinnslu.ws.dto;

import org.koritsas.vinnslu.models.Topo;
import org.koritsas.vinnslu.models.types.Contract;

import java.util.Date;

public class ResearchLicenseDto {
    private Long id;

    private boolean active;

    private Topo topo;

    private Contract contract;

    private Date endDate;

    private Date renewalDate;

    private Double area;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public boolean getActive() { return active; }

    public void setActive(boolean active) { this.active = active; }

    public Topo getTopo() { return topo; }

    public void setTopo(Topo topo) { this.topo = topo; }

    public Contract getContract() { return contract; }

    public void setContract(Contract contract) { this.contract = contract; }

    public Date getEndDate() { return endDate; }

    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public Date getRenewalDate() { return renewalDate; }

    public void setRenewalDate(Date renewalDate) { this.renewalDate = renewalDate; }

    public Double getArea() { return area; }

    public void setArea(Double area) { this.area = area; }
}
