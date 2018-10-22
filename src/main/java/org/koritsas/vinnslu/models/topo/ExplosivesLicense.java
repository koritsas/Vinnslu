package org.koritsas.vinnslu.models.topo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.koritsas.vinnslu.models.common.Authority;
import org.koritsas.vinnslu.models.common.Document;
import org.koritsas.vinnslu.models.common.Person;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

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

    @Column(precision = 2,columnDefinition = "double default 0.00")
    private double anfo;

    @Column(precision = 2,columnDefinition = "double default 0.00")
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
    @JoinColumn(name = "document_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "EXPLOSIVES_DOC_FK"))
    private Document document;

    public ExplosivesLicense() {
    }

    public ExplosivesLicense(Date startDate, Date endDate, Date renewalDate, double anfo, double gelignite, int commonCartridge, int nonel, int shortFuse, int instantFuse, int retardants, Person blaster, Person licenseHolder, Authority policeStation, Topo topo, Document document) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.renewalDate = renewalDate;
        this.anfo = anfo;
        this.gelignite = gelignite;
        this.commonCartridge = commonCartridge;
        this.nonel = nonel;
        this.shortFuse = shortFuse;
        this.instantFuse = instantFuse;
        this.retardants = retardants;
        this.blaster = blaster;
        this.licenseHolder = licenseHolder;
        this.policeStation = policeStation;
        this.topo = topo;
        this.document = document;
    }

    public Long getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(Date renewalDate) {
        this.renewalDate = renewalDate;
    }

    public double getAnfo() {
        return anfo;
    }

    public void setAnfo(double anfo) {
        this.anfo = anfo;
    }

    public double getGelignite() {
        return gelignite;
    }

    public void setGelignite(double gelignite) {
        this.gelignite = gelignite;
    }

    public int getCommonCartridge() {
        return commonCartridge;
    }

    public void setCommonCartridge(int commonCartridge) {
        this.commonCartridge = commonCartridge;
    }

    public int getNonel() {
        return nonel;
    }

    public void setNonel(int nonel) {
        this.nonel = nonel;
    }

    public int getShortFuse() {
        return shortFuse;
    }

    public void setShortFuse(int shortFuse) {
        this.shortFuse = shortFuse;
    }

    public int getInstantFuse() {
        return instantFuse;
    }

    public void setInstantFuse(int instantFuse) {
        this.instantFuse = instantFuse;
    }

    public int getRetardants() {
        return retardants;
    }

    public void setRetardants(int retardants) {
        this.retardants = retardants;
    }

    public Person getBlaster() {
        return blaster;
    }

    public void setBlaster(Person blaster) {
        this.blaster = blaster;
    }

    public Person getLicenseHolder() {
        return licenseHolder;
    }

    public void setLicenseHolder(Person licenseHolder) {
        this.licenseHolder = licenseHolder;
    }

    public Authority getPoliceStation() {
        return policeStation;
    }

    public void setPoliceStation(Authority policeStation) {
        this.policeStation = policeStation;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExplosivesLicense)) return false;
        ExplosivesLicense that = (ExplosivesLicense) o;
        return Double.compare(that.anfo, anfo) == 0 &&
                Double.compare(that.gelignite, gelignite) == 0 &&
                commonCartridge == that.commonCartridge &&
                nonel == that.nonel &&
                shortFuse == that.shortFuse &&
                instantFuse == that.instantFuse &&
                retardants == that.retardants &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(renewalDate, that.renewalDate) &&
                Objects.equals(blaster, that.blaster) &&
                Objects.equals(licenseHolder, that.licenseHolder) &&
                Objects.equals(policeStation, that.policeStation) &&
                Objects.equals(topo, that.topo) &&
                Objects.equals(document, that.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, renewalDate, anfo, gelignite, commonCartridge, nonel, shortFuse, instantFuse, retardants, blaster, licenseHolder, policeStation, topo, document);
    }

    @Override
    public String toString() {
        return "ExplosivesLicense{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", renewalDate=" + renewalDate +
                ", anfo=" + anfo +
                ", gelignite=" + gelignite +
                ", commonCartridge=" + commonCartridge +
                ", nonel=" + nonel +
                ", shortFuse=" + shortFuse +
                ", instantFuse=" + instantFuse +
                ", retardants=" + retardants +
                ", blaster=" + blaster +
                ", licenseHolder=" + licenseHolder +
                ", policeStation=" + policeStation +
                ", topo=" + topo +
                ", document=" + document +
                '}';
    }
}
