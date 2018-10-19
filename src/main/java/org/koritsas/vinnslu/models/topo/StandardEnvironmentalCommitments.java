package org.koritsas.vinnslu.models.topo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import org.koritsas.vinnslu.models.common.Document;
import org.koritsas.vinnslu.models.common.Opinions;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "standard_environmental_commitments")
public class StandardEnvironmentalCommitments implements Serializable{

    @Id
    @GenericGenerator(
            name = "ppd_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "ppd_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "ppd_generator")
    private Long id;

    private boolean active;

    private String protocol;

    private String ada;

    @ManyToOne
    @JoinColumn(name = "opinions_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "PTD_OPINIONS_ID_FK"))
    private Opinions opinions;

    @ManyToOne
    @JoinColumn(name = "topo_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "PPD_TOPO_ID_FK"))
    private Topo topo;


    @Lazy
    @ManyToOne
    @JoinColumn(name = "document", referencedColumnName = "id", foreignKey = @ForeignKey(name = "SEC_DOCUMENT_ID"))
    private Document document;

    public StandardEnvironmentalCommitments() {
    }

    public Long getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getAda() {
        return ada;
    }

    public void setAda(String ada) {
        this.ada = ada;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Opinions getOpinions() {
        return opinions;
    }

    public void setOpinions(Opinions opinions) {
        this.opinions = opinions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StandardEnvironmentalCommitments)) return false;
        StandardEnvironmentalCommitments that = (StandardEnvironmentalCommitments) o;
        return active == that.active &&
                Objects.equals(protocol, that.protocol) &&
                Objects.equals(ada, that.ada) &&
                Objects.equals(opinions, that.opinions) &&
                Objects.equals(topo, that.topo) &&
                Objects.equals(document, that.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(active, protocol, ada, opinions, topo, document);
    }

    @Override
    public String toString() {
        return "StandardEnvironmentalCommitments{" +
                "id=" + id +
                ", active=" + active +
                ", protocol='" + protocol + '\'' +
                ", ada='" + ada + '\'' +
                ", opinions=" + opinions +
                ", topo=" + topo +
                ", document=" + document +
                '}';
    }
}
