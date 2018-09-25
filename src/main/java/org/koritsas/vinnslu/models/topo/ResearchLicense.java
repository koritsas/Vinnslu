package org.koritsas.vinnslu.models.topo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.koritsas.vinnslu.models.common.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "research_license")
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

    private boolean active;

    @Column(name = "protocol_number")
    private String protocolNumber;

    private String ada;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @OneToOne
    @JoinColumn(name = "standard_environmental_commitments", referencedColumnName = "id", foreignKey = @ForeignKey(name="SEC_ID"))
    private StandardEnvironmentalCommitments standardEnvironmentalCommitments;

    @OneToOne
    @JoinColumn(name = "standard_technical_commitments", referencedColumnName = "id", foreignKey = @ForeignKey(name="STC_ID"))
    private StandardTechnicalCommitments standardTechnicalCommitments;

    @OneToOne
    @JoinColumn(name = "document", referencedColumnName = "id", foreignKey = @ForeignKey(name = "RESEARCH_DOCUMENT_ID"))
    private Document document;

    public ResearchLicense() {
    }

    public ResearchLicense(boolean active, String protocolNumber, String ada, Date startDate, Date endDate, StandardEnvironmentalCommitments standardEnvironmentalCommitments, StandardTechnicalCommitments standardTechnicalCommitments, Document document) {
        this.active = active;
        this.protocolNumber = protocolNumber;
        this.ada = ada;
        this.startDate = startDate;
        this.endDate = endDate;
        this.standardEnvironmentalCommitments = standardEnvironmentalCommitments;
        this.standardTechnicalCommitments = standardTechnicalCommitments;
        this.document = document;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getProtocolNumber() {
        return protocolNumber;
    }

    public void setProtocolNumber(String protocolNumber) {
        this.protocolNumber = protocolNumber;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
        if (o == null || getClass() != o.getClass()) return false;
        ResearchLicense that = (ResearchLicense) o;
        return active == that.active &&
                Objects.equals(protocolNumber, that.protocolNumber) &&
                Objects.equals(ada, that.ada) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(standardEnvironmentalCommitments, that.standardEnvironmentalCommitments) &&
                Objects.equals(standardTechnicalCommitments, that.standardTechnicalCommitments) &&
                Objects.equals(document, that.document);
    }

    @Override
    public int hashCode() {

        return Objects.hash(active, protocolNumber, ada, startDate, endDate, standardEnvironmentalCommitments, standardTechnicalCommitments, document);
    }

    @Override
    public String toString() {
        return "ResearchLicense{" +
                "id=" + id +
                ", active=" + active +
                ", protocolNumber='" + protocolNumber + '\'' +
                ", ada='" + ada + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", standardEnvironmentalCommitments=" + standardEnvironmentalCommitments +
                ", standardTechnicalCommitments=" + standardTechnicalCommitments +
                ", document=" + document +
                '}';
    }
}
