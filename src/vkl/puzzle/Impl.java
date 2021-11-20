package vkl.puzzle;

public class Impl {
	
	static int [][] tabuleiro;
	static int movimento = 0;
	//coordenadas do espa�o em branco
	static int xBranco = 0;
	static int yBranco = 0;
	
	public static void inicializaVariaveis() {
		int k = 0;
		tabuleiro = new int[3][3];
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				k++;
				tabuleiro[i][j] = k;
			}
		}
		
		//initial position white
		xBranco = 2;
		yBranco = 2;
		movimento=0;
	}
	
	public static void imprimiTabuleiro() {
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				if(tabuleiro[i][j] != 9)
					System.out.printf("%d\t",tabuleiro[i][j]);
				else
					System.out.printf(" \t");
			}
			System.out.printf("\n");
		}
	}
	
	public static void imprimeTabuleiroBonito() {
		int[] state = new int[9];
		String result = "";
		String[] imprimiIsto = {"","","","","","","","",""};
		
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				state[3*i+j] = tabuleiro[i][j];
			}
		}
		
		for (int i = 0; i < state.length; i++) {
			String insertString = "|";
			if (state[i] == 9) 
				insertString+=" ";
			else
				insertString+= state[i]+" ";
			
			imprimiIsto[i] = insertString;	
		}
		
		result+=" ________\n"+"|  |  |  |\n" +imprimiIsto[0]+imprimiIsto[1]+imprimiIsto[2]
				+"|\n"+"|__|__|__|\n"+"|  |  |  |\n"+
				imprimiIsto[3]+imprimiIsto[4]+imprimiIsto[5]+"|\n"+
				"|__|__|__|\n"+"|  |  |  |\n" +
				imprimiIsto[6]+imprimiIsto[7]+imprimiIsto[8]+" | \n"+"|__|__|__|";
		
		System.out.println(result);
				
		
	}

	public static int verificaSeGanhou() {
		int k = 0;
		int solucao = 1;
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				k = k+1;
				if(tabuleiro[i][j] !=  k)//n�o venceu,sol=0;
					solucao=0;
			}
		}
		return solucao;
	}
	
}
