package br.com.alex.amazonTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Teste ID 23280668144355

public class AT2_AmazonTest2 {
	
	static public List<String> reorderLines(int logFileSize, List<String> logfile) {
		
		List<String> comNumero = new ArrayList<String>();
		List<String> semNumero = new ArrayList<String>();
		List<String> log = new ArrayList<String>();
		
		for (String line : logfile) {
			
			if (!line.matches("[0-9]")) {
				
				comNumero.add(line);
				
			} else {
				
				semNumero.add(line);
				
			}
			
		}
		
		//Arrays.sort(semNumero);
		for (String line : semNumero) {
			
			log.add(line);
			
		}
		
		//comNumero.sort();
		for (String line : comNumero) {
			
			log.add(line);
			
		}
        	
		return log;
	}
	
	
	public static void main(String[] args) {

//		int logFileSize = 4;
//		List<String> logfile = new ArrayList<String>();
//		logfile.add("mi2 jog mid pet");
//		logfile.add("wz3 34 54 398");
//		logfile.add("a1 alps cow bar");
//		logfile.add("x4 45 21 7");
		
		int logFileSize = 4;
		List<String> logfile = new ArrayList<String>();
		logfile.add("mi2 jog mid pet");
		logfile.add("wz3 34 54 398");
		logfile.add("a1 alps cow bar");
		logfile.add("x4 45 21 7");
		
		for (String line : reorderLines(logFileSize, logfile)) {
			System.out.println(line);
		}
		

	}

}
