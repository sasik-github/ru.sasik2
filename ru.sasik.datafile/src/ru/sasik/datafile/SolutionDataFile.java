package ru.sasik.datafile;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import ru.sasik.entity.RezFile;
import ru.sasik.entity.Zone;
import ru.sasik.helper.AdditionFunctions;

public class SolutionDataFile {
	
	private RezFile rezFile;
	
	private File file;

	public SolutionDataFile() {}

	public void open(File file) {
		String rezFile = AdditionFunctions
				.readFile(file);
		
		// построчные данные
		ArrayList<String> rezFileByLine = new ArrayList<String>(Arrays.asList(rezFile.split(System.lineSeparator())));
		
		// параметры графиков
		ArrayList<String> params = new ArrayList<String>(Arrays.asList(rezFileByLine.get(0).split("=")[1].split("\\s*,\\s*")));
		
		// удаляем линию с переменными
		rezFileByLine.remove(0);
		
		// дальше пошел парсинг файла
		this.rezFile = new RezFile();
		Zone zone;
		System.out.println("SolutionDataFile.open() parse begin...");
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
		        st.close();
			        
				zone = new Zone(t);
				line = rezFileByLine.get(++i);
//				while(!line.contains("ZONE") && i < rezFileByLine.size()){
				// TODO: не обрабатываеются последние строки!"!!!!!!
				do{
					if (i == rezFileByLine.size() - 1) break;
					
					
					
					String[] strValues = line.split("[ ]+");
//					System.out.println(line);
					ArrayList<Double> lineOfValues = new ArrayList<Double>();
					for (String val : strValues) {
						if (!val.isEmpty()) {
							lineOfValues.add(Double.parseDouble(val));
//							System.out.println(Double.parseDouble(val));
						}
						
					}
					line = rezFileByLine.get(++i); 
//					System.out.println("\t" + line);
//					System.out.println("\t" + Double.parseDouble(line));
					lineOfValues.add(Double.parseDouble(line));
					zone.add(lineOfValues);
					if (rezFileByLine.size() - 1  > i) 
						line = rezFileByLine.get(++i);

				} while( !line.contains("ZONE") && rezFileByLine.size() > i);
				this.rezFile.addZone(zone);
			}
		}
		
		System.out.println("SolutionDataFile.open() parse was ended");
	}
	
	public RezFile getRezFile() {
		return rezFile;
	}

	/**
	 * возвращает открытый файл
	 * @return File
	 */
	public File getFile() {
		return file;
	}
}
