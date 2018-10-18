package org.koritsas.vinnslu.models.topo;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import org.koritsas.vinnslu.models.common.Document;
import org.koritsas.vinnslu.models.common.Person;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "technical_study")
public class TechnicalStudy {

    @Id
    @GenericGenerator(
            name = "tech_study_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "tech_study_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "tech_study_generator")
    private Long id;

    private boolean active;

    private String protocol;

    private String ada;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Lazy
    @ManyToOne
    @JoinColumn(name = "topo_id",referencedColumnName = "id", foreignKey = @ForeignKey(name = "TECHNICAL_STUDY_TOPO_FK"))
    private Topo topo;

    @Lazy
    @ManyToOne
    @JoinColumn(name = "environmental_impact_id",referencedColumnName = "id", foreignKey = @ForeignKey(name = "TECHNICAL_STUDY_ENV_FK"))
    private EnvironmentalImpactStudy environmentalImpactStudy;


    @Lazy
    @ManyToOne
    @JoinColumn(name = "document_id",referencedColumnName = "id", foreignKey = @ForeignKey(name = "TECHNICAL_STUDY_DOC_FK"))
    private Document document;

    public TechnicalStudy() {
    }

    public TechnicalStudy(boolean active, String protocol, String ada, Date startDate, Topo topo, EnvironmentalImpactStudy environmentalImpactStudy, Document document) {
        this.active = active;
        this.protocol = protocol;
        this.ada = ada;
        this.startDate = startDate;
        this.topo = topo;
        this.environmentalImpactStudy = environmentalImpactStudy;
        this.document = document;
    }

    public Long getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TechnicalStudy)) return false;
        TechnicalStudy that = (TechnicalStudy) o;
        return active == that.active &&
                Objects.equals(protocol, that.protocol) &&
                Objects.equals(ada, that.ada) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(topo, that.topo) &&
                Objects.equals(environmentalImpactStudy, that.environmentalImpactStudy) &&
                Objects.equals(document, that.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(active, protocol, ada, startDate, topo, environmentalImpactStudy, document);
    }

    @Override
    public String toString() {
        return "TechnicalStudy{" +
                "active=" + active +
                ", protocol='" + protocol + '\'' +
                ", ada='" + ada + '\'' +
                ", startDate=" + startDate +
                ", topo=" + topo +
                ", environmentalImpactStudy=" + environmentalImpactStudy +
                ", document=" + document +
                '}';
    }


}
