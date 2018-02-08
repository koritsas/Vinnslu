package org.koritsas.vinnslu.models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="documents",uniqueConstraints = {@UniqueConstraint(name = "DOCUMENT_SINGULARITY",columnNames = {"organization","protocol_number","document_date"})})
public class Document implements Serializable{

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
}
