package br.com.alex.hackerRank;

public class HR006_DiagonalDifference {

	static int diagonalDifference(int[][] arr) {

		int sum1 = 0;
		for (int x = 0; x < arr.length; x++) {

			sum1 += arr[x][x];			
			
		}
		
		int y = arr[0].length;
		int sum2 = 0;
		for (int x = 0; x < arr.length; x++) {
				
				sum2 += arr[x][y-1];
				y--;
			
		}
		
		return Math.abs(sum1 - sum2);
    }
	
	public static void main(String[] args) {


		int[][] arr = {{11, 2, 4}, {4, 5, 6}, {10, 8, -12}};
		System.out.println(diagonalDifference(arr));
		

	}

}
