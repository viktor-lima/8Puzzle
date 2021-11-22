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
			System.out.println("Parab�ns, voc� venceu!");
		else
			System.out.println("\n Ainda n�o terminou o jogo");	
		
		int jogada = p.solicitaMovimento();
		System.out.println("Voc� escolheu mover o quadrado numero: " + jogada + "\n");
		p.atualizaTabuleiro(jogada);
		p.imprimeTabuleiroBonito();
		
	}	
}


