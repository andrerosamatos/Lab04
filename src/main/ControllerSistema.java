package main;

import java.util.ArrayList;

import models.Aposta;
import models.Cenario;
import models.Previsao;

public class ControllerSistema {

	ArrayList<Cenario> cenarios = new ArrayList<Cenario>();

	int caixa;
	double taxaBasica;
	int cenario;

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

		cenarios.add(cenario);

		return cenarios.indexOf(cenario);

	}

	public String exibeCenario(int posicao) {
		return (cenarios.get(posicao - 1))
				+ cenarios.get(posicao - 1).toString();
	}

	public String exibeCenarios() {
		for (int i = 0; i < cenarios.size(); i++) {
			return (i) + " - " + cenarios.get(i).toString();
		}
		return null;
	}
	
	

	public void cadastraAposta(int cenarioPos, String apostador, int valor,
			String previsao) throws Exception {
		Cenario cenario = getCenario(cenarioPos);

		Previsao acontece = convertePrevisao(previsao);

		Aposta aposta = new Aposta(apostador, valor, acontece);
		cenario.addAposta(aposta);
	}

	/**
	 * @param cenarioPos
	 * @return
	 */
	private Cenario getCenario(int cenarioPos) {
		if (cenarios.contains(cenarioPos)) {
			throw new IllegalArgumentException("Cenario não existe");

		}
		Cenario cenario = cenarios.get(cenarioPos);
		return cenario;
	}

	private Previsao convertePrevisao(String previsao) {
		return Previsao.value(previsao);
	}

	public int valorTotalDeApostas(int cenarioPos) {

		Cenario cenario = getCenario(cenarioPos);

		return cenario.valorTotalDeApostas();

	}

	public int totalDeApostas(int cenarioPos) {

		Cenario cenario = getCenario(cenarioPos);
		return cenario.totalDeApostas();

	}

	public String exibeApostas(int cenarioPos) {
		Cenario cenario = getCenario(cenarioPos);

		return cenario.exibeApostas();
	}

	public int getCaixa() {
		return caixa;
	}

	public void fecharAposta(int cenarioPos, boolean ocorreu) {
		Cenario cenario = getCenario(cenarioPos);

		cenario.fecharAposta(ocorreu);

	}

}
