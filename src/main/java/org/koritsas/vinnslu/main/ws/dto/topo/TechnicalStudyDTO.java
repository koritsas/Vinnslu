package org.koritsas.vinnslu.main.ws.dto.topo;

import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.models.topo.EnvironmentalImpactStudy;
import org.koritsas.vinnslu.main.models.topo.TechnicalStudy;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.ws.dto.AbstractDto;

import java.util.Date;

public class TechnicalStudyDTO implements AbstractDto<Long> {

    private Long id;

    private boolean active;

    private String protocol;

    private String ada;

    private Date startDate;

    private Topo topo;

    private EnvironmentalImpactStudy environmentalImpactStudy;

    private Document document;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Class getClaZZ() {
        return TechnicalStudy.class;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAda() {
        return ada;
    }

    public void setAda(String ada) {
        this.ada = ada;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public EnvironmentalImpactStudy getEnvironmentalImpactStudy() {
        return environmentalImpactStudy;
    }

    public void setEnvironmentalImpactStudy(EnvironmentalImpactStudy environmentalImpactStudy) {
        this.environmentalImpactStudy = environmentalImpactStudy;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
