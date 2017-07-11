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
		if (previsao.equalsIgnoreCase("vai acontecer")) {
			return VAI_ACONTECER;
		} else {
			return NAO_VAI_ACONTECER;
		}
	}
}
