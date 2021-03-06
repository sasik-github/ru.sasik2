package ru.sasik.helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * сборник вспомогательных статических функций 
 * @author sasik
 *
 */
public class AdditionFunctions {
	/**
	 * Функция для чтения файла, возвращает string
	 * @param file File фаил, который надо считать
	 * @return String
	 */
	public static String readFile(final File file) {
		StringBuffer fileBuffer = null;
		String fileString = null;
		String line = null;

		try {
			FileReader in = new FileReader(file);
			BufferedReader brd = new BufferedReader(in);
			fileBuffer = new StringBuffer();

			while ((line = brd.readLine()) != null) {
				fileBuffer.append(line).append(
						System.getProperty("line.separator")
						);
			}
			in.close();
			fileString = fileBuffer.toString();
		} catch (IOException e) {
			System.out.println("AdditionFunctions.readFile() " + e);
			return null;
		}
		return fileString;
	}
	
	
	/**
	 * Запись файла в на жесткий диск
	 * @param filename String путь к файлу
	 * @param data String информация для записи
	 */
	public static void writeFile(final String filename, final String data) {
		try {
			System.out.println("AdditionFunctions.writeFile()");
			System.out.println(filename);
			
			FileWriter file = new FileWriter(filename);
			BufferedWriter out = new BufferedWriter(file);
			// split string by Unix and windows end of line
//			for(String line : data.split("\\r?\\n")) {
				out.write(data);
//			}
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("AdditionFunctions.writeFile() " + e);
		}
	}
}
