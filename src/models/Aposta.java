package models;

public class Aposta {

	private String apostador;
	private int valor;
	private Previsao acontece;

	public Aposta(String apostador, int valor, Previsao acontece) {

		if (apostador == null) {
			throw new NullPointerException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}
		if (apostador.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}
		if (valor <= 0.00) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		}
		

		this.apostador = apostador;
		this.valor = valor;
		this.acontece = acontece;

	}

	public int getValor() {
		return valor;
	}

	public Previsao getPrevisao() {
		return acontece;
	}

	@Override
	public String toString() {
		return apostador + " - R$" + valor + " - " + acontece;
	}

}
