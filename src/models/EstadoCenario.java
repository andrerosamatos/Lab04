package models;

public enum EstadoCenario {
		
	NAO_FINALIZADO("Nao finalizado"),
	FINALIZADO_OCORREU("Ocorreu"),
	FINALIZADO_N_OCORREU("Nao ocorreu");

	private String value;
	
	private EstadoCenario(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
	
}
