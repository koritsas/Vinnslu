package org.koritsas.vinnslu.main.models.topo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import org.koritsas.vinnslu.main.models.common.Document;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class ResearchLicense implements Serializable {

    @Id
    @GenericGenerator(
            name = "research_license_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "research_license_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "research_license_generator")
    private Long id;

    private String protocol;

    @Column(unique = true)
    private String ada;

    private boolean active;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Lazy
    @ManyToOne
    @JoinColumn(name = "sec_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "RESEARCH_SEC_ID"))
    private StandardEnvironmentalCommitments standardEnvironmentalCommitments;

    @Lazy
    @ManyToOne
    @JoinColumn(name = "stc_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "RESEARCH_STC_ID"))
    private StandardTechnicalCommitments standardTechnicalCommitments;


    @Lazy
    @ManyToOne
    @JoinColumn(name = "topo_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "RESEARCH_TOPO_ID"))
    private Topo topo;

    @Lazy
    @ManyToOne
    @JoinColumn(name = "document_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "RESEARCH_DOC_ID"))
    private Document document;

    public ResearchLicense() {
    }

    public ResearchLicense(String protocol, String ada, boolean active, Date startDate, Date endDate, StandardEnvironmentalCommitments standardEnvironmentalCommitments, StandardTechnicalCommitments standardTechnicalCommitments, Topo topo, Document document) {
        this.protocol = protocol;
        this.ada = ada;
        this.active = active;
        this.startDate = startDate;
        this.endDate = endDate;
        this.standardEnvironmentalCommitments = standardEnvironmentalCommitments;
        this.standardTechnicalCommitments = standardTechnicalCommitments;
        this.topo = topo;
        this.document = document;
    }

    public Long getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResearchLicense)) return false;
        ResearchLicense that = (ResearchLicense) o;
        return active == that.active &&
                Objects.equals(protocol, that.protocol) &&
                Objects.equals(ada, that.ada) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(standardEnvironmentalCommitments, that.standardEnvironmentalCommitments) &&
                Objects.equals(standardTechnicalCommitments, that.standardTechnicalCommitments) &&
                Objects.equals(topo, that.topo) &&
                Objects.equals(document, that.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(protocol, ada, active, startDate, endDate, standardEnvironmentalCommitments, standardTechnicalCommitments, topo, document);
    }

    @Override
    public String toString() {
        return "ResearchLicense{" +
                "protocol='" + protocol + '\'' +
                ", ada='" + ada + '\'' +
                ", active=" + active +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", standardEnvironmentalCommitments=" + standardEnvironmentalCommitments +
                ", standardTechnicalCommitments=" + standardTechnicalCommitments +
                ", topo=" + topo +
                ", document=" + document +
                '}';
    }
}
