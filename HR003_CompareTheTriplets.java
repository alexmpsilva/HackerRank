package br.com.alex.hackerRank;

public class HR003_CompareTheTriplets {

	// Complete the solve function below.
    static int[] solve(int[] a, int[] b) {
    	
    	int aCount = a.length;
    	int aPoint = 0;
    	int bPoint = 0;
    	int[] points = new int[2];
    	
    	for (int i = 0; i < aCount; i++) {
    		
    		int aScore = a[i];
    		int bScore = b[i];
    			
			if (aScore > bScore) {   				
				aPoint++;
			}else if((aScore < bScore)){
				bPoint++;
			}
			
    	}
    	
    	points[0] = aPoint;
    	points[1] = bPoint;
    	
    	return points;
    }
    
	public static void main(String[] args) {

		int[] a = {5, 6, 7};
		int[] b = {3, 6, 10};
		int[] points = solve(a, b);
		
		for (int i = 0; i < points.length; i++) {
			
			System.out.print(points[i]+" ");
			
		}

	}

}
