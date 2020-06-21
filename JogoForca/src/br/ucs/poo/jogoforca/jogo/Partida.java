package br.ucs.poo.jogoforca.jogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Partida {
	
	int countErros = 0;
	int pontuacao = 0;
	List<String> letrasErradas = new ArrayList<>(); 
	char[] strOriginal = new char[100];
	char[] strTela = new char[100];
	
	public int iniciarPartida(String tema, String str, Jogador jogadorAtual, Scanner in) {
		String letra;
		
		strOriginal = str.toCharArray();
				
		for (int i = 0; i < strOriginal.length; i++) {
			if(strOriginal[i] != ' ') {
				strTela[i] = '_';
			} else {
				strTela[i] = ' ';
			}
			
		}
		
		do {
			this.mostrarTela(countErros, tema, jogadorAtual.nome);
			System.out.println("Digite uma letra:");
			letra = in.nextLine();
			letra = letra.toUpperCase();
			if(this.letraJaFoiDigitada(letra)) {
				System.out.println("Esta letra já foi digitada");
				continue;
			}
			this.verificarLetra(letra);
			
			if(this.perdeuPartida()) {
				this.mostrarStringCompleta();
				this.mostrarTela(countErros, tema, jogadorAtual.nome);
				System.out.println();
				System.out.println("VOCÊ PERDEU A PARTIDA");
				System.out.println();
				continue;
			}
			
			if(this.stringCompleta()) {
				this.mostrarTela(countErros, tema, jogadorAtual.nome);
				System.out.println();
				System.out.println("VOCÊ VENCEU A PARTIDA");
				System.out.println();
				continue;
			}
			
			
		} while(countErros < 6 && !this.stringCompleta());
		
		return pontuacao;
		
	}
	
	public void mostrarTela(int countErros, String tema, String nome) {
		switch (countErros) {
		case 0:
			System.out.printf(" ------                    %s                      %s \n", tema, nome);
			System.out.printf(" |    | \n");
			System.out.printf(" |    \n");
			System.out.printf(" |                                                      %s \n", this.mostrarLetrasErradas());
			System.out.printf(" |   \n");
			System.out.printf(" |\n");
			System.out.printf(" |                 ");
			mostrarString();
			System.out.printf("---\n");
			break;
			
		case 1:
			System.out.printf(" ------                    %s                      %s \n", tema, nome);
			System.out.printf(" |    | \n");
			System.out.printf(" |    O \n");
			System.out.printf(" |                                                      %s \n", this.mostrarLetrasErradas());
			System.out.printf(" |   \n");
			System.out.printf(" |\n");
			System.out.printf(" |                 ");
			mostrarString();
			System.out.printf("---\n");
			break;
			
		case 2:
			System.out.printf(" ------                    %s                      %s \n", tema, nome);
			System.out.printf(" |    | \n");
			System.out.printf(" |    O \n");
			System.out.printf(" |    0                                                  %s \n", this.mostrarLetrasErradas());
			System.out.printf(" |   \n");
			System.out.printf(" |\n");
			System.out.printf(" |                 ");
			mostrarString();
			System.out.printf("---\n");
			break;
			
		case 3:
			System.out.printf(" ------                    %s                      %s \n", tema, nome);
			System.out.printf(" |    | \n");
			System.out.printf(" |    O \n");
			System.out.printf(" |   /0                                                 %s \n", this.mostrarLetrasErradas());
			System.out.printf(" |   \n");
			System.out.printf(" |\n");
			System.out.printf(" |                 ");
			mostrarString();
			System.out.printf("---\n");
			break;
			
		case 4:
			System.out.printf(" ------                    %s                      %s \n", tema, nome);
			System.out.printf(" |    | \n");
			System.out.printf(" |    O \n");
			System.out.printf(" |   /0\\                                                 %s \n", this.mostrarLetrasErradas());
			System.out.printf(" |   \n");
			System.out.printf(" |\n");
			System.out.printf(" |                 ");
			mostrarString();
			System.out.printf("---\n");
			break;
			
		case 5:
			System.out.printf(" ------                    %s                      %s \n",  tema, nome);
			System.out.printf(" |    | \n");
			System.out.printf(" |    O \n");
			System.out.printf(" |   /0\\                                                 %s \n", this.mostrarLetrasErradas());
			System.out.printf(" |   / \n");
			System.out.printf(" |\n");
			System.out.printf(" |                 ");
			mostrarString();
			System.out.printf("---\n");
			break;
			
		case 6:
			System.out.printf(" ------                    %s                      %s \n",  tema, nome);
			System.out.printf(" |    | \n");
			System.out.printf(" |    O \n");
			System.out.printf(" |   /0\\                                                 %s \n", this.mostrarLetrasErradas());
			System.out.printf(" |   / \\\n");
			System.out.printf(" |\n");
			System.out.printf(" |                 ");
			mostrarString();
			System.out.printf("---\n");
			break;

		default:
			break;
		}
	}
	
	public boolean perdeuPartida() {
		return countErros >= 6; 
	}
	
	public void mostrarStringCompleta() {
		for (int i = 0; i < strTela.length; i++) {
			if(strTela[i] == '_') {
				strTela[i] = strOriginal[i];
			}
		}
	}
	
	public void somarPontuacao(int pontos) {
		pontuacao += pontos;
	}
	
	public String mostrarLetrasErradas() {
		String letras = " ";
		
		for (String str : letrasErradas) {
			if(letras.equals(" ")) {
				letras = str;
			} else {
				letras = letras + " - " + str;
			}
		}
		return letras;
	}
	
	public void mostrarString() {
		for (int i = 0; i < strTela.length; i++) {
			System.out.printf("%s ", strTela[i]);
		}
	}
	
	public boolean stringCompleta() {
		for (int i = 0; i < strTela.length; i++) {
			if(strTela[i] == '_') {
				return false;
			}
		}
		somarPontuacao(100);
		return true;
	}
	
	public boolean letraJaFoiDigitada(String letra) {
		char l = letra.charAt(0);
		for (String str : letrasErradas) {
			if(str.equalsIgnoreCase(letra)) {
				return true;
			}
		}
		for (int i = 0; i < strTela.length; i++) {
			if(strTela[i] == l) {
				return true;
			}
		}
		return false;
	}
	
	public void verificarLetra(String letra) {
		char l = letra.charAt(0);
		boolean acertouAlgo = false;
		
		for (int i = 0; i < strTela.length; i++) {
			if(strTela[i] == '_') {
				if(strOriginal[i] == l) {
					strTela[i] = l;
					somarPontuacao(15);
					acertouAlgo = true;
				}
			}
		}
		if (acertouAlgo == false) {
			countErros++;
			letrasErradas.add(letra);
		}
	}

	
}