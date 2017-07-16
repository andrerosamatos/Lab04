package models;

public class CenarioComBonus extends Cenario {

	private int bonus;

	public CenarioComBonus(String descricao, int bonus) {
		super(descricao);
		if (bonus <= 0.00) {
			throw new IllegalArgumentException("Bonus nao pode ser igual ou menor a 0.00");
		}
		this.descricao = descricao;
		this.bonus = bonus;

	}

}
