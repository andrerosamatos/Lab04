package main;

public class Facade {
	
	private ControllerSistema controllerSistema = new ControllerSistema();
	
	
	
	public void inicializa(int caixa, double taxaBasica){
		controllerSistema.inicializa(caixa, taxaBasica);
	}	
	
	public int recuperaValor(){
		return controllerSistema.getCaixa();
	}
	
	public int cadastrarCenario(String descricao){
		return controllerSistema.cadastraCenario(descricao);
		
	}
	
	public String exibirCenario(int posicao){
		return controllerSistema.exibeCenario(posicao);
	}
	
	public void exibirCenarios(){
		controllerSistema.exibeCenarios();
	}
	
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao){
		controllerSistema.cadastraAposta(cenario, apostador, valor, previsao);
	}
	
	
//	public int valorTotalDeApostas(int cenario){
//		controllerSistema.valorTotalDeApostas(cenario);
//	}
//	
//	public int totalDeApostas(int cenario){
//		controllerSistema.totalDeApostas(cenario);
//	}
//	
//	public String exibeAposta(int cenario){
//		controllerSistema.exibeApostas(cenario);
//	}
	
	
	
}
