package main;

import java.util.ArrayList;

import models.Aposta;
import models.ApostaAsseguradaValor;
import models.Cenario;
import models.CenarioComBonus;
import models.Previsao;

public class ControllerSistema {

	ArrayList<Cenario> cenarios = new ArrayList<Cenario>();
	ArrayList<CenarioComBonus> cenariosComBonus = new ArrayList<CenarioComBonus>();
	int caixa;
	double taxa;
	int cenario;

	public ControllerSistema() {

	}

	public void inicializa(int caixa, double taxa) {
		if (caixa < 0) {
			throw new IllegalArgumentException(
					"Erro na inicializacao: Caixa nao pode ser inferior a 0");
		}
		if (taxa < 0) {
			throw new IllegalArgumentException(
					"Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}
		this.caixa = caixa;
		this.taxa = taxa;
	}

	public void cadastraCenario(String descricao) {
		Cenario cenario = new Cenario(descricao);

		cenarios.add(cenario);

	}

	public String exibirCenario(int posicao) {
		if (posicao < 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		}
		if ((posicao -1) > cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
		} else {
			return posicao + " - " + cenarios.get(posicao - 1).toString();

		}
	}

	public String exibeCenarios() {
		for (int i = 0; i < cenarios.size(); i++) {
			return (i) + " - " + cenarios.get(i).toString();
		}
		return null;
	}

	public void cadastraAposta(int cenarioPos, String apostador, int valor,
			String previsao) throws Exception {
		Cenario cenario = getCenario(cenarioPos - 1);

		Previsao acontece = convertePrevisao(previsao);

		Aposta aposta = new Aposta(apostador, valor, acontece);
		cenario.addAposta(aposta);
	}

	/**
	 * @param cenarioPos
	 * @return
	 */
	private Cenario getCenario(int cenarioPos) {
		if ((cenarioPos) < 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		}
		if (cenarioPos > cenarios.size()){
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		}
		Cenario cenario = cenarios.get(cenarioPos);
		return cenario;
	}

	private Previsao convertePrevisao(String previsao) {
		
		return Previsao.value(previsao);
	}

	public int valorTotalDeApostas(int cenarioPos) {
		if (cenarioPos-1 < 0){
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		}
		if ((cenarioPos - 1) > cenarios.size()){
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		}
		Cenario cenario = getCenario(cenarioPos - 1);

		return cenario.valorTotalDeApostas();

	}

	public int totalDeApostas(int cenarioPos) {
		if (cenarioPos <= 0){
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario invalido");
		}
		if ((cenarioPos - 1) > cenarios.size()){
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario nao cadastrado");
		}
		Cenario cenario = getCenario(cenarioPos - 1);
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
		Cenario cenario = getCenario(cenarioPos - 1);

		cenario.fecharAposta(ocorreu);
	}
	
	private void addCaixa(int addCaixa) {
		caixa += addCaixa;
	}

	public int getCaixaCenario(int cenarioPos) {
		Cenario cenario = getCenario(cenarioPos - 1);
		int addCaixa = (int) cenario.getCaixaCenario(taxa); 
		addCaixa(addCaixa);
		return addCaixa;
	}

	public int getTotalRateio(int cenarioPos) {
		Cenario cenario = getCenario(cenarioPos - 1);
		return (int) (cenario.getApostaPerdedora()- cenario.getCaixaCenario(taxa));
	}
	
	public int cadastraCenarioComBonus(String descricao, int bonus) {
        CenarioComBonus cenarioComBonus = new CenarioComBonus(descricao, bonus);
        
        cenariosComBonus.add(cenarioComBonus);
        return cenariosComBonus.indexOf(cenarioComBonus) ;
    }

    public int cadastraApostaSeguraValor(int cenarioPos, String apostador, int valor, String previsao,
            int valorAssegurado, int custo) throws Exception {
        Cenario cenario = getCenario(cenarioPos - 1);

        Previsao acontece = convertePrevisao(previsao);

        ApostaAsseguradaValor apostaAsseguradaValor = new ApostaAsseguradaValor(apostador, valor, acontece, valorAssegurado, custo);
        return cenario.addApostaAsseguradaValor(apostaAsseguradaValor);        
    }


	public double getTaxa() {
		return taxa;
	}

}
