package org.koritsas.vinnslu.models.topo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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

    private Date startDate;


}
