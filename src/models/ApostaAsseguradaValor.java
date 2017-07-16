package models;

public class ApostaAsseguradaValor extends Aposta {

	private int valorAssegurado;
	private int custo;

	public ApostaAsseguradaValor(String apostador, int valor, Previsao acontece, int valorAssegurado, int custo) {
		super(apostador, valor, acontece);
		if (valorAssegurado <= 0.00) {
			throw new IllegalArgumentException("Valor assegurado nao pode ser 0");
		}
		if (custo <= 0.00) {
			throw new IllegalArgumentException("Custo não pode ser 0");
		}

		this.valorAssegurado = valorAssegurado;
		this.custo = custo;
	}

}
