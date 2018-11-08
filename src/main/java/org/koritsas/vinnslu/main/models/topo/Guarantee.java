package org.koritsas.vinnslu.main.models.topo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.koritsas.vinnslu.main.models.common.Authority;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.models.types.GuaranteeType;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Guarantee implements Serializable {

    @Id
    @GenericGenerator(
            name = "guar_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "guar_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "guar_generator")
    private Long id;

    @Enumerated(EnumType.STRING)
    private GuaranteeType guaranteeType;

    private String protocol;

    @ManyToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "GUARANTY_AUTH_ID"))
    private Authority authority;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "GUARANTY_COMPANY_ID"))
    private Company company;

    @ManyToOne
    @JoinColumn(name = "topo_abl", referencedColumnName = "abl",foreignKey = @ForeignKey(foreignKeyDefinition = "TOPO_ABL_GUAR_FK"))
    private Topo topo;

    @Column(precision = 2)
    private double amount;

    @Lazy
    @ManyToOne
    @JoinColumn(name = "document_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "GUARANTY_DOC_ID"))
    private Document document;



}
