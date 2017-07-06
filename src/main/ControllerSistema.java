package main;

import java.util.ArrayList;

public class ControllerSistema {

	ArrayList<Cenario> cenarios = new ArrayList<Cenario>();
	ArrayList<Aposta> apostas = new ArrayList<Aposta>();

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

	public void cadastraAposta(int cenario, String apostador, int valor,
			String previsao) {
		boolean acontece;
		if (cenarios.get(cenario) == null) {
			throw new NullPointerException("Cenario não existe");
		}
		if (apostador == null) {
			throw new NullPointerException("Descricao nao pode ser null");
		}
		if (apostador.equals("")) {
			throw new IllegalArgumentException("Descricao nao pode ser vazia");
		}
		if (valor <= 0.00) {
			throw new IllegalArgumentException(
					"Aposta nao pode ser R$0.00 ou menor");
		}
		if (previsao.equalsIgnoreCase("vai acontecer")) {
			acontece = true;
		} else {
			acontece = false;
		}

		Aposta aposta = new Aposta(cenario, apostador, valor, acontece);
		apostas.add(cenario, aposta);
	
	
	}
	
//	public void valorTotalDeApostas(int cenario) {
//		for i
//	}
	

	public int getCaixa() {
		return caixa;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
