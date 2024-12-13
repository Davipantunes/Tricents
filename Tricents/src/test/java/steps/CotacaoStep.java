package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.CotacaoPage;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CotacaoStep extends CotacaoPage {
    @Dado("que eu esteja na pagina de cotacao de precos {string}")
    public void que_eu_esteja_na_pagina_de_cotacao_de_precos(String string) {
        assertTrue(getAbaCotacao().getText().contains(string));
    }
    @Quando("preencho todos os campos obrigatorios da cotacao")
    public void preencho_todos_os_campos_obrigatorios_da_cotacao() {
        getEmailElement().sendKeys("usuario@outlook.com");
        getPhoneElement().sendKeys("999999999");
        getUsernameElement().sendKeys("username");
        getPasswordElement().sendKeys("A1b2c3");
        getConfirmPasswordElement().sendKeys("A1b2c3");
        getSendElement().click();

    }
    @Entao("envio a cotacao verificando a mensagem {string}")
    public void envio_a_cotacao_verificando_a_mensagem(String string) {
        assertEquals(string, getSuccessMessageElement().getText());
        fechar();
    }
}
