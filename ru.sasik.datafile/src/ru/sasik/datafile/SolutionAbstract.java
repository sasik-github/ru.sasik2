package ru.sasik.datafile;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import ru.sasik.entity.RezFile;
import ru.sasik.helper.AdditionFunctions;

public abstract class SolutionAbstract {
	
	private RezFile rezFile;
	private File file;
	
	public void open(File file) {
		this.file = file;
		String stringResultFile = AdditionFunctions
				.readFile(file);
		// построчные данные
		ArrayList<String> rezFileByLine = new ArrayList<String>(Arrays.asList(stringResultFile.split(System.lineSeparator())));
		// дальше пошел парсинг файла
		System.out.println(this.getClass() + ".open() parse begin...");
		this.rezFile = parseString(rezFileByLine);
		System.out.println(this.getClass() + ".open() parse was ended");
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

	protected abstract RezFile parseString(ArrayList<String> rezFileByLine);
}
