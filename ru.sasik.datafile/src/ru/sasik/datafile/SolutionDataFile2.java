package ru.sasik.datafile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

import ru.sasik.entity.RezFile;
import ru.sasik.entity.Zone;

public class SolutionDataFile2 extends SolutionAbstract{

	@Override
	protected RezFile parseString(ArrayList<String> rezFileByLine) {
		// параметры графиков
		ArrayList<String> params = new ArrayList<String>(Arrays.asList(rezFileByLine.get(0).split("=")[1].split("\\s*,\\s*")));
		int paramsSize = params.size();
		
		// удаляем линию с переменными
		rezFileByLine.remove(0);
		
		// дальше пошел парсинг файла
		RezFile rezFile = new RezFile();
		Zone zone;
		for (Iterator lineIterator = rezFileByLine.iterator(); lineIterator.hasNext();) {
			String line = (String) lineIterator.next();
			if (line.contains("ZONE")) {
				
				// костыль что бы вычленить число с экспонентой,
				// тут надо переделать!!!
				Scanner st = new Scanner(line);
				st.useLocale(new Locale("en_US"));
		        while (!st.hasNextDouble())
		        {
		            st.next();
		        }
		        Double t = st.nextDouble();
//		        System.out.println("ZONE " + t);
		        st.close();
		        
		        zone = new Zone(t);
		        
		        if (lineIterator.hasNext()) { line = (String) lineIterator.next();} else { break;}
		        do {
		        	ArrayList<Double> lineOfValues = new ArrayList<Double>();
			        st = new Scanner(line);
			        st.useLocale(new Locale("en_US"));
//			        System.out.println(line);
			        for (int i = 0; i < paramsSize; i++) {
						
				        if (!st.hasNextDouble()) {
				        	if (lineIterator.hasNext()) { line = (String) lineIterator.next();} else { break;}
				        	st = new Scanner(line);
				        } 
			        	double nextDouble = st.nextDouble();
//			        	System.out.println(nextDouble);
			        	lineOfValues.add(nextDouble);
					}
			        st.close();
			        zone.add(lineOfValues);
			        if (lineIterator.hasNext()) { line = (String) lineIterator.next();} else { break;}
		        } while (!line.contains("ZONE"));
		        rezFile.addZone(zone);
			}
		}
		
		return rezFile;
	}

}
