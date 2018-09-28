package org.koritsas.vinnslu.models.topo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import org.koritsas.vinnslu.models.common.Document;
import org.koritsas.vinnslu.models.common.Status;

import javax.persistence.*;
import javax.validation.constraints.Max;
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

    @Enumerated(EnumType.STRING)
    private Status status;

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

    @Max(300000)
    private double area;

    public ResearchLicense() {
    }


}
