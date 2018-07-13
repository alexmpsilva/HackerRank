package br.com.alex.hackerRank;

import java.util.Arrays;

public class HR010_HashTablesRansomNote {

	static void checkMagazineV1(String[] magazine, String[] note) {
		
		int dim1 = note.length;
		int dim2 = magazine.length;
		int match = 0;
		
		for (int x = 0; x < dim1; x++) {
			
			for (int y = 0; y < dim2; y++) {
				
				if (note[x].equals(magazine[y])) {
					
					magazine[y] = "";
					match++;
					break;
					
				}
				
			}
			
		}
		
		if(dim1 == match) {
			
			System.out.println("Yes");
			
		}else{
			
			System.out.println("No");
			
		}
		
    }
	
	static void checkMagazine(String[] magazine, String[] note) {
		
		int dim = magazine.length;
		int match = 0;
		
		for (String nota : note) {
			
			for (int i = 0; i < dim; i++) {
				
				if (nota.equals(magazine[i])) {
					
					magazine[i] = "";
					match++;
					break;
					
				}
				
			}
			
		}
		
		if(match == note.length) {
			
			System.out.println("Yes");
			
		}else{
			
			System.out.println("No");
			
		}
		
    }
	
	public static void main(String[] args) {

		String[] magazine1 = {"give", "me", "one", "grand", "today", "night"};
		String[] note1 = {"give", "one", "grand", "today"};
		
		checkMagazine(magazine1, note1);
		
		String[] magazine2 = {"two", "times", "three", "is", "not", "four"};
		String[] note2 = {"two", "times", "two", "is", "four"};
		
		checkMagazine(magazine2, note2);
		
		String[] magazine3 = {"ive", "got", "a", "lovely", "bunch", "of", "coconuts"};
		String[] note3 = {"ive", "got", "some", "coconuts"};
		
		checkMagazine(magazine3, note3);
		
		String[] magazine4 = {"apgo", "clm", "w", "lxkvg", "mwz", "elo", "bg", "elo", "lxkvg", "elo", "apgo", "apgo", "w", "elo", "bg"};
		String[] note4 = {"elo", "lxkvg", "bg", "mwz", "clm", "w"};
		
		checkMagazine(magazine4, note4);

	}

}
