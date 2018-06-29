
//100%

public class HR1_2DArrayDS {
	
	static int hourglassSum(int[][] arr) {

		int arrLin = arr.length;
		int arrCol = arr[0].length;
		int [][] sum = new int[arrLin-2][arrCol-2];
		
		for (int x = 0; x < arrLin-2; x++) {
			
			for (int y = 0; y < arrCol-2; y++) {
				
				for (int w = y; w < y+3; w++) {
					
					sum[x][y] += arr[x][w];
					
				}
				
				sum[x][y] += arr[x+1][y+1];
				
				for (int w = y; w < y+3; w++) {
					
					sum[x][y] += arr[x+2][w];
					
				}
				
			}
			
		}
		
		//Imprime a matrix
		for (int x = 0; x < sum.length; x++) {
			
			for (int y = 0; y < sum[0].length; y++) {
				
				System.out.print(sum[x][y]+ " ");
				
			}
			
			System.out.println("");
			
		}
		
		int max = sum[0][0];
		for (int x = 0; x < sum.length; x++) {
			
			for (int y = 0; y < sum[0].length; y++) {
				
				if (max < sum[x][y]) {
					
					max = sum[x][y];
					
				}
				
			}
			
		}
		
		return max;
				
    }

	public static void main(String[] args) {
	
//		int[][] arr = {{1, 1, 1, 0, 0, 0}, {0, 1, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0}, {0, 0, 2, 4, 4, 0}, {0, 0, 0, 2, 0, 0}, {0, 0, 1, 2, 4, 0}};
		int[][] arr = {{1, 1, 1, 0, 0, 0}, {0, 1, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0}, {0, 9, 2, -4, -4, 0}, {0, 0, 0, -2, 0, 0}, {0, 0, -1, -2, -4, 0}};

		System.out.println(hourglassSum(arr));		
		
	}

}
