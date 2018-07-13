//13 de 21

package br.com.alex.hackerRank;

import java.util.ArrayList;
import java.util.List;

public class HR005_QueensAttackII_v1 {
	
	static void quickMatrix(int vet[][], int esq, int dir){
		int pivo = esq;
		int[] ch = new int[2];
		for(int i=esq+1; i<=dir; i++){        
			int j = i;                      
			if(vet[j][0] < vet[pivo][0]){     
				ch[0] = vet[j][0];
				ch[1] = vet[j][1];
				while(j > pivo){           
					vet[j][0] = vet[j-1][0];
					vet[j][1] = vet[j-1][1];
					j--;                    
				}
				vet[j][0] = ch[0];
				vet[j][1] = ch[1]; 
				pivo++;                    
			}
			if(((vet[j][0] == vet[pivo][0]))&&(vet[j][1] < vet[pivo][1])){     
				ch[0] = vet[j][0];
				ch[1] = vet[j][1];
				while(j > pivo){           
					vet[j][0] = vet[j-1][0];
					vet[j][1] = vet[j-1][1];
					j--;                    
				}
				vet[j][0] = ch[0];
				vet[j][1] = ch[1]; 
				pivo++;                    
			}
		}
		if(pivo-1 >= esq){              
	    	quickMatrix(vet,esq,pivo-1);      
	    }
	    if(pivo+1 <= dir){              
	    	quickMatrix(vet,pivo+1,dir);      
	    }
	}
	
	static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {

		int attackedSquares = 0;
		int space = 0; //espaco vazio
		int queen = 1; //peça da rainha
		int atack = 2; //area de ataque 
		int obsta = 3; //peça de obstaculo
		int boardLin;
		int boardCol;
		int pos;
		
		//Ordena matriz de obstaculos
		quickMatrix(obstacles, 0, obstacles.length-1);
		
		int[][][] myBoard = new int[n][n][3]; //Tabuleiro pos 0 = linha, pos 1 = coluna, pos 2 = peça	
		//Preenche o tabuleiro com as posições
		boardLin = n;
		for (int x = 0; x < n; x++) {			
			boardCol = 1;
					
			for (int y = 0; y < n; y++) { 				
				myBoard[x][y][0] = boardLin; //Define linha
				myBoard[x][y][1] = boardCol; //Define coluna
				boardCol++;				
			}
			boardLin--;	
		}
		
		//Preenche o tabuleiro com os obstaculos
		pos = 0;
		while (pos < k) {
			
			for (int x = 0; x < n; x++) { 			
				for (int y = 0; y < n; y++) { 
					
					boardLin = myBoard[x][y][0];
					boardCol = myBoard[x][y][1];

					int obstacleLin = obstacles[pos][0];
					int obstacleCol = obstacles[pos][1];				
								
					if ((obstacleLin==boardLin)&&(obstacleCol==boardCol)) {
						myBoard[x][y][2] = obsta;
					}
				}
			}
			pos++;
		}
		
		//Preenche o tabuleiro com a rainha e os espaços
		for (int x = 0; x < n; x++) { 			
			for (int y = 0; y < n; y++) { 
				
				boardLin = myBoard[x][y][0];
				boardCol = myBoard[x][y][1];
				
				if ((boardLin == r_q)&&(boardCol == c_q)) {
					myBoard[x][y][2] = queen;
				}else if (myBoard[x][y][2]!=obsta){
					myBoard[x][y][2] = space;
				}
				
			}			
		}
		
		//Imprime o tabuleiro com as posições
//		System.out.println("");
//		System.out.println("");
//		for (int x = 0; x < n; x++) { 			
//			for (int y = 0; y < n; y++) { 
//				System.out.print(myBoard[x][y][0]+","+myBoard[x][y][1]+" ");
//			}
//			System.out.println("");
//		}
		
		//Imprime a posição das Áreas de Ataque [O], dos obstaculos [X] e da Rainha [I] no tabuleiro
//		System.out.println("");		
//		for (int x = 0; x < n; x++) { 			
//			for (int y = 0; y < n; y++) {
//				
//				int piece = myBoard[x][y][2];
//						
//				if (piece==atack) {
//					System.out.print("[O] ");
//				}else if (piece==obsta) {
//					System.out.print("[X] ");
//				}else if (piece==queen) {
//					System.out.print("[I] ");
//				}else if (piece==space) {
//					System.out.print("[ ] ");
//				}
//				
//			}
//			System.out.println("");
//		}
		
		//Calcula a quantidade de movimentos horizontais, verticais e diagonais que a rainha poderia fazer
		for (int x = 0; x < n; x++) { 			
			for (int y = 0; y < n; y++) {
				
				int piece = myBoard[x][y][2];
				int verLin = 0;
				int verCol = 0;
						
				if (piece==queen) { //Localiza a rainha
					verLin = x;
					while (verLin-1 >= 0) {//Verifica se a linha acima existe
						verLin--;
						if (myBoard[verLin][y][2] == space) { //Verifica se a linha acima esta vazia e preenche com area de ataque
							myBoard[verLin][y][2] = atack;
						}else {
							break;
						}
					}
					verLin = x;
					while (verLin+1 <= n-1) {//Verifica se a linha abaixo existe
						verLin++;
						if (myBoard[verLin][y][2] == space) { //Verifica se a linha abaixo esta vazia e preenche com area de ataque
							myBoard[verLin][y][2] = atack;
						}else {
							break;
						}
					}
					verCol = y;
					while (verCol-1 >= 0) {//Verifica se a coluna esquerda existe
						verCol--;
						if (myBoard[x][verCol][2] == space) { //Verifica se a coluna esquerda esta vazia e preenche com area de ataque
							myBoard[x][verCol][2] = atack;
						}else {
							break;
						}
					}
					verCol = y;
					while (verCol+1 <= n-1) {//Verifica se a coluna direita existe
						verCol++;
						if (myBoard[x][verCol][2] == space) { //Verifica se a coluna esquerda esta vazia e preenche com area de ataque
							myBoard[x][verCol][2] = atack;
						}else {
							break;
						}
					}
					verLin = x;
					verCol = y;
					while ((verLin-1 >= 0)&&(verCol-1 >= 0)) {//Verifica se a diagona superior esquerda existe
						verLin--;
						verCol--;
						if (myBoard[verLin][verCol][2] == space) { //Verifica se a diagona superior esquerda esta vazia e preenche com area de ataque
							myBoard[verLin][verCol][2] = atack;
						}else {
							break;
						}
					}
					verLin = x;
					verCol = y;
					while ((verLin-1 >= 0)&&(verCol+1 <= n-1)) {//Verifica se a diagona superior direita existe
						verLin--;
						verCol++;
						if (myBoard[verLin][verCol][2] == space) { //Verifica se a diagona superior direita esta vazia e preenche com area de ataque
							myBoard[verLin][verCol][2] = atack;
						}else {
							break;
						}
					}
					verLin = x;
					verCol = y;
					while ((verLin+1 <= n-1)&&(verCol-1 >= 0)) {//Verifica se a diagona inferior esquerda existe
						verLin++;
						verCol--;
						if (myBoard[verLin][verCol][2] == space) { //Verifica se a diagona inferior esquerda esta vazia e preenche com area de ataque
							myBoard[verLin][verCol][2] = atack;
						}else {
							break;
						}
					}
					verLin = x;
					verCol = y;
					while ((verLin+1 <= n-1)&&(verCol+1 <= n-1)) {//Verifica se a diagona inferior direita existe
						verLin++;
						verCol++;
						if (myBoard[verLin][verCol][2] == space) { //Verifica se a diagona inferior direita esta vazia e preenche com area de ataque
							myBoard[verLin][verCol][2] = atack;
						}else {
							break;
						}
					}
				}
				
			}
		}
		
		//Imprime a posição das Áreas de Ataque [O], dos obstaculos [X] e da Rainha [I] no tabuleiro
//		System.out.println("");		
//		for (int x = 0; x < n; x++) { 			
//			for (int y = 0; y < n; y++) {
//				
//				int piece = myBoard[x][y][2];
//						
//				if (piece==atack) {
//					System.out.print("[O] ");
//				}else if (piece==obsta) {
//					System.out.print("[X] ");
//				}else if (piece==queen) {
//					System.out.print("[I] ");
//				}else if (piece==space) {
//					System.out.print("[ ] ");
//				}
//				
//			}
//			System.out.println("");
//		}
		
		//Contabiliza a quantidade de Áreas de Ataque [O]
		for (int x = 0; x < n; x++) { 			
			for (int y = 0; y < n; y++) {
				
				int piece = myBoard[x][y][2];
						
				if (piece==atack) {
					attackedSquares++;
				}
				
			}
		}
				
		return attackedSquares;
		
    }
	
	public static void main(String[] args) {
		
//		int n = 4; int k = 0; int r_q = 4; int c_q = 4;
//		int[][] obstacles = {{,}};
		
//		int n = 1; int k = 0; int r_q = 1; int c_q = 1;
//		int[][] obstacles = {{,}};
		
//		int n = 5; int k = 3; int r_q = 4; int c_q = 3;
//		int[][] obstacles = {{5,5}, {4,2}, {2,3}};
		
		int n = 100000; int k = 0; int r_q = 4187; int c_q = 5068;
		int[][] obstacles = {{,}};
		
//		int n = 88587; int k = 9; int r_q = 20001; int c_q = 20003;
//		int[][] obstacles = {{20001,20002},{20001,20004},{20000,20003},{20002,20003},{20000,20004},{20000,20002},{20002,20004},{20002,20002},{564,323}};
		
//		int n = 100; int k = 100; int r_q = 48; int c_q = 81;
//		int[][] obstacles = 
//		{{54,87}
//		,{64,97}
//		,{42,75}
//		,{32,65}
//		,{42,87}
//		,{32,97}
//		,{54,75}
//		,{64,65}
//		,{48,87}
//		,{48,75}
//		,{54,81}
//		,{42,81}
//		,{45,17}
//		,{14,24}
//		,{35,15}
//		,{95,64}
//		,{63,87}
//		,{25,72}
//		,{71,38}
//		,{96,97}
//		,{16,30}
//		,{60,34}
//		,{31,67}
//		,{26,82}
//		,{20,93}
//		,{81,38}
//		,{51,94}
//		,{75,41}
//		,{79,84}
//		,{79,65}
//		,{76,80}
//		,{52,87}
//		,{81,54}
//		,{89,52}
//		,{20,31}
//		,{10,41}
//		,{32,73}
//		,{83,98}
//		,{87,61}
//		,{82,52}
//		,{80,64}
//		,{82,46}
//		,{49,21}
//		,{73,86}
//		,{37,70}
//		,{43,12}
//		,{94,28}
//		,{10,93}
//		,{52,25}
//		,{50,61}
//		,{52,68}
//		,{52,23}
//		,{60,91}
//		,{79,17}
//		,{93,82}
//		,{12,18}
//		,{75,64}
//		,{69,69}
//		,{94,74}
//		,{61,61}
//		,{46,57}
//		,{67,45}
//		,{96,64}
//		,{83,89}
//		,{58,87}
//		,{76,53}
//		,{79,21}
//		,{94,70}
//		,{16,10}
//		,{50,82}
//		,{92,20}
//		,{40,51}
//		,{49,28}
//		,{51,82}
//		,{35,16}
//		,{15,86}
//		,{78,89}
//		,{41,98}
//		,{70,46}
//		,{79,79}
//		,{24,40}
//		,{91,13}
//		,{59,73}
//		,{35,32}
//		,{40,31}
//		,{14,31}
//		,{71,35}
//		,{96,18}
//		,{27,39}
//		,{28,38}
//		,{41,36}
//		,{31,63}
//		,{52,48}
//		,{81,25}
//		,{49,90}
//		,{32,65}
//		,{25,45}
//		,{63,94}
//		,{89,50}
//		,{43,41}};
		
		int queenCanAttack = queensAttack(n, k, r_q, c_q, obstacles);
		System.out.println("");
		System.out.println(queenCanAttack);

	}

}
