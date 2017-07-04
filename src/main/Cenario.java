package main;

public class Cenario {

	EstadoCenario estado = EstadoCenario.NAO_FINALIZADO;
	String descricao;
	

	public Cenario(String descricao){
		
	}
	
	
	
	@Override
	public String toString() {
		return descricao + estado;
	}
	
	
	
}
