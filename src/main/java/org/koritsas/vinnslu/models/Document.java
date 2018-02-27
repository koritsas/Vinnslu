package org.koritsas.vinnslu.models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="documents",uniqueConstraints = {@UniqueConstraint(name = "DOCUMENT_SINGULARITY",columnNames = {"organization","protocol_number","document_date"})})
public class Document extends ResourceSupport implements Serializable {

    @Id
    @GenericGenerator(
        name = "document_generator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
            @Parameter(name = "sequence_name", value = "document_seq"),
            @Parameter(name = "initial_value", value = "1"),
            @Parameter(name = "increment_size", value = "1")
        }
    )
    @GeneratedValue(generator = "document_generator")
    private Long id;

    private String reductor;

    @Column(name = "organization")
    private String organization;

    @Column(name="protocol_number")
    private String protocolNumber;

    @Column(name = "document_date")
    @Temporal(TemporalType.DATE)
    private Date documentDate;

    @Lob
    private File file;

    public Document(){}

    public Document(String reductor, String organization, String protocolNumber, Date documentDate, File file) {
        this.reductor = reductor;
        this.organization = organization;
        this.protocolNumber = protocolNumber;
        this.documentDate = documentDate;
        this.file = file;
    }

    public Long getEntityId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getReductor() { return reductor; }

    public void setReductor(String reductor) { this.reductor = reductor; }

    public String getOrganization() { return organization; }

    public void setOrganization(String organization) { this.organization = organization; }

    public String getProtocolNumber() { return protocolNumber; }

    public void setProtocolNumber(String protocolNumber) { this.protocolNumber = protocolNumber; }

    public Date getDocumentDate() { return documentDate; }

    public void setDocumentDate(Date documentDate) { this.documentDate = documentDate; }

    public File getFile() { return file; }

    public void setFile(File file) { this.file = file; }
}
