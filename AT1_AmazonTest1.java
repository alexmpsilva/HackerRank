package br.com.alex.amazonTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Teste ID 23280668144355

public class AT1_AmazonTest1 {

	static List<String> retrieveMostFrequentlyUsedWords(String literatureText, List<String> wordsToExclude){
		
		List<String> wordsLiterature = new ArrayList<>(Arrays.asList(literatureText.split(" ")));
		List<String> wordsFrequently = new ArrayList<String>();
		java.util.Collections.sort(wordsLiterature);
		
		String lastWordLit = "";
		for (String wordLit : wordsLiterature) {
			
			if (wordLit.equals(lastWordLit)) {
				if(!wordsToExclude.contains(wordLit)){
					if(!wordsFrequently.contains(wordLit)) {
						wordsFrequently.add(wordLit);
					}
				
				}
				
			}
			
			lastWordLit = wordLit;
				
		}
        	
		return wordsFrequently;
	}
	
	
	public static void main(String[] args) {

//		String literatureText = "romeo romeo whereforce art thou romeo";
//		List<String> wordsToExclude = new ArrayList<String>();		
//		wordsToExclude.add("art");
//		wordsToExclude.add("thou");
		
		String literatureText = "rose is a flower rose is pond a flower rose flower in garden garden garden garden pond pond rose is a rose is a rose is a rose is a";
		List<String> wordsToExclude = new ArrayList<String>();		
		wordsToExclude.add("rose");
		wordsToExclude.add("is");
		wordsToExclude.add("a");
		
		for (String word : retrieveMostFrequentlyUsedWords(literatureText, wordsToExclude)) {
			System.out.println(word);
		}
			
		

	}

}
