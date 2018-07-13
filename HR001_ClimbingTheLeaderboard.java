package br.com.alex.hackerRank;

public class HR001_ClimbingTheLeaderboard {
	
	static int[] climbingLeaderboard(int[] scores, int[] alice) {
	    
        int scoresCount = scores.length;
        int aliceCount = alice.length;
        int[] aliceRank = new int[aliceCount];
        
        for (int x = 0; x < aliceCount; x++) {
            
            int rank = 1;
            int priorScore = 0;
            
            for (int y = 0; y < scoresCount; y++) {
            	
            	int aliceScore = alice[x];
            	int thisScore = scores[y];
            	
            	if (thisScore < priorScore) {
                    
            		rank++;
                    
                }
            	
                if (aliceScore >= thisScore) {
                    
                    aliceRank[x] = rank;
                    break;
                    
                }else if(y+1==scoresCount) {
                	
                	rank++;
                	aliceRank[x] = rank;
                    
                }
                
                priorScore = thisScore;                
                
            }
        }
        
        return aliceRank;
        
    }

	public static void main(String[] args) {
		
		int[] score = {100, 100, 50, 40, 40, 20, 10};
		int[] alice = {5, 25, 50, 120};
		int[] rank = climbingLeaderboard(score, alice);
		
		for (int i = 0; i < rank.length; i++) {
			
			System.out.println(rank[i]);
			
		}

	}

}
