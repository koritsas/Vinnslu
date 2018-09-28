package org.koritsas.vinnslu.models.topo;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.koritsas.vinnslu.models.common.Document;
import org.koritsas.vinnslu.models.common.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "environmental_impact_study")

public class EnvironmentalImpactStudy implements Serializable {
    @Id
    @GenericGenerator(
            name = "env_impact_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "env_impact_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "env_impact_generator")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "protocol_number")
    private String protocolNumber;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;


    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @OneToOne
    @JoinColumn(name = "env_impact_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "ENV_IMPACT_FK"))
    private Document document;


}
