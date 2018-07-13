//Not 100%   :(

package br.com.alex.hackerRank;

public class HR007_NewYearChaos {
	
	static void minimumBribesV1(int[] q) {

		int dim = q.length;
		int aux;
		int last = 0;
		int bribeValid = 0;
		int bribeInval = 0;
		for(int x = 0; (x<dim)&&(bribeInval<=2); x++){
	        for(int y = 0; (y<dim-1)&&(bribeInval<=2); y++){	        	
	            if(q[y] > q[y + 1]){
	            	
	            	if (last != q[y]) { //Caso seja a mesma pessoa
	                	bribeInval = 0;
	                }
	            	
	            	bribeValid++;
	                bribeInval++;
	                
	            	//Imprimindo saporra
//		        	for (int i = 0; i < dim; i++) {
//	                	System.out.print(q[i]+" ");	                	
//	                }
//		        	System.out.println("");
//		        	System.out.println(q[y]+" -> "+q[y+1]);
//		        	System.out.println("Chaos: "+bribeInval);
		        	
	                last = q[y];
	            	
	                aux = q[y];
	                q[y] = q[y+1];
	                q[y+1] = aux;
	                
	            }
	        }

	    }
		
//		for (int i = 0; i < dim; i++) {
//			
//			System.out.print(q[i]+" ");
//			
//		}
		
		if (bribeInval > 2) {
			
			System.out.println("Too chaotic");
			
		} else {
			
			System.out.println(bribeValid);
			
		}

    }
	
	static void minimumBribesV2(int[] q) {

		int dim = q.length;
		int bribeValid = 0;
		int bribeInval = 0;
		
		for(int x = 0; (x<dim)&&(bribeInval<=2); x++){			
			
			int aux;
			int last = 0;			
			
	        for(int y = 0; (y<dim-1)&&(bribeInval<=2); y++){	        	
	            if(q[y] > q[y + 1]){
	            	
	            	if (last != q[y]) { //Caso seja a mesma pessoa
	                	bribeInval = 0;
	                }
	            	
	            	bribeValid++;
	                bribeInval++;
		        	
	                last = q[y];
	            	
	                aux = q[y];
	                q[y] = q[y+1];
	                q[y+1] = aux;
	                
	            }
	        }

	    }
		
		if (bribeInval > 2) {
			
			System.out.println("Too chaotic");
			
		} else {
			
			System.out.println(bribeValid);
			
		}

    }
	
	public static void main(String[] args) {

		int[] a = {2, 1, 5, 3, 4};
		minimumBribesV1(a);
		
		int[] b = {2, 1, 5, 3, 4};
		minimumBribesV2(b);

	}

}
