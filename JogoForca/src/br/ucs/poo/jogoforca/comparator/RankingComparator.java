package br.ucs.poo.jogoforca.comparator;
import java.util.Comparator;

import br.ucs.poo.jogoforca.jogo.*;

public class RankingComparator implements Comparator<Jogador> {

	public int compare(Jogador j1, Jogador j2) {
		return j2.getPontos() - j1.getPontos();
	}
	
}
