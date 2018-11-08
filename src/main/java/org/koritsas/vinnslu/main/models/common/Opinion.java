package org.koritsas.vinnslu.main.models.common;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Opinion implements Serializable {

    @Id
    @GenericGenerator(
           name = "opinions_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "opinions_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }

    )
    @GeneratedValue(generator = "opinions_generator")
    private Long id;

    private boolean opinion;

    @ManyToOne
    @JoinColumn(name = "document", referencedColumnName = "id",foreignKey = @ForeignKey(name = "OPINION_DOC_FK"))
    private Document document;

    public Opinion() {
    }

    public Opinion(boolean opinion, Document document) {
        this.opinion = opinion;
        this.document = document;
    }

    public Long getId() {
        return id;
    }

    public boolean isPositive() {
        return opinion;
    }

    public void setOpinion(boolean opinion) {
        this.opinion = opinion;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Opinion)) return false;
        Opinion opinion = (Opinion) o;
        return this.opinion == opinion.opinion &&
                Objects.equals(document, opinion.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(opinion, document);
    }

    @Override
    public String toString() {
        return "Opinion{" +
                "opinion=" + opinion +
                ", document=" + document +
                '}';
    }
}
