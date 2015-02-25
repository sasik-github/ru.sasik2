package ru.sasik.entity;

import java.util.ArrayList;

public class Zone {
	
	private Double t;
	
	private ArrayList<ArrayList<Double>> values;

	public Zone(Double zoneValueT) {
		setT(zoneValueT);
		
		values = new ArrayList<ArrayList<Double>>();
	}
	
	public void add(ArrayList<Double> lineOfValues) {
		values.add(lineOfValues);
	}
	
	public ArrayList<Double> get(int index) {
		return values.get(index);
	}
	
	public ArrayList<ArrayList<Double>> getAll() {
		return values;
	}

	public Double getT() {
		return t;
	}

	public void setT(Double t) {
		this.t = t;
	}
}
