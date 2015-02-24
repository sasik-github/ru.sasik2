package ru.sasik.datafile;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import ru.sasik.helper.AdditionFunctions;

public class SolutionDataFile {
	
	private RezFile rezFile;

	public SolutionDataFile() {

	}

	public void open() {
		String rezFile = AdditionFunctions
				.readFile(new File(
						"/home/sasik/EclipseWorkspace/ru.sasik2/ru.sasik.solver/solverData/SERG.REZ"));
		
		// построчные данные
		ArrayList<String> rezFileByLine = new ArrayList<String>(Arrays.asList(rezFile.split(System.lineSeparator())));
		
		// параметры графиков
		ArrayList<String> params = new ArrayList<String>(Arrays.asList(rezFileByLine.get(0).split("=")[1].split("\\s*,\\s*")));
		
		// удаляем линию с переменными
		rezFileByLine.remove(0);
		
		// дальше пошел парсинг файла
		this.rezFile = new RezFile();
		Zone zone;
		for (int i = 0; i < rezFileByLine.size(); i++) {
			String line = rezFileByLine.get(i);
			
			// обрабатывать каждую зону отдельно
			if (line.contains("ZONE")) {
//				Double t = Double.parseDouble(line.split("=\"")[1]);
				
				Scanner st = new Scanner(line);
		        while (!st.hasNextDouble())
		        {
		            st.next();
		        }
		        Double t = st.nextDouble();
			        
				zone = new Zone(t);
				line = rezFileByLine.get(++i);
				while(!line.startsWith("ZONE")) {
					// TODO: доделать сплит, почемуто разделитель точка
					String[] strValues = line.split("[ ]+");
					ArrayList<Double> lineOfValues = new ArrayList<Double>();
					for (String val : strValues) {
						System.out.println(val + System.lineSeparator());
						if (!val.isEmpty())
							lineOfValues.add(Double.parseDouble(val));
					}
					line = rezFileByLine.get(++i);
					lineOfValues.add(Double.parseDouble(line));
					zone.add(lineOfValues);
					line = rezFileByLine.get(++i);
				}
				this.rezFile.addZone(zone);
			}
		}
		
		System.out.println(this.rezFile);
	}
	
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
//				result += zone.values.toString() + ls;
			}
			
			return result;
		}
	}
	
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
}
