package main;

import java.util.HashMap;

public class ControllerSistema {

	HashMap<Integer, Cenario> cenarios = new HashMap<>();

	int posicao = 0;
	int caixa;
	double taxaBasica;

	public ControllerSistema() {

	}

	public void inicializa(int caixa, double taxaBasica) {
		if (this.caixa == 0 && this.taxaBasica == 0) {

			this.caixa = caixa;
			this.taxaBasica = taxaBasica;
		}
	}

	public int cadastraCenario(String descricao) {
		if (descricao == null) {
			throw new NullPointerException("Descricao nao pode ser null");
		}
		if (descricao.equals("")) {
			throw new IllegalArgumentException("Descricao nao pode ser vazia");
		}
		Cenario cenario = new Cenario(descricao);
		

		cenarios.put(posicao, cenario);
		posicao++;

		return posicao;

	}

	public String exibeCenario(int posicao) {
		return (posicao + 1) + cenarios.get(posicao).toString();
				}

	public void exibeCenarios() {
		// TODO Auto-generated method stub

	}

	public int getCaixa() {
		return caixa;
	}

}
