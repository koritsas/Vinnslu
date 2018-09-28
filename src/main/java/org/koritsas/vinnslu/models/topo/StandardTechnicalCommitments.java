package org.koritsas.vinnslu.models.topo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import org.koritsas.vinnslu.models.common.Document;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "standard_technical_commitments")

public class StandardTechnicalCommitments implements Serializable {

    @Id
    @GenericGenerator(
            name = "stc_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "stc_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "stc_generator")
    private Long id;

    @Column(name = "mining_inspection_opinion")
    private boolean miningInspectionOpinion;

    @ManyToOne
    @JoinColumn(name = "document", referencedColumnName = "id", foreignKey = @ForeignKey(name = "STC_DOCUMENT_ID"))
    private Document document;

    public StandardTechnicalCommitments() {
    }

    public StandardTechnicalCommitments(boolean miningInspectionOpinion) {
        this.miningInspectionOpinion = miningInspectionOpinion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isMiningInspectionOpinion() {
        return miningInspectionOpinion;
    }

    public void setMiningInspectionOpinion(boolean miningInspectionOpinion) {
        this.miningInspectionOpinion = miningInspectionOpinion;
    }
}
