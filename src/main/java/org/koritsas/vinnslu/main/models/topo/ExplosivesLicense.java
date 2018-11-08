package org.koritsas.vinnslu.main.models.topo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.koritsas.vinnslu.main.models.common.Authority;
import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.models.common.Person;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class ExplosivesLicense implements Serializable {

    @Id
    @GenericGenerator(
            name = "explosives_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "explosives_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "explosives_generator")
    private Long id;

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
    @JoinColumn(name = "license_holder_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "LICENSE_HOLDER_FK"))
    private Person licenseHolder;

    @ManyToOne
    @JoinColumn(name = "police_station_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "POLICE_STATION_FK"))
    private Authority policeStation;

    @ManyToOne
    @JoinColumn(name = "topo_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "TOPO_FK"))
    private Topo topo;

    @ManyToOne
    @JoinColumn(name = "explosives_memo_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "EXPL_MEMO_FK"))
    private ExplosivesMemo explosivesMemo;

    @ManyToOne
    @JoinColumn(name = "document_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "EXPLOSIVES_DOC_FK"))
    private Document document;

    public ExplosivesLicense() {
    }


}
