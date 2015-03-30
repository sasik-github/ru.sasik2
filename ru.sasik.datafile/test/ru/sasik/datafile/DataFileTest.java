package ru.sasik.datafile;

import java.io.File;

import ru.sasik.entity.RezFile;
import ru.sasik.entity.Zone;

public class DataFileTest {
	
	public static void main(String[] args) {
//		solutionDataFileTest();
//		solutionEnergyDataFileTest();
		defaultDataFileTest();
	}
	
	public static void defaultDataFileTest() {
		DefaultDataFile defaultDataFile = new DefaultDataFile();
		defaultDataFile.openFromFile(new File("/home/sasik/EclipseWorkspace/ru.sasik2/ru.sasik.solver/solverData/SERG.DAT"));
		System.out.println("DataFileTest.defaultDataFileTest()");
		System.out.println(defaultDataFile.toString());
	}
	
	public static void solutionDataFileTest() {
		SolutionDataFile sol = new SolutionDataFile();
		
		sol.open(new File(
				"/home/sasik/EclipseWorkspace/ru.sasik2/ru.sasik.solver/solverData/SERG.REZ"));
		
		System.out.println(sol.getRezFile());
//		RezFile rezFile = sol.getRezFile();
//		for (Zone zone : rezFile.getZones()) {
//			System.out.println("Zone " + zone.getT() + " have " + zone.getAll().size() + " lines of values");
//		}
	}
	
	public static void solutionEnergyDataFileTest() {
		SolutionEnergyDataFile sol = new SolutionEnergyDataFile();
		
		sol.open(new File(
				"/home/sasik/EclipseWorkspace/ru.sasik2/ru.sasik.solver/solverData/Energy.rez"));
		
	}
}
