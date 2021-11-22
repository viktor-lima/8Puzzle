package vkl.application;

import vkl.puzzle.Impl;

public class Program {
	
	
	public static void main(String[] args) {
		
		Impl p = new Impl();
		
		System.out.println("Jogo 8 quadrados.\n");
		p.inicializaVariaveis();
		p.imprimeTabuleiroBonito();
		int solucao = p.verificaSeGanhou();
		if(solucao == 1)
			System.out.println("Parabéns, você venceu!");
		else
			System.out.println("\n Ainda não terminou o jogo");	
		
		int jogada = p.solicitaMovimento();
		System.out.println("Você escolheu mover o quadrado numero: " + jogada + "\n");
		p.atualizaTabuleiro(jogada);
		p.imprimeTabuleiroBonito();
		
	}	
}


