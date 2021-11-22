package vkl.puzzle;

import java.util.Scanner;

public class Impl {

	public static int[][] tabuleiro;
	public static int movimento = 0;
	// coordenadas do espaço em branco
	public static int  xBranco = 0;
	public static int yBranco = 0;

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
				if (tabuleiro[i][j] != k)// não venceu,sol=0;
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
		//se o cara fizer um lance inválido, jogadaValida = 0;
		int jogadaValida = 1;
		//localiza o valor que será movido e,
		//guarda a posição dele em a e b
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				//procura onde está o número a ser movido
				if(tabuleiro[i][j] == jogadaRealizada)
					a = i;
					b = j;
			}
		}
		//varifica se a jogada é válida e se for, execulta a jogada
		if((Math.abs(xBranco-a) + Math.abs(yBranco-b)) < 1) {
			//jogada inválida.
			jogadaValida = 0;
			return jogadaValida;
		}
		else {
			//jogada válida
			int temp = tabuleiro[xBranco][yBranco];
			tabuleiro[xBranco][yBranco] = tabuleiro[a][b];
			tabuleiro[a][b] = temp;
			//salva a nova posição do branco
			xBranco = a;
			yBranco = b;
			movimento = movimento + 1;
		}
		return jogadaValida;
	}

	
}
