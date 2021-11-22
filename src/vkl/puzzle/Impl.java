package vkl.puzzle;

import java.util.Scanner;

public class Impl {

	public  int[][] tabuleiro;
	public  int movimento = 0;
	// coordenadas do espa�o em branco
	public  int  xBranco = 0;
	public  int yBranco = 0;

	public void inicializaVariaveis() {
		int k = 0;
		tabuleiro = new int[3][3];
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				k++;
				tabuleiro[i][j] = k;
			}
		}

		// initial position white
		xBranco = 2;
		yBranco = 2;
		movimento = 0;
	}

	public void imprimiTabuleiro() {
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				if (tabuleiro[i][j] != 9)
					System.out.printf("%d\t", tabuleiro[i][j]);
				else
					System.out.printf(" \t");
			}
			System.out.printf("\n");
		}
	}

	public void imprimeTabuleiroBonito() {
		int[] state = new int[9];
		String result = "";
		String[] imprimiIsto = { "", "", "", "", "", "", "", "", "" };

		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				state[3 * i + j] = tabuleiro[i][j];
			}
		}

		for (int i = 0; i < state.length; i++) {
			String insertString = "|";
			if (state[i] == 9)
				insertString += "  ";
			else
				insertString += state[i] + " ";

			imprimiIsto[i] = insertString;
		}

		result += " ________\n" + "|  |  |  |\n" + imprimiIsto[0] + imprimiIsto[1] + imprimiIsto[2] + "|\n"
				+ "|__|__|__|\n" + "|  |  |  |\n" + imprimiIsto[3] + imprimiIsto[4] + imprimiIsto[5] + "|\n"
				+ "|__|__|__|\n" + "|  |  |  |\n" + imprimiIsto[6] + imprimiIsto[7] + imprimiIsto[8] + "|\n"
				+ "|__|__|__|";

		System.out.println(result);

	}

	public int verificaSeGanhou() {
		int k = 0;
		int solucao = 1;
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				k = k + 1;
				if (tabuleiro[i][j] != k)// n�o venceu,sol=0;
				{
					solucao = 0;
					break;
				}
			}
		}
		return solucao;
	}

	public int solicitaMovimento() {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		do {
			System.out.println("\nmovimentos realizados: " + movimento);
			System.out.println("Digite o movimento: ");
			n = sc.nextInt();
		} while ((n < 1) || (n > 8));
		return n;
	}

	public int atualizaTabuleiro(int jogadaRealizada) {
		int a = 0, b = 0;
		//se o cara fizer um lance inv�lido, jogadaValida = 0;
		int jogadaValida = 1;
		//localiza o valor que ser� movido e,
		//guarda a posi��o dele em a e b
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				//procura onde est� o n�mero a ser movido
				if(tabuleiro[i][j] == jogadaRealizada)
					a = i;
					b = j;
			}
		}
		//varifica se a jogada � v�lida e se for, execulta a jogada
		if((Math.abs(xBranco-a) + Math.abs(yBranco-b)) < 1) {
			//jogada inv�lida.
			jogadaValida = 0;
			return jogadaValida;
		}
		else {
			//jogada v�lida
			int temp = tabuleiro[xBranco][yBranco];
			tabuleiro[xBranco][yBranco] = tabuleiro[a][b];
			tabuleiro[a][b] = temp;
			//salva a nova posi��o do branco
			xBranco = a;
			yBranco = b;
			movimento = movimento + 1;
		}
		return jogadaValida;
	}
	
	public void embaralhaTabileiro() {
		// x e y: incrementos para realizar movimentos do branco
		//pelo tabuleiro. assumen valores 0,1 e -1
		int temp=0,x=0,y=0;
		//t1 e t4: verifica��es se os valores associados a x e y
		//produzem movimentos v�lidos no tabuleiro
		int t1 =0,t2=0,t3=0,t4=0;
		for (int i = 1; i <= 30; i++) {
			//chances iguais para x e y assumirem 0,1 e -1
			do {
				x=((int)(Math.random()*3)) -1;
				y=((int)(Math.random()*3)) -1;
				
				t1 = (xBranco+x);
				t2 = yBranco + y;
				t3 = Math.abs(x) + Math.abs(y);
				t4 = x+y;
			}while((t1>2)||(t1<0)||(t2>2)||(t2<0)||t3>1	||t4==0);
			
			//realiza a movimenta��o do tabuleiro
			temp = tabuleiro[xBranco][yBranco];
			tabuleiro[xBranco][yBranco] = tabuleiro[xBranco+x][yBranco+y];
			tabuleiro[xBranco+x][yBranco+y] = temp;
			
			//guarda a nova posi��o do branco
			xBranco = xBranco+x;
			yBranco = yBranco+y;
		}
	}

	
}
