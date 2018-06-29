
//100%

public class HR2_ArraysLeftRotation {
	  
	static int[] rotLeft(int[] a, int d) {

		int dim = a.length;
		int[] newA = new int[dim];		
		for (int x = 0; x < d; x++) {
			
			for (int y = 0; y < dim-1; y++) {
				
				newA[y] = a[y+1];
				
			}
			
			newA[dim-1] = a[0];
			
			for (int i = 0; i < dim; i++) {
				
				a[i] = newA[i];
				
			}			
			
		}

		return newA;
		
    }	
	
	public static void main(String[] args) {

		int[] a = {1, 2, 3, 4, 5};
		int d = 4;
		a = rotLeft(a, d);
		
		for (int i = 0; i < a.length; i++) {
			
			System.out.print(a[i]+" ");
			
		}
		

	}

}
