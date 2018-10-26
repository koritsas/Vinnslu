package org.koritsas.vinnslu.models.topo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import org.koritsas.vinnslu.models.common.Document;
import org.koritsas.vinnslu.models.common.Opinion;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class StandardEnvironmentalCommitments implements Serializable{

    @Id
    @GenericGenerator(
            name = "ppd_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "ppd_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "ppd_generator")
    private Long id;

    private boolean active;

    private String protocol;

    private String ada;

    @ManyToOne
    @JoinColumn(name = "city_planning_opinion_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "CP_PPD_OPINION_ID_FK"))
    private Opinion cityPlanningOpinion;

    @ManyToOne
    @JoinColumn(name = "forestry_opinion_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FORESTRY_PPD_OPINION_ID_FK"))
    private Opinion forestryOpinion;

    @ManyToOne
    @JoinColumn(name = "archeology_opinion_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "ARCHEOLOGY_PPD_OPINION_ID_FK"))
    private Opinion archeologyOpinion;

    @ManyToOne
    @JoinColumn(name = "speleology_opinion_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "SPELEOLOGY_PPD_OPINION_ID_FK"))
    private Opinion speleologyOpinion;

    @ManyToOne
    @JoinColumn(name = "topo_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "PPD_TOPO_ID_FK"))
    private Topo topo;

    @Lazy
    @ManyToOne
    @JoinColumn(name = "document", referencedColumnName = "id", foreignKey = @ForeignKey(name = "SEC_DOCUMENT_ID"))
    private Document document;

    public StandardEnvironmentalCommitments() {
    }

    public Long getId() {
        return id;
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

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StandardEnvironmentalCommitments)) return false;
        StandardEnvironmentalCommitments that = (StandardEnvironmentalCommitments) o;
        return active == that.active &&
                Objects.equals(protocol, that.protocol) &&
                Objects.equals(ada, that.ada) &&
                Objects.equals(cityPlanningOpinion, that.cityPlanningOpinion) &&
                Objects.equals(forestryOpinion, that.forestryOpinion) &&
                Objects.equals(archeologyOpinion, that.archeologyOpinion) &&
                Objects.equals(speleologyOpinion, that.speleologyOpinion) &&
                Objects.equals(topo, that.topo) &&
                Objects.equals(document, that.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(active, protocol, ada, cityPlanningOpinion, forestryOpinion, archeologyOpinion, speleologyOpinion, topo, document);
    }

    @Override
    public String toString() {
        return "StandardEnvironmentalCommitments{" +
                "active=" + active +
                ", protocol='" + protocol + '\'' +
                ", ada='" + ada + '\'' +
                ", cityPlanningOpinion=" + cityPlanningOpinion +
                ", forestryOpinion=" + forestryOpinion +
                ", archeologyOpinion=" + archeologyOpinion +
                ", speleologyOpinion=" + speleologyOpinion +
                ", topo=" + topo +
                ", document=" + document +
                '}';
    }
}
