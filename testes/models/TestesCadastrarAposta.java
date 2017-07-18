package models;

import static org.junit.Assert.*;
import main.ControllerSistema;

import org.junit.Test;

public class TestesCadastrarAposta {

	@Test
	public void test() {
		ControllerSistema controllerSistema = new ControllerSistema();
		controllerSistema.inicializa(10000, 0.01);
		controllerSistema.cadastraCenario("vai dar certo");
		try {
			controllerSistema.cadastraAposta(1, "joao", 100, "   ");
		} catch (Exception e) {
			assertEquals("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula", e.getMessage());
		}

	}

}
