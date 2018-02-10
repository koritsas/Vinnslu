package org.koritsas.vinnslu.ws.dto;

public class TopoDto {

    private int abl;
    public int getAbl() { return abl; }
    public void setAbl(int abl) { this.abl = abl; }

    private String community;
    public String getCommunity() { return community; }
    public void setCommunity(String community) { this.community = community; }

    private String location;
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    private String prefecture;
    public String getPrefecture() { return prefecture; }
    public void setPrefecture(String prefecture) { this.prefecture = prefecture; }

    @Override
    public String toString() {
	return "TopoDto{" +
	    "abl=" + abl +
	    ", community='" + community + '\'' +
	    ", location='" + location + '\'' +
	    ", prefecture='" + prefecture + '\'' +
	    '}';
    }

}
