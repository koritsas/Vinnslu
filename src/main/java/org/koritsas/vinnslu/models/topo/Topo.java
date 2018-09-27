package org.koritsas.vinnslu.models.topo;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Polygon;
import javafx.util.Builder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Parameter;
import org.koritsas.vinnslu.models.common.Company;
import org.koritsas.vinnslu.utils.GeoJsonSerializer;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="topos")
@JsonSerialize(using = GeoJsonSerializer.class)
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
    @Column(name="abl")
    private Long abl;


    @Column(nullable = false)
    private Polygon polygon;

    @Column(name="community",nullable = false)
    private String community;

    @Column(name="location",nullable = false)
    private String location;

    @Column(name="prefecture",nullable = false)
    private String prefecture;

    @Column(name="forest")
    private boolean forest=true;

    @ManyToOne
    @JoinColumn(name="topo_owner_id",foreignKey = @ForeignKey(name="OWNER_FK"))
    private Company topoOwner;

    @ManyToOne
    @JoinColumn(name="owner_id",foreignKey = @ForeignKey(name="TOPO_OWNER_FK"))
    private Company areaOwner;

    @OneToOne
    @JoinColumn(name = "research_license_id",referencedColumnName = "id",foreignKey =@ForeignKey(name="RESEARCH_LICENSE_FK"))
    private ResearchLicense researchLicense;

    public Topo(){}

    private Topo(Polygon polygon) {
        this.polygon = polygon;
    }

    public Topo(TopoBuilder topoBuilder){
        this.polygon=topoBuilder.nestedPolygon;
        this.abl=topoBuilder.nestedAbl;
        this.topoOwner =topoBuilder.nestedTopoOwner;
        this.community=topoBuilder.nestedCommunity;
        this.forest=topoBuilder.nestedForest;
        this.location=topoBuilder.nestedLocation;
        this.prefecture=topoBuilder.nestedPrefecture;
        this.areaOwner =topoBuilder.nestedAreaOwner;
        this.researchLicense = topoBuilder.nestedResearchLicense;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() { return id; }

    public Long getAbl() { return abl; }

    public void setAbl(Long abl) { this.abl = abl; }

    public Polygon getPolygon() { return polygon; }

    public void setPolygon(Polygon polygon) { this.polygon = polygon; }

    public String getCommunity() { return community; }

    public void setCommunity(String community) { this.community = community; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public String getPrefecture() { return prefecture; }

    public void setPrefecture(String prefecture) { this.prefecture = prefecture; }

    public boolean getForest() { return forest; }

    public void setForest(boolean forest) { this.forest = forest; }

    public Company getTopoOwner() { return topoOwner; }

    public void setTopoOwner(Company topoOwner) { this.topoOwner = topoOwner; }

    public Company getAreaOwner() { return areaOwner; }

    public void setAreaOwner(Company areaOwner) { this.areaOwner = areaOwner; }



    public static class TopoBuilder implements Builder<Topo>{


        //Required parameters
        private Polygon nestedPolygon;


        //Optional parameters
        private ResearchLicense nestedResearchLicense;

        private Long nestedAbl;

        private boolean nestedForest;

        private String nestedCommunity;

        private String nestedLocation;

        private String nestedPrefecture;

        private Company nestedTopoOwner;

        private Company nestedAreaOwner;



        public  TopoBuilder(Polygon polygon){
            this.nestedPolygon=polygon;
        }

        public TopoBuilder setAbl(Long abl){
            this.nestedAbl=abl;
            return this;
        }

        public TopoBuilder setResearchLicense(ResearchLicense researchLicense){
            this.nestedResearchLicense =researchLicense;
            return this;
        }

        public TopoBuilder setForest(boolean forest){
            this.nestedForest=forest;
            return this;
        }

        public TopoBuilder setCommunity(String community){
            this.nestedCommunity=community;
            return this;
        }

        public TopoBuilder setPrefecture(String prefecture){
            this.nestedPrefecture=prefecture;
            return this;
        }

        public TopoBuilder setLocation(String location){
            this.nestedLocation = location;
            return this;
        }

        public TopoBuilder setOwner(Company owner){
            this.nestedAreaOwner = owner;
            return this;
        }

        public TopoBuilder setTopoOwner(Company topoOwner){
            this.nestedTopoOwner=topoOwner;
            return this;
        }

        public TopoBuilder setNestedAreaOwner(Company owner){
            this.nestedAreaOwner =owner;
            return this;
        }

        @Override
        public Topo build() {
            return new Topo(this);
        }


    }

}
