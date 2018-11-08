package org.koritsas.vinnslu.main.models.topo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.koritsas.vinnslu.main.models.common.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
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

    private String ada;

    private String protocol;

    private boolean active;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "topo_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "ENV_IMPACT_TOPO_ID"))
    private Topo topo;

    @ManyToOne
    @JoinColumn(name = "env_impact_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "ENV_IMPACT_FK"))
    private Document document;


}
