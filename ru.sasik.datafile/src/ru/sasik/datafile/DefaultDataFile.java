package ru.sasik.datafile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DefaultDataFile {
	public List<Integer> main;
	public List<Double> time;
	public List<Double> phisical;
	public List<Integer> domain;
	public List<Integer> output;
	public List<Point> nodes;
//	public List<> internal;
	public List<Integer> region;
//	public List<> special;
//	public List<> otherParameter;
	public List<Double> winstruct;
//	public List<> lines;
	
	public DefaultDataFile() {
		main = new ArrayList<Integer>();
		time = new ArrayList<Double>();
		phisical = new ArrayList<Double>();
		domain = new ArrayList<Integer>();
		output = new ArrayList<Integer>();
		nodes = new ArrayList<Point>();
//		internal = new ArrayList<Integer>()
		region = new ArrayList<Integer>();
//		special = new ArrayList<Integer>();
//		otherParameter = new ArrayList<Integer>();
		winstruct = new ArrayList<Double>();
//		lines = new ArrayList<Integer>();
	}
	
	public void openFromFile(File file) {
		String text = file.;
		System.out.println(text);
		
	}

	@Override
	public String toString() {
		return "DefaultDataFile [main=" + main + ", time=" + time
				+ ", phisical=" + phisical + ", domain=" + domain + ", output="
				+ output + ", nodes=" + nodes + ", region=" + region
				+ ", winstruct=" + winstruct + "]";
	}
	
	
	
	
}
