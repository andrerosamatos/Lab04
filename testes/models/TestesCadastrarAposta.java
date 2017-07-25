package models;

import static org.junit.Assert.*;
import main.ControllerSistema;

import org.junit.Test;

public class TestesCadastrarAposta {

	@Test
	public void test() throws Exception {
		ControllerSistema controllerSistema = new ControllerSistema();
		controllerSistema.inicializa(10000, 0.01);
		controllerSistema.cadastraCenario("O aluno Viktor Borgino vai pagar PLP");
		controllerSistema.cadastraCenario("Hoje vai fazer -30 graus em Campina");
		controllerSistema.cadastraAposta(2, "Mandela Ursula", 100000, "VAI ACONTECER");
		controllerSistema.cadastraAposta(2, "Davson Sadman", 150000, "VAI ACONTECER");
		controllerSistema.cadastraAposta(2, "Taigo Leonel", 10000, "N VAI ACONTECER");
		controllerSistema.fecharAposta(2, true);
		//		try {
//			controllerSistema.cadastraAposta(1, "joao", 100, "   ");
//		} catch (Exception e) {
//			assertEquals("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula", e.getMessage());
//		}

			assertEquals(100, controllerSistema.getCaixaCenario(2));
	}

}
