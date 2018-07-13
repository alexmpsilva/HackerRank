package br.com.alex.amazonDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AD2_AmazonDemo2 {

	static public List<Integer> cellCompete(int[] states, int days)
    {
    	
		List<Integer> intList = new ArrayList<Integer>();
		
		for (int i : states)
		{
		    intList.add(i);
		}
		
		for (int x = 0; x < days; x++) {
			
			for (int i = 0; i < intList.size(); i++) {				
				
				if (intList.get(i) == 1) {
					
					intList.set(i, 0);
					
				}else {
					
					intList.set(i, 1);
				}
				
			}
			
		}
		
		return intList;
		
    }
	
	public static void main(String[] args) {

		int[] states = {1, 0, 0, 0, 0, 1, 0, 0};
		int days = 1;
		
		for (Integer i : cellCompete(states, days)) {
			
			System.out.print(i+" ");
			
		}
		
	}

}
