import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Tests {
	
	public static void main(String[] args) {
		
		System.out.println("Working Directory = " +
	              System.getProperty("user.dir"));
		
		List<String> command = new ArrayList<String>();
		
		command.add(System.getProperty("user.dir") + "/sharpConsole.exe");
		command.add("param1");
		command.add("param2");
		
		
		try {
			
			Process p = new ProcessBuilder(command).start();
			inheritIO(p.getInputStream(), System.out);
		    inheritIO(p.getErrorStream(), System.err);
		    
		} catch (IOException e) {
			
//			System.out.println(p.getInputStream());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private static void inheritIO(final InputStream src, final PrintStream dest) {
	    new Thread(new Runnable() {
	        public void run() {
	            Scanner sc = new Scanner(src);
	            while (sc.hasNextLine()) {
	                dest.println(sc.nextLine());
	            }
	        }
	    }).start();
	}
}



