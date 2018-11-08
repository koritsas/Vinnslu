package org.koritsas.vinnslu.main.models.topo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.models.common.Person;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class ExplosivesMemo implements Serializable {

    @Id
    @GenericGenerator(
            name = "explosives_memo_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "explosives_memo_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "explosives_memo_generator")
    private Long id;

    private boolean active;

    private String protocol;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Temporal(TemporalType.DATE)
    private Date renewalDate;

    @Column(precision = 2)
    private double anfo;

    @Column(precision = 2)
    private double gelignite;

    @Column(columnDefinition = "int default 0")
    private int commonCartridge;

    @Column(columnDefinition = "int default 0")
    private int nonel;

    @Column(columnDefinition = "int default 0")
    private int shortFuse;

    @Column(columnDefinition = "int default 0")
    private int instantFuse;

    @Column(columnDefinition = "int default 0")
    private int retardants;

    @ManyToOne
    @JoinColumn(name = "blaster_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "BLASTER_FK"))
    private Person blaster;

    @ManyToOne
    @JoinColumn(name = "topo_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "TOPO_ID_EXPL_MEMO_FK"))
    private Topo topo;

    @ManyToOne
    @JoinColumn(name = "topo_abl",referencedColumnName = "abl",foreignKey = @ForeignKey(name = "TOPO_ABL_EXPL_MEMO_FK"))
    private Topo topo_abl;


    @ManyToOne
    @JoinColumn(name = "document_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "EXPLOSIVES_DOC_FK"))
    private Document document;

}
