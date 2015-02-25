package ru.sasik.datafile;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import ru.sasik.entity.RezFile;
import ru.sasik.entity.Zone;
import ru.sasik.helper.AdditionFunctions;

public class SolutionEnergyDataFile {
	
	private RezFile rezFile;
	
	public void open(File file) {
		String rezFile = AdditionFunctions
				.readFile(file);
		
		// построчные данные
		ArrayList<String> rezFileByLine = new ArrayList<String>(Arrays.asList(rezFile.split(System.lineSeparator())));
		
		
		// дальше пошел парсинг файла
		this.rezFile = new RezFile();
		Zone zone;
		System.out.println("SolutionEnergyDataFile.open() parse begin...");
		
		Iterator<String> iterator = rezFileByLine.iterator();
		while (iterator.hasNext()) {
			String line = iterator.next();
			
			String[] split = line.split("\\s+");
			
			
			
			for (String string : split) {
				System.out.println(string);
				System.out.println("__");
			}
//			break;
		}
				
		System.out.println("SolutionEnergyDataFile.open() parse was ended");
	}
}
