package org.koritsas.vinnslu.ws.dto;

import org.koritsas.vinnslu.models.*;

import java.util.Date;

public class TechnicalStudyDto {

    private Long id;

    private MiningLicense miningLicense;

    private Topo topo;

    private String protocolNumber;

    private boolean approved;

    private Date startDate;

    private Date endDate;

    private Date renewalDate;

    private Authority organization;

    private Person reductor;

    private Person supervisor;

    private Document document;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public MiningLicense getMiningLicense() { return miningLicense; }

    public void setMiningLicense(
	MiningLicense miningLicense) { this.miningLicense = miningLicense; }

    public Topo getTopo() { return topo; }

    public void setTopo(Topo topo) { this.topo = topo; }

    public String getProtocolNumber() { return protocolNumber; }

    public void setProtocolNumber(String protocolNumber) { this.protocolNumber = protocolNumber; }

    public boolean getApproved() { return approved; }

    public void setApproved(boolean approved) { this.approved = approved; }

    public Date getStartDate() { return startDate; }

    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }

    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public Date getRenewalDate() { return renewalDate; }

    public void setRenewalDate(Date renewalDate) { this.renewalDate = renewalDate; }

    public Authority getOrganization() { return organization; }

    public void setOrganization(Authority organization) { this.organization = organization; }

    public Person getReductor() { return reductor; }

    public void setReductor(Person reductor) { this.reductor = reductor; }

    public Person getSupervisor() { return supervisor; }

    public void setSupervisor(Person supervisor) { this.supervisor = supervisor; }

    public Document getDocument() { return document; }

    public void setDocument(Document document) { this.document = document; }
}
