package ru.sasik.entity;

import java.util.ArrayList;

public class RezFile {
	
	private ArrayList<Zone> zones;
	
	public RezFile() {
		zones = new ArrayList<Zone>();
	}
	
	public void addZone(Double valueT, ArrayList<Double> lineOfValues) {
		Zone zone = new Zone(valueT);
		zone.add(lineOfValues);
		this.addZone(zone);
	}
	
	public void addZone(Zone zone) {
		zones.add(zone);
	}

	public ArrayList<Zone> getZones() {
		return zones;
	}

	public void setZones(ArrayList<Zone> zones) {
		this.zones = zones;
	}
	
	@Override
	public String toString() {
		
		String ls = System.lineSeparator();
		String result = "RezFile Container" + ls;
		
		for (Zone zone: zones) {
			result += "ZONE = " + zone.getT() + ls;
			for (ArrayList<Double> lineOfValues : zone.getAll()) {
				for (Double val : lineOfValues) {
					result += val.toString() + " ";
				}
				result += ls;
			}
		}
		return result;
	}
}
