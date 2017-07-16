package models;

import java.util.ArrayList;

import com.sun.javafx.image.impl.ByteIndexed.Getter;

import main.ControllerSistema;

public class Cenario {
	private EstadoCenario estado = EstadoCenario.NAO_FINALIZADO;
	protected String descricao;
	
	private ArrayList<Aposta> apostas = new ArrayList<Aposta>();
	private ArrayList<ApostaAsseguradaValor> apostasAsseguradasValor = new ArrayList<ApostaAsseguradaValor>();
	
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

	public double getCaixaCenario(double taxa) {
		int somador = 0;
		if (estado == EstadoCenario.FINALIZADO_OCORREU) {
			for (Aposta aposta : apostas) {
				if (aposta.getPrevisao() == Previsao.VAI_ACONTECER) {
					somador += aposta.getValor();
				}

			}
			return somador * taxa;

		} else {
			for (Aposta aposta : apostas) {
				if (aposta.getPrevisao() == Previsao.NAO_VAI_ACONTECER) {
					somador += aposta.getValor() ;
				}

			}
			return somador * taxa;
		}

	}
	
	public int addApostaAsseguradaValor(ApostaAsseguradaValor apostaAsseguradaValor) throws Exception {
        validaCenarioNaoFinalizado();
        this.apostasAsseguradasValor.add(apostaAsseguradaValor);
        return apostasAsseguradasValor.indexOf(apostaAsseguradaValor);
    }


	@Override
	public String toString() {
		return descricao + " - " + estado;
	}

}
