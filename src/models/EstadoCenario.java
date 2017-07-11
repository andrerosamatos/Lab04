package models;

public enum EstadoCenario {
		
	NAO_FINALIZADO("nao finalizado"),
	FINALIZADO_OCORREU("ocorreu"),
	FINALIZADO_N_OCORREU("nao ocorreu");

	private String value;
	
	private EstadoCenario(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
	
}
