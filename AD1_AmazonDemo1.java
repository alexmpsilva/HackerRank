package br.com.alex.amazonDemo;

public class AD1_AmazonDemo1 {

	static public int generalizedGCD(int num, int[] arr)
    {
        
		int maxInt = arr[0];
        for (int i = 1; i < num; i++) {
        	
        	if (maxInt < arr[i]) {
        		
        		maxInt = arr[i];
        		
        	}
        	
        }
        
        int gcdInt = 0;
        boolean[] gcdFlag = new boolean[num];
        
        for (int x = maxInt; x > 0; x--) {	        	
        	for (int y = 0; y < num; y++) {        		

        		int val = arr[y];
        		int mod = x;
        		
        		gcdFlag[y] = (val%mod==0);
        		
        	}
        	
        	boolean gotcha = true;
        	for (int y = 0; y < num; y++) {        		

        		if (gcdFlag[y] == false) {
        			
        			gotcha = false;
        			
        		} 
        		
        	}
        	
        	if (gotcha == true){
        		
        		gcdInt = x;
        		break;
        		
        	}
        	
        }        
        
        return gcdInt;
    }
	
	public static void main(String[] args) {

		int num = 5;
		int[] arr = {2, 3, 4, 5, 6};
		
		System.out.println(generalizedGCD(num, arr));

	}

}
