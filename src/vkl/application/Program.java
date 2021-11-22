package vkl.application;

import vkl.puzzle.Impl;

public class Program {
	
	
	public static void main(String[] args) {
		
		Impl p = new Impl();
		
		System.out.println("Jogo 8 quadrados.\n");
		p.inicializaVariaveis();
		p.embaralhaTabileiro();
		while(true) {
			int solucao = p.verificaSeGanhou();
			if(solucao == 1) {
				p.imprimeTabuleiroBonito();
				System.out.println("Parabéns, você venceu!");
				System.exit(0);
			}
			else {
				int lanceValido = 0;
				while(lanceValido == 0) {
					p.imprimeTabuleiroBonito();
					int jogada = p.solicitaMovimento();
					lanceValido = p.atualizaTabuleiro(jogada);
				}
			}
			
		}
	}	
}


