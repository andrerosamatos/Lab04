package models;

import java.util.ArrayList;

public class Cenario {
	private EstadoCenario estado = EstadoCenario.NAO_FINALIZADO;
	private String descricao;
	private ArrayList<Aposta> apostas = new ArrayList<Aposta>();

	public Cenario(String descricao) {
		if (descricao == null) {
			throw new NullPointerException("Descricao nao pode ser null");
		}
		if (descricao.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}

		this.descricao = descricao;
	}

	public void addAposta(Aposta aposta) throws Exception {
		validaCenarioNaoFinalizado();
		this.apostas.add(aposta);

	}

	public int valorTotalDeApostas() {
		int somador = 0;
		for (Aposta aposta : apostas) {
			somador += aposta.getValor();
		}

		return somador;
	}

	public int totalDeApostas() {
		return apostas.size();
	}

	public String exibeApostas() {
		String resultado = "";
		for (Aposta aposta : apostas) {
			resultado += aposta + System.lineSeparator();
		}

		return resultado;

	}

	public void fecharAposta(boolean ocorreu) {
		if (ocorreu) {
			estado = EstadoCenario.FINALIZADO_OCORREU;
		} else {
			estado = EstadoCenario.FINALIZADO_N_OCORREU;
		}
	}

	private void validaCenarioNaoFinalizado() throws Exception {
		if (estado != EstadoCenario.NAO_FINALIZADO) {
			throw new Exception("Cenario Finalizado");
		}
	}

	public int getCaixaCenario() {
		int somador = 0;
		if (estado == EstadoCenario.FINALIZADO_OCORREU) {
			for (Aposta aposta : apostas) {
				if (aposta.getPrevisao() == Previsao.VAI_ACONTECER) {
					somador += aposta.getValor();
				}

			}
			return somador;

		} else {
			for (Aposta aposta : apostas) {
				if (aposta.getPrevisao() == Previsao.NAO_VAI_ACONTECER) {
					somador += aposta.getValor();
				}

			}
			return somador;
		}

	}

	@Override
	public String toString() {
		return descricao + " - " + estado;
	}

}
