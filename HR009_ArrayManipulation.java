//Not 100%   :(

package br.com.alex.hackerRank;

import java.time.LocalDateTime;
import java.util.Arrays;

public class HR009_ArrayManipulation {

	static long arrayManipulationV1(int n, int[][] queries) {

		long[] match = new long[n];
		long max = 0;
		int lin = queries.length;
		
		System.out.println(LocalDateTime.now());
		for (int x = 0; x < lin; x++) {
			
			for (int y = queries[x][0]-1; y < queries[x][1]; y++) {
			
				match[y] += queries[x][2];
					
			}
			
		}
		System.out.println(LocalDateTime.now());
		
		Arrays.sort(match);
		max = match[n-1];
		
		return max;
		
    }
	
	static long arrayManipulationV2(int n, int[][] queries) {

		long[] match = new long[n];
		long max = 0;
		int lin = queries.length;

		for (int query[] : queries) {
            
            int a = query[0]-1;
            int b = query[1];
            int k = query[2];
			
			for (int y = a; y < b; y++) {
			
				match[y] += k;
					
			}
			
		}
		
		Arrays.sort(match);
		max = match[n-1];
		
		return max;
		
    }
	
	public static void main(String[] args) {

		int n = 5;
		int[][] queries = {{1, 2, 100}, {2, 5, 100}, {3, 4, 100}};
		
		System.out.println(arrayManipulationV1(n, queries));
		System.out.println(arrayManipulationV2(n, queries));

	}

}
