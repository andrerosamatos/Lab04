package models;

public enum Previsao {

	VAI_ACONTECER("VAI ACONTECER"),
	NAO_VAI_ACONTECER("NAO VAI ACONTECER");
	
	private String value;
	
	private Previsao(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
	
	public static Previsao value(String previsao) {
		if (previsao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		}
		if (!previsao.equalsIgnoreCase("vai acontecer") && !previsao.equalsIgnoreCase("n vai acontecer")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		}
		if (previsao.equalsIgnoreCase("vai acontecer")) {
			return VAI_ACONTECER;
		} else {
			return NAO_VAI_ACONTECER;
		}
	}
}
