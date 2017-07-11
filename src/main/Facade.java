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
	
	public String exibirCenarios(){
		return controllerSistema.exibeCenarios();
	}
	
	public void cadastrarAposta(int cenarioPos, String apostador, int valor, String previsao) throws Exception{
		controllerSistema.cadastraAposta(cenarioPos, apostador, valor, previsao);
	}
	
	
	public int valorTotalDeApostas(int cenarioPos){
		return controllerSistema.valorTotalDeApostas(cenarioPos);
	}

	public int totalDeApostas(int cenarioPos){
		return controllerSistema.totalDeApostas(cenarioPos);
		
	}
	
	public String exibeAposta(int cenarioPos){
		return controllerSistema.exibeApostas(cenarioPos);
	}
	
	public void fecharAposta(int cenarioPos, boolean ocorreu){
		controllerSistema.fecharAposta(cenarioPos, ocorreu);
	}
	
	
	
	
	
}
