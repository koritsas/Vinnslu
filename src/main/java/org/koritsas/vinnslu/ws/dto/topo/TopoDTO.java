package org.koritsas.vinnslu.ws.dto.topo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.vividsolutions.jts.geom.Polygon;
import org.koritsas.vinnslu.models.common.Company;
import org.koritsas.vinnslu.models.topo.Topo;
import org.koritsas.vinnslu.utils.GeoJsonDesirializer;
import org.koritsas.vinnslu.ws.dto.AbstractDto;

=
public class TopoDTO implements AbstractDto<Long> {

    private Long id;

    private Long abl;

    private Polygon polygon;

    private String community;

    private String municipality;

    private String location;

    private String prefecture;

    private boolean forest;

    private Company topoOwner;

    private Company areaOwner;

    public Long getId() {
        return id;
    }

    @Override
    public Class getClaZZ() {
        return Topo.class;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isForest() {
        return forest;
    }

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

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public Company getAreaOwner() { return areaOwner; }

    public void setAreaOwner(Company areaOwner) { this.areaOwner = areaOwner; }

    @Override
    public String toString() {
        return "TopoDTO{" +
                "abl=" + abl +
                ", polygon=" + polygon +
                ", community='" + community + '\'' +
                ", municipality='" + municipality + '\'' +
                ", location='" + location + '\'' +
                ", prefecture='" + prefecture + '\'' +
                ", forest=" + forest +
                ", topoOwner=" + topoOwner +
                ", areaOwner=" + areaOwner +
                '}';
    }
}
