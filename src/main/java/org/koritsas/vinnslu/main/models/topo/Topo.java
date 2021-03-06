package org.koritsas.vinnslu.main.models.topo;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Polygon;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Parameter;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.utils.GeoJsonSerializer;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="topos")
@JsonSerialize(using = GeoJsonSerializer.class)
//@JsonDeserialize(using = GeoJsonDeserializer.class)
public class Topo implements Serializable{

    @Id
    @GenericGenerator(
	name = "topo_generator",
	strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	parameters = {
	    @Parameter(name = "sequence_name", value = "topo_seq"),
	    @Parameter(name = "initial_value", value = "1"),
	    @Parameter(name = "increment_size", value = "1")
	}
    )
    @GeneratedValue(generator = "topo_generator")
    private Long id;

    @NaturalId
    private Long abl;

    @Max(value = 300000)
    private double area;


    @Column(nullable = false)
    private Polygon polygon;

    @Column(nullable = false)
    private String municipality;

    @Column(nullable = false)
    private String community;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String prefecture;

    private boolean forest=true;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="topo_owner_id",referencedColumnName = "id",foreignKey = @ForeignKey(name="OWNER_FK"))
    private Company topoOwner;

    @ManyToOne
    @JoinColumn(name="owner_id",referencedColumnName = "id",foreignKey = @ForeignKey(name="TOPO_OWNER_FK"))
    private Company areaOwner;

    public Topo(){}

    public Topo(Polygon polygon) {
        this.polygon = polygon;
    }

    public Long getId() {
        return id;
    }

    public Long getAbl() {
        return abl;
    }

    public void setAbl(Long abl) {
        this.abl = abl;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public void setPolygon(Polygon polygon) {
        this.polygon = polygon;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrefecture() {
        return prefecture;
    }

    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }

    public boolean isForest() {
        return forest;
    }

    public void setForest(boolean forest) {
        this.forest = forest;
    }

    public Company getTopoOwner() {
        return topoOwner;
    }

    public void setTopoOwner(Company topoOwner) {
        this.topoOwner = topoOwner;
    }

    public Company getAreaOwner() {
        return areaOwner;
    }

    public void setAreaOwner(Company areaOwner) {
        this.areaOwner = areaOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Topo)) return false;
        Topo topo = (Topo) o;
        return Double.compare(topo.area, area) == 0 &&
                forest == topo.forest &&
                Objects.equals(abl, topo.abl) &&
                Objects.equals(polygon, topo.polygon) &&
                Objects.equals(municipality, topo.municipality) &&
                Objects.equals(community, topo.community) &&
                Objects.equals(location, topo.location) &&
                Objects.equals(prefecture, topo.prefecture) &&
                Objects.equals(topoOwner, topo.topoOwner) &&
                Objects.equals(areaOwner, topo.areaOwner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(abl, area, polygon, municipality, community, location, prefecture, forest, topoOwner, areaOwner);
    }

    @Override
    public String toString() {
        return "Topo_{" +
                "abl=" + abl +
                ", area=" + area +
                ", polygon=" + polygon +
                ", municipality='" + municipality + '\'' +
                ", community='" + community + '\'' +
                ", location='" + location + '\'' +
                ", prefecture='" + prefecture + '\'' +
                ", forest=" + forest +
                ", topoOwner=" + topoOwner +
                ", areaOwner=" + areaOwner +
                '}';
    }
}
