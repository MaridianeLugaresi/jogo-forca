package br.ucs.poo.jogoforca.main;
import java.util.Scanner;

import br.ucs.poo.jogoforca.jogo.Jogo;
import br.ucs.poo.jogoforca.jogo.Tema;

public class Main {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Jogo jogo = new Jogo();
		int opcao = 0;
		do {
			mostraMenu();
			System.out.println("Informe sua opção :");
			try {
				opcao = in.nextInt();
			} catch (Exception e) {
				System.out.println("Por favor informe uma das opções válidas!");
				opcao = 0;
			}
			
			switch(opcao) {
			case 1:
				in.nextLine();
				System.out.println("Nome do Jogador:");
				jogo.selecionarJogador(in.nextLine()) ;
				jogo.iniciarJogo(in);
				break;
			case 2:
				in.nextLine();
				System.out.println("Informe o nome do tema: ");
				Tema tema = jogo.adicionarTema(in.nextLine());
				System.out.println("Informe a palavra: ");
				tema.adicionarPalavra(in.nextLine());
				break;
			case 3:
				in.nextLine();
				System.out.println("Informe o nome do tema: ");
				tema = jogo.adicionarTema(in.nextLine());
				System.out.println("Informe a frase: ");
				tema.adicionarFrase(in.nextLine());
				break;
			case 4:
				jogo.mostrarRanking();
				break;
			default :
				break;
			}
			in.nextLine();

		} while(opcao != 5);
		
		in.close();
		System.out.println("Você saiu do jogo!");
	
	}

	public static void mostraMenu() {
		System.out.println("------------------------------------------------------------");
		System.out.println("                 JOGO DA FORCA                              ");
		System.out.println("------------------------------------------------------------");
		System.out.println("Escolha uma das opções a seguir:");
		System.out.println("------------------------------------------------------------");
		System.out.println("1) Jogar");
		System.out.println("2) Inserir palavras");
		System.out.println("3) Inserir frases");
		System.out.println("4) Ranking");
		System.out.println("5) Sair do sistema");
		System.out.println("------------------------------------------------------------");
	}
}


