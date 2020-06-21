package br.ucs.poo.jogoforca.jogo;
import br.ucs.poo.jogoforca.comparator.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Jogo {
	
	List<Jogador> jogadores = new ArrayList<Jogador>();
	List<Tema> temas = new ArrayList<>();
	Jogador jogadorAtual;
	
	public void iniciarJogo(Scanner in) {
		int indiceTemaAtual;
		
		this.inicializarFrases();
		this.inicializarPalavras();
		indiceTemaAtual = sortearTema();
		
		Partida partida = new Partida();
		jogadorAtual.adicionarPontos(partida.iniciarPartida(temas.get(indiceTemaAtual).getNome(), 
									this.sortearPalavraOuFrase(indiceTemaAtual), jogadorAtual, in));
	}

	public void novoJogador(String nome) {
		Jogador j = new Jogador(nome, 0);
		jogadores.add(j);
		jogadorAtual = j;
	}
	
	public void selecionarJogador(String nome){
		if (jogadores.isEmpty()) {
			this.novoJogador(nome);
		}
		for (Jogador j : jogadores) {
			if (j.nome.equalsIgnoreCase(nome)) { 
				jogadorAtual = j;
				return;
			}
		}
		this.novoJogador(nome);
	}
	
	public Tema adicionarTema(String tema) {
		tema = tema.toUpperCase();
		for (Tema t : temas) {
			if(t.getNome() == tema) {
				return t;
			}
		}
		Tema t = new Tema(tema);
		temas.add(t);
		return t;
	}
	
	public void inicializarPalavras() {
		Tema t = new Tema("ANIMAL");
		temas.add(t);
		t.adicionarPalavra("URSO");
		t.adicionarPalavra("JAGUATIRICA");
		t.adicionarPalavra("TUCANO");
		t.adicionarPalavra("CACHORRO");
		t.adicionarFrase("CACHORROS TEM PELOS");
		t.adicionarFrase("GATOS MIAM");
	}
	
	public void inicializarFrases() {
		Tema t = new Tema("OBJETOS");
		temas.add(t);
		t.adicionarFrase("O CARRO ANDA");
		t.adicionarFrase("O APONTADOR APONTA");
		t.adicionarFrase("O QUADRO ESTA PENDURADO");
		t.adicionarPalavra("GARRAFA");
		t.adicionarPalavra("COMPUTADOR");
		t.adicionarPalavra("VELA");
	}
	
	public int sortearTema() {
		int i = (int) (Math.random() * temas.size());
		return i;
	}
	
	public String sortearPalavraOuFrase(int indiceTema) {
		String str;
		int j = (int) (Math.random() * 100);
		if (j < 50) {
			str = this.sortearFrase(indiceTema);			
		} else {
			str = this.sortearPalavra(indiceTema);
		}
		return str;
	}
	
	public String sortearFrase(int i) {
		int j = (int) (Math.random() * temas.get(i).frases.size());
		return temas.get(i).frases.get(j);
	}
	
	public String sortearPalavra(int i) {
		int j = (int) (Math.random() * temas.get(i).palavras.size());
		return temas.get(i).palavras.get(j);
	}
	
	public void mostrarRanking() {
		
		Collections.sort(jogadores, new RankingComparator());
		for (Jogador jog : jogadores) {
			System.out.printf("%05d - %s \n", jog.getPontos(), jog.getNome());
		}
		
	}

}
