//YES 100%   :)

package br.com.alex.hackerRank;

public class HR011_TwoStrings {

	static String twoStringsV1(String s1, String s2) {
			
		String match = "NO";
		
		for (char c1 : s1.toCharArray()) {
			
			if (s2.contains(String.valueOf(c1))) {
				
				match = "YES";
				break;
				
			}
			
		}

		return match;
		
    }
	
	static String twoStrings(String s1, String s2) {
		
		String match = "NO";
		
		for(char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
			
			if ((s1.indexOf(c) > -1)&&(s2.indexOf(c) > -1)) {
				
				match = "YES";
				break;
				
			}
			
		}

		return match;
		
    }
	
	public static void main(String[] args) {
		
		String word11 = "hello";
		String word12 = "world";
		System.out.println(twoStrings(word11, word12));
		
		String word21 = "hi";
		String word22 = "world";
		System.out.println(twoStrings(word21, word22));

	}

}
