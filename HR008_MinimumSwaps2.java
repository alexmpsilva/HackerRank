//100%

package br.com.alex.hackerRank;

public class HR008_MinimumSwaps2 {

	static int minimumSwaps(int[] arr) {

		int count = 0;
		int aux = 0;
		int dim = arr.length;
		for(int x = 0; x<dim; x++){
			
//			for(int i = 0; i < dim; i++) {
//				
//				System.out.print(arr[i]+" ");
//				
//			}			
//			System.out.println("");
	        
			if (arr[x] != x+1) {
				
				aux = arr[arr[x]-1];
				arr[arr[x]-1] = arr[x];
				arr[x] = aux;
				count++;
				x--;
				
			}
			
	    }
		
		return count;
		
    }
	
	public static void main(String[] args) {
		

		int[] arr = {4, 3, 1, 2};
		System.out.println(minimumSwaps(arr));

	}

}
