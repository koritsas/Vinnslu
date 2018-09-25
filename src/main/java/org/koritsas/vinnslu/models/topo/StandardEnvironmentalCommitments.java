package org.koritsas.vinnslu.models.topo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.koritsas.vinnslu.models.common.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "standard_environmental_commitments")
public class StandardEnvironmentalCommitments implements Serializable{

    @Id
    @GenericGenerator(
            name = "sec_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "sec_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "sec_generator")
    private Long id;

    private boolean active;

    @Column(name = "archeology_opinion")
    private boolean archeologyOpinion;

    @Column(name = "ministry_opinion")
    private boolean ministryOpinion;

    @Column(name = "forestry_opinion")
    private boolean forestryOpinion;

    @Column(name = "mining_inspection_opinion")
    private boolean miningInspectionOpinion;

    @ManyToOne
    @JoinColumn(name = "document", referencedColumnName = "id", foreignKey = @ForeignKey(name = "SEC_DOCUMENT_ID"))
    private Document document;

    public StandardEnvironmentalCommitments() {
    }

    public StandardEnvironmentalCommitments(boolean active, boolean archeologyOpinion, boolean ministryOpinion, boolean forestryOpinion, boolean miningInspectionOpinion, Document document) {
        this.active = active;
        this.archeologyOpinion = archeologyOpinion;
        this.ministryOpinion = ministryOpinion;
        this.forestryOpinion = forestryOpinion;
        this.miningInspectionOpinion = miningInspectionOpinion;
        this.document = document;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StandardEnvironmentalCommitments that = (StandardEnvironmentalCommitments) o;
        return active == that.active &&
                archeologyOpinion == that.archeologyOpinion &&
                ministryOpinion == that.ministryOpinion &&
                forestryOpinion == that.forestryOpinion &&
                miningInspectionOpinion == that.miningInspectionOpinion &&
                Objects.equals(document, that.document);
    }

    @Override
    public int hashCode() {

        return Objects.hash(active, archeologyOpinion, ministryOpinion, forestryOpinion, miningInspectionOpinion, document);
    }

    @Override
    public String toString() {
        return "StandardEnvironmentalCommitments{" +
                "id=" + id +
                ", active=" + active +
                ", archeologyOpinion=" + archeologyOpinion +
                ", ministryOpinion=" + ministryOpinion +
                ", forestryOpinion=" + forestryOpinion +
                ", miningInspectionOpinion=" + miningInspectionOpinion +
                ", document=" + document +
                '}';
    }
}
