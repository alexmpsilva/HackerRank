package br.com.alex.hackerRank;

public class HR004_FormingAMagicSquare {

	static int formingMagicSquare(int[][] s) {
		
		int[][] contNum = { {1, 0}, {2, 0}, {3, 0}, {4, 0}, {5, 0}, {6, 0}, {7, 0}, {8, 0}, {9, 0} };
		
		//imprime a matriz inicial
		for (int x = 0; x < s.length; x++ ) {
			for (int y = 0; y < s[0].length; y++) {
				System.out.print(s[x][y]+" ");		
			}
			System.out.println("");
		}
		
		//verifica a quantidade de vezes que cada numero é apresentado na matriz
		for (int x = 0; x < s.length; x++ ) {
			for (int y = 0; y < s[0].length; y++) {
				for (int i = 0; i < contNum.length; i++) {
					int msNum = s[x][y];
					int alNum = contNum[i][0];
					if (msNum == alNum) {
						contNum[i][1]++;
					}
				}
			}
		}
		
		//imprime a quantidade de vezes que cada numero é apresentado na matriz
		System.out.println("");
		for (int i = 0; i < contNum.length; i++) {
			System.out.print(contNum[i][0]+" ");
			System.out.println(contNum[i][1]);
		}

		//Verifica quantos número ficaram faltando apresentar na matriz
		int falCount = 0;
		for (int i = 0; i < contNum.length; i++) {		
			if (contNum[i][1] == 0) {
				falCount++;
			}
		}
		
		//Prepara uma lista de qual número substituirá qual número
		int[][] subNum = new int[falCount][2]; //subNum{numeroRepetido, numeroFaltando}
		int falPos = 0;
		int repPos = 0;
		
		for (int i = 0; i < contNum.length; i++ ) {
			
			int value = contNum[i][0];
			int quant = contNum[i][1];
			
			if (quant > 1) {
				while (contNum[i][1] > 1) {
					subNum[repPos][0] = value;
					contNum[i][1]--;
					repPos++;
				}
			}
			
			if (quant==0) {
				subNum[falPos][1] = value;
				falPos++;
			}
			
		}
		
		//imprime qual numero será substituido por qual número
		System.out.println("");
		for (int i = 0; i < subNum.length; i++) {
			System.out.print(subNum[i][0]+" ");
			System.out.println(subNum[i][1]);
		}
		
		//Calcula o custo de substituicao
		int cost = 0;
		for (int i = 0; i < subNum.length; i++) {

			cost = cost + (Math.abs(subNum[i][0]-subNum[i][1]));
			
		}
		
		//Prepara a nova matriz substituindo os numeros adequadamente
		for (int x = 0; x < s.length; x++ ) {
			for (int y = 0; y < s[0].length; y++) {
				for (int i = 0; i < subNum.length; i++) {

					if (s[x][y]==subNum[i][0]) {

						s[x][y]=subNum[i][1];
						subNum[i][0]=0;
						
					}
				}
			}
		}
		
		//imprime a nova matriz
		System.out.println("");
		for (int x = 0; x < s.length; x++ ) {
			for (int y = 0; y < s[0].length; y++) {
				System.out.print(s[x][y]+" ");		
			}
			System.out.println("");
		}	
		
		return cost;
		
    }
	
	public static void main(String[] args) {

		//int[][] s = { {5, 3, 4}, {1, 5, 8}, {6, 4, 2} };
		int[][] s = { {4, 9, 2}, {3, 5, 7}, {8, 1, 5} };
		//int[][] s = { {4, 8, 2}, {4, 5, 7}, {6, 1, 6} };
		//int[][] s = { {4, 5, 8}, {2, 4, 1}, {1, 9, 7} };
		int cost = formingMagicSquare(s);
		int mLin = 3;
		int mCol = 3;
		
		for (int x = 0; x < mLin; x++ ) {
			
			for (int y = 0; y < mCol; y++) {
				
//				System.out.println(s[x][y]);
				
			}
			
		}
		
		System.out.println("");
		System.out.print(cost);

	}

}
