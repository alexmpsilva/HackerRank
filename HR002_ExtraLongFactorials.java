package br.com.alex.hackerRank;

import java.math.BigInteger;

public class HR002_ExtraLongFactorials {

	// Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
    	
    	BigInteger fatorial = new BigInteger(Integer.toString(n));
    	
    	for (int i = n; i > 1; i--) {
    		
    		
    		fatorial = fatorial.multiply(BigInteger.valueOf(i-1));
    		
    	}
    	
    	System.out.println(fatorial);
    	
    }
    
	public static void main(String[] args) {

		extraLongFactorials(25);

	}

}
