package org.koritsas.vinnslu.main.ws.dto.topo;

import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.models.common.Opinion;
import org.koritsas.vinnslu.main.models.topo.StandardTechnicalCommitments;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.ws.dto.AbstractDto;

public class StandardTechnicalCommitmentsDTO implements AbstractDto<Long> {

    private Long id;

    private boolean active;

    private String protocol;

    private String ada;

    private Topo topo;

    private Opinion miningInspectionOpinion;

    private Document document;

    public Long getId() {
        return id;
    }

    @Override
    public Class getClaZZ() {
        return StandardTechnicalCommitments.class;
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

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public Opinion getMiningInspectionOpinion() {
        return miningInspectionOpinion;
    }

    public void setMiningInspectionOpinion(Opinion miningInspectionOpinion) {
        this.miningInspectionOpinion = miningInspectionOpinion;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
