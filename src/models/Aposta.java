package models;

public class Aposta {
	
	private String apostador;
	private int valor;
	private Previsao acontece;
	
	public Aposta(String apostador, int valor,
			Previsao acontece){
		
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
		
		this.apostador = apostador;
		this.valor = valor;
		this.acontece = acontece;
	
	}
	
	public int getValor(){
		return valor;
	}

	@Override
	public String toString() {
		return apostador + " - R$" + valor + " - " + acontece;
	}
	
	
			
			
}
