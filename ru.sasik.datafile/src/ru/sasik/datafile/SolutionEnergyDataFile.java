package ru.sasik.datafile;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import ru.sasik.entity.RezFile;
import ru.sasik.entity.Zone;
import ru.sasik.helper.AdditionFunctions;

public class SolutionEnergyDataFile extends SolutionAbstract{
	
	private RezFile rezFile;
	
	/**
	 * процесс перевода из строкового типа в объектный
	 * @param data Лист строк из файла решения
	 * @return Объект решения
	 */
	protected RezFile parseString(ArrayList<String> data) {
		
		RezFile resultFile = new RezFile();
		Zone zone = new Zone(1.0);

		Iterator<String> iterator = data.iterator();
		while (iterator.hasNext()) {
			String line = iterator.next();
			ArrayList<Double> lineOfValues = new ArrayList<Double>();
			String[] split = line.split("\\s+");
			
			for (int i = 1; i < split.length; i++) {
				lineOfValues.add(Double.parseDouble(split[i]));
			}
			
			zone.add(lineOfValues);
		}
		
		resultFile.addZone(zone);
		
		return resultFile;
	}
}
