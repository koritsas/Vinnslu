package org.koritsas.vinnslu.models;

import com.vividsolutions.jts.geom.Polygon;
import javafx.util.Builder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="topos")
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
    private int abl;

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
    @JoinColumn(name="owner_id",foreignKey = @ForeignKey(name="OWNER_FK"))
    private Company topoOwner;

    @ManyToOne
    @JoinColumn(name="topo_owner_id",foreignKey = @ForeignKey(name="TOPO_OWNER_FK"))
    private Company owner;

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
        this.owner=topoBuilder.nestedOwner;

    }

    public Long getId() { return id; }

    public int getAbl() { return abl; }

    public void setAbl(int abl) { this.abl = abl; }

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

    public Company getOwner() { return owner; }

    public void setOwner(Company owner) { this.owner = owner; }



    public static class TopoBuilder implements Builder<Topo>{


        //Required parameters
        private Polygon nestedPolygon;


        //Optional parameters
        private int nestedAbl;

        private boolean nestedForest;

        private String nestedCommunity;

        private String nestedLocation;

        private String nestedPrefecture;

        private Company nestedTopoOwner;

        private Company nestedOwner;



        public  TopoBuilder(Polygon polygon){
            this.nestedPolygon=polygon;
        }

        public TopoBuilder setAbl(int abl){
            this.nestedAbl=abl;
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
            this.nestedOwner = owner;
            return this;
        }

        public TopoBuilder setTopoOwner(Company topoOwner){
            this.nestedTopoOwner=topoOwner;
            return this;
        }

        public TopoBuilder setNestedOwner(Company owner){
            this.nestedOwner=owner;
            return this;
        }

        @Override
        public Topo build() {
            return new Topo(this);
        }


    }
    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (super.equals(o)){
            return true;
        }
        if (o == null || this.getClass() != o.getClass()){
            return false;
        }
        Topo topo = (Topo) o;

        return polygon == topo.polygon &&
            abl == topo.abl &&
            owner == topo.owner &&
            topoOwner == topo.topoOwner &&
            community == topo.community &&
            prefecture == topo.prefecture &&
            location == topo.location &&
            forest == topo.forest;
    }

    @Override
    public int hashCode(){return Objects.hash(super.hashCode(),polygon,abl,owner,topoOwner,community,prefecture,location,forest);}
}
