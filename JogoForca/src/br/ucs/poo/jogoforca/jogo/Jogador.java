package br.ucs.poo.jogoforca.jogo;

public class Jogador {

	public String nome;
	public int pontos;
	
	public Jogador(String nome, int pontos) {
		super();
		this.nome = nome;
		this.pontos = pontos;
	}
	public String getNome() {
		return nome;
	}
	public int getPontos() {
		return pontos;
	}
	public void adicionarPontos(int pontos) {
		this.pontos += pontos;
	}
}
