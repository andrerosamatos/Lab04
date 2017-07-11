package models;

import java.util.ArrayList;

public class Cenario {
	private EstadoCenario estado = EstadoCenario.NAO_FINALIZADO;
	private String descricao;
	private ArrayList<Aposta> apostas = new ArrayList<Aposta>();

	public Cenario(String descricao){
		this.descricao = descricao;
	}
	
	public void addAposta(Aposta aposta) throws Exception{
		validaCenarioNaoFinalizado();
		this.apostas.add(aposta);
		
	}
	
	public int valorTotalDeApostas(){
		int somador = 0;
		for (Aposta aposta : apostas) {
			somador += aposta.getValor();
		}
		
		return somador;
	}
	
	public int totalDeApostas(){
		return apostas.size();
	}
	
	public String exibeApostas(){
		String resultado = "";
		for (Aposta aposta : apostas){
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
	
	private void validaCenarioNaoFinalizado() throws Exception{
		if (estado != EstadoCenario.NAO_FINALIZADO) {
			throw new Exception("Cenario Finalizado");
		}
	}
	
	
	@Override
	public String toString() {
		return descricao + " - " + estado;
	}




	
	
	
}
