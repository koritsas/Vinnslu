package org.koritsas.vinnslu.ws.dto;

import org.koritsas.vinnslu.models.common.Company;
import org.koritsas.vinnslu.models.topo.Topo;
import org.koritsas.vinnslu.utils.AbstractDto;

public class TopoDto implements AbstractDto<Long> {

    private Long id;

    private int abl;

    private String polygon;

    private String community;

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

    public int getAbl() { return abl; }

    public void setAbl(int abl) { this.abl = abl; }

    public String getPolygon() { return polygon; }

    public void setPolygon(String polygon) { this.polygon = polygon; }

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

    @Override
    public String toString() {
        return "TopoDto{" +
            "abl=" + abl +
            ", polygon=" + polygon +
            ", community='" + community + '\'' +
            ", location='" + location + '\'' +
            ", prefecture='" + prefecture + '\'' +
            ", forest=" + forest +
            ", topoOwner=" + topoOwner +
            ", areaOwner=" + areaOwner +
            '}';
    }
}
