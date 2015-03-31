package ru.sasik.entity;

import java.util.ArrayList;
import java.util.Iterator;

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
		
		StringBuffer stringBuffer = new StringBuffer();
		
		for (Zone zone : zones) {
			stringBuffer.append("Zone = " + zone.getT() + ls);
			
			for (ArrayList<Double> lineofValues : zone.getAll()) {
				for (Double val : lineofValues) {
					System.out.println(val);
					stringBuffer.append(val + " ");
				}
				stringBuffer.append(ls);
			}
			
		}
		
		return stringBuffer.toString();
	}
}
