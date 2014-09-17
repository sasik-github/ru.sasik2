package ru.sasik.datafile;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import ru.sasik.helper.AdditionFunctions;

public class DefaultDataFile implements Serializable {
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
		System.out.println("Start parse from file");
		String text = AdditionFunctions.readFile(file);
		String [] lines = text.split("\n");
		Pattern p = Pattern.compile("-?\\d+");
//		Pattern p = Pattern.compile("[0-9]+.[0-9]*|[0-9]*.[0-9]+|[0-9]+");
		
		Matcher m;
		for (int i = 0; i < lines.length; i++) {
			String line = lines[i];
			System.out.println(line);
			if (line.startsWith("[MAIN]")) {
				i += 2;
				line = lines[i];
				while (!line.startsWith("[")) {
					m = p.matcher(line);
					m.find();
					main.add(Integer.parseInt(m.group()));
					System.out.println(Integer.parseInt((m.group())) + " = " + line);
					line = lines[++i];
				}
				i--;
			} else
			if (line.contains("[TIME]")) {
				line = lines[++i];
				p = Pattern.compile("-?[\\d\\.]+");
				while (!line.startsWith("[")) {
					m = p.matcher(line);
					m.find();
					time.add(Double.parseDouble(m.group()));
					System.out.println(Double.parseDouble(m.group()) + " = " + line);
					line = lines[++i];
				}
				i--;
			} else
			if (line.contains("[PHISICAL]")) {
				line = lines[++i];
				p = Pattern.compile("-?[\\d\\.]+");
				while (!line.startsWith("[")) {
					m = p.matcher(line);
					m.find();
					phisical.add(Double.parseDouble(m.group()));
					System.out.println(Double.parseDouble(m.group()) + " = " + line);
					line = lines[++i];
				}
				i--;
			} else 
			if (line.contains("[DOMAIN]")) {
				line = lines[++i];
				p = Pattern.compile("-?[\\d\\.]+");
				while (!line.startsWith("[")) {
					m = p.matcher(line);
					m.find();
					domain.add(Integer.parseInt(m.group()));
					System.out.println(Integer.parseInt(m.group()) + " = " + line);
					line = lines[++i];
				}
				i--;
			} else
			if (line.contains("[OUTPUT]")) {
				line = lines[++i];
				p = Pattern.compile("-?[\\d\\.]+");
				while (!line.startsWith("[")) {
					m = p.matcher(line);
					m.find();
					// here we have some problem with input file, strange values
					// so i must use try catch block for avoiding that
					try {
						output.add(Integer.parseInt(m.group()));
						System.out.println(Integer.parseInt(m.group()) + " = " + line);
					} catch (NumberFormatException e) {
						System.err.println("[OUTPUT] " + e);
					}
					line = lines[++i];
				}
				i--;
			}else
			if (line.contains("[NODES]")) {
				Point node;
				int n, unknown1;
				Double x, y, unknown2;
				line = lines[++i];
				while (!line.startsWith("[")) {
					String [] tokens = line.split("[ ]+");
					n = Integer.parseInt(tokens[1]);
					x = Double.parseDouble(tokens[2]);
					y = Double.parseDouble(tokens[3]);
					unknown1 = Integer.parseInt(tokens[4]);
					unknown2 = Double.parseDouble(tokens[5]);
					node = new Point(n, x, y, unknown1, unknown2);
					nodes.add(node);
					System.out.println("\t" + node);
					line = lines[++i];
				}
				
				
				
//				p = Pattern.compile("-?[\\d\\.]+");
//				while (!line.startsWith("[")) {
//					m = p.matcher(line);
//					m.find();
//					n = Integer.parseInt(m.group());
//					m.find();
//					x = Double.parseDouble(m.group());
//					m.find();
//					y = Double.parseDouble(m.group());
//					m.find();
//					unknown1 = Integer.parseInt(m.group());
//					m.find();
//					unknown2 = Double.parseDouble(m.group());
//					node = new Point(n, x, y, unknown1, unknown2);
//					nodes.add(node);
//					System.out.println(node.toString() + " = " + line);
//					line = lines[++i];
//				}
				i--;
			} else 
			if (line.contains("[REGION]")) {
				line = lines[++i];
				while (!line.startsWith("[")) {
					String [] tokens = line.split("[ ]+");
					region.add(Integer.parseInt(tokens[1]));
					region.add(Integer.parseInt(tokens[2]));
					region.add(Integer.parseInt(tokens[3]));
					System.out.println(region);
					line = lines[++i];
				}
				i--;
			} else
			if (line.contains("[SPECIAL]")) {
//				line = lines[++i];
//				while (!line.startsWith("[")) {
//					String [] tokens = line.split("[ ]+");
//					Special.add(Integer.parseInt(tokens[1]));
//					region.add(Integer.parseInt(tokens[2]));
//					region.add(Integer.parseInt(tokens[3]));
//					System.out.println(region);
//					line = lines[++i];
//				}
//				i--;
			} else
			if (line.contains("[WINSTRUCT]")) {
				line = lines[++i];
				while (!line.startsWith("[")) {
					String [] tokens = line.split("[ ]+");
					winstruct.add(Double.parseDouble(tokens[1]));
					line = lines[++i];
				}
				System.out.println(winstruct);
				i--;
			} else
			if (line.contains("[LINES]")) {
//				line = lines[++i];
//				while (!line.startsWith("[")) {
//					String [] tokens = line.split("[ ]+");
//					.add(Double.parseDouble(tokens[1]));
//					line = lines[++i];
//				}
//				System.out.println(winstruct);
//				i--;
			}
		}
		
	}

	@Override
	public String toString() {
		return "DefaultDataFile [main=" + main + ", time=" + time
				+ ", phisical=" + phisical + ", domain=" + domain + ", output="
				+ output + ", nodes=" + nodes + ", region=" + region
				+ ", winstruct=" + winstruct + "]";
	}
	
	
	
	
}