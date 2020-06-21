package br.ucs.poo.jogoforca.jogo;

import java.util.ArrayList;
import java.util.List;

public class Tema {
	
	private String nome;
	List<String> frases = new ArrayList<String>();
	List<String> palavras = new ArrayList<String>();

	public Tema(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void adicionarFrase(String frase) {
		frase = frase.toUpperCase();
		frases.add(frase);
	}
	
	public void adicionarPalavra(String palavra) {
		palavra = palavra.toUpperCase();
		palavras.add(palavra);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tema other = (Tema) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
