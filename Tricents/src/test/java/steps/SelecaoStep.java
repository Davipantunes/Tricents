package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.SelecaoPage;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Duration;

public class SelecaoStep extends SelecaoPage {

    @Dado("que eu esteja na pagina de selecao de precos {string}")
    public void que_eu_esteja_na_pagina_de_selecao_de_precos(String string) {
        assertTrue(getAbaSelecao().getText().contains(string));
    }
    @Quando("preencho todos os campos obrigatorios da selecao")
    public void preencho_todos_os_campos_obrigatorios_da_selecao() {
        acoes.moveToElement(getOptionElement()).click().perform();
    }
    @Entao("vou para a pagina de envio de cotacao")
    public void vou_para_a_pagina_de_envio_de_cotacao() {
    	getNextElement().click();
    }

}
