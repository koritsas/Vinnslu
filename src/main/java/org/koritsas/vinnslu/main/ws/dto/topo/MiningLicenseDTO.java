package org.koritsas.vinnslu.main.ws.dto.topo;

import org.koritsas.vinnslu.main.models.topo.Guarantee;
import org.koritsas.vinnslu.main.models.topo.MiningLicense;
import org.koritsas.vinnslu.main.models.topo.TechnicalStudy;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.models.types.Contract;
import org.koritsas.vinnslu.main.ws.dto.AbstractDto;

import java.util.Date;

public class MiningLicenseDTO implements AbstractDto<Long> {

    private Long id;

    private Topo topo_abl;

    private boolean active;

    private String protocol;

    private Contract contract;

    private Date endDate;

    private TechnicalStudy technicalStudy;

    private Topo topo;

    private Guarantee environmentalGuarantee;

    private Guarantee leaseGuarantee;

    public Long getId() {
        return id;
    }

    @Override
    public Class getClaZZ() {
        return MiningLicense.class;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Topo getTopo_abl() {
        return topo_abl;
    }

    public void setTopo_abl(Topo topo_abl) {
        this.topo_abl = topo_abl;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public TechnicalStudy getTechnicalStudy() {
        return technicalStudy;
    }

    public void setTechnicalStudy(TechnicalStudy technicalStudy) {
        this.technicalStudy = technicalStudy;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public Guarantee getEnvironmentalGuarantee() {
        return environmentalGuarantee;
    }

    public void setEnvironmentalGuarantee(Guarantee environmentalGuarantee) {
        this.environmentalGuarantee = environmentalGuarantee;
    }

    public Guarantee getLeaseGuarantee() {
        return leaseGuarantee;
    }

    public void setLeaseGuarantee(Guarantee leaseGuarantee) {
        this.leaseGuarantee = leaseGuarantee;
    }
}
