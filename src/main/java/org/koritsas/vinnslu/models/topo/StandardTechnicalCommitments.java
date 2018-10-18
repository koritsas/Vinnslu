package org.koritsas.vinnslu.models.topo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Parameter;

import org.koritsas.vinnslu.models.common.Document;
import org.koritsas.vinnslu.models.common.Opinions;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity


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

    private boolean active;

    private String protocol;

    private String ada;

    @ManyToOne
    @JoinColumn(name = "topo_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "PTD_TOPO_ID_FK"))
    private Topo topo;

    @ManyToOne
    @JoinColumn(name = "opinions_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "PTD_OPINIONS_ID_FK"))
    private Opinions opinions;


    @ManyToOne
    @JoinColumn(name = "document", referencedColumnName = "id", foreignKey = @ForeignKey(name = "STC_DOCUMENT_ID"))
    private Document document;

    public StandardTechnicalCommitments() {
    }

    public StandardTechnicalCommitments(boolean active, String protocol, String ada, Topo topo, Opinions opinions, Document document) {
        this.active = active;
        this.protocol = protocol;
        this.ada = ada;
        this.topo = topo;
        this.opinions = opinions;
        this.document = document;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StandardTechnicalCommitments)) return false;
        StandardTechnicalCommitments that = (StandardTechnicalCommitments) o;
        return active == that.active &&
                Objects.equals(protocol, that.protocol) &&
                Objects.equals(ada, that.ada) &&
                Objects.equals(topo, that.topo) &&
                Objects.equals(opinions, that.opinions) &&
                Objects.equals(document, that.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(active, protocol, ada, topo, opinions, document);
    }

    @Override
    public String toString() {
        return "StandardTechnicalCommitments{" +
                "active=" + active +
                ", protocol='" + protocol + '\'' +
                ", ada='" + ada + '\'' +
                ", topo=" + topo +
                ", opinions=" + opinions +
                ", document=" + document +
                '}';
    }
}
