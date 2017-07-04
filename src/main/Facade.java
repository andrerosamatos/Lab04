package main;

public class Facade {
	
	private ControllerSistema cts = new ControllerSistema();
	
	
	
	public void inicializa(int caixa, double taxaBasica){
		cts.inicializa(caixa, taxaBasica);
	}	
	
	public int recuperaValor(){
		return cts.getCaixa();
	}
	
	public int cadastrarCenario(String descricao){
		return cts.cadastraCenario(descricao);
		
	}
	
	public String exibirCenario(int posicao){
		return cts.exibeCenario(posicao);
	}
	
	public void exibirCenarios(){
		cts.exibeCenarios();
	}
	
	
	
	
	
	
	
	
	


	
	
	
	
	
	
}
