package org.koritsas.vinnslu.main.ws.dto.topo;

import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.models.common.Opinion;
import org.koritsas.vinnslu.main.models.topo.StandardEnvironmentalCommitments;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.ws.dto.AbstractDto;

public class StandardEnvironmentalCommitmentsDTO implements AbstractDto<Long> {

    private Long id;

    private boolean active;

    private String protocol;

    private String ada;

    private Opinion cityPlanningOpinion;

    private Opinion forestryOpinion;

    private Opinion archeologyOpinion;

    private Opinion speleologyOpinion;

    private Topo topo;

    private Document document;

    public Long getId() {
        return id;
    }

    @Override
    public Class getClaZZ() {
        return StandardEnvironmentalCommitments.class;
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

    public Opinion getCityPlanningOpinion() {
        return cityPlanningOpinion;
    }

    public void setCityPlanningOpinion(Opinion cityPlanningOpinion) {
        this.cityPlanningOpinion = cityPlanningOpinion;
    }

    public Opinion getForestryOpinion() {
        return forestryOpinion;
    }

    public void setForestryOpinion(Opinion forestryOpinion) {
        this.forestryOpinion = forestryOpinion;
    }

    public Opinion getArcheologyOpinion() {
        return archeologyOpinion;
    }

    public void setArcheologyOpinion(Opinion archeologyOpinion) {
        this.archeologyOpinion = archeologyOpinion;
    }

    public Opinion getSpeleologyOpinion() {
        return speleologyOpinion;
    }

    public void setSpeleologyOpinion(Opinion speleologyOpinion) {
        this.speleologyOpinion = speleologyOpinion;
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
