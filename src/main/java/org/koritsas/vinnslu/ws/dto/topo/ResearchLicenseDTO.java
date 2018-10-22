package org.koritsas.vinnslu.ws.dto.topo;

import org.koritsas.vinnslu.models.common.Document;
import org.koritsas.vinnslu.models.topo.ResearchLicense;
import org.koritsas.vinnslu.models.topo.StandardEnvironmentalCommitments;
import org.koritsas.vinnslu.models.topo.StandardTechnicalCommitments;
import org.koritsas.vinnslu.models.topo.Topo;
import org.koritsas.vinnslu.utils.AbstractDto;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.Date;

public class ResearchLicenseDTO implements AbstractDto<Long> {

    private Long id;

    private String protocol;

    private String ada;

    private boolean active;

    private Date startDate;

    private Date endDate;

    private StandardEnvironmentalCommitments standardEnvironmentalCommitments;

    private StandardTechnicalCommitments standardTechnicalCommitments;

    private Topo topo;

    private Document document;

    public Long getId() {
        return id;
    }

    @Override
    public Class getClaZZ() {
        return ResearchLicense.class;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getAda() {
        return ada;
    }

    public void setAda(String ada) {
        this.ada = ada;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public StandardEnvironmentalCommitments getStandardEnvironmentalCommitments() {
        return standardEnvironmentalCommitments;
    }

    public void setStandardEnvironmentalCommitments(StandardEnvironmentalCommitments standardEnvironmentalCommitments) {
        this.standardEnvironmentalCommitments = standardEnvironmentalCommitments;
    }

    public StandardTechnicalCommitments getStandardTechnicalCommitments() {
        return standardTechnicalCommitments;
    }

    public void setStandardTechnicalCommitments(StandardTechnicalCommitments standardTechnicalCommitments) {
        this.standardTechnicalCommitments = standardTechnicalCommitments;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
