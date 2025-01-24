package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.ProdutoPage;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProdutoStep extends ProdutoPage {
    @Dado("que eu esteja na pagina do produto {string}")
    public void que_eu_esteja_na_pagina_do_produto(String string) {
        assertTrue(getAbaProduto().getText().contains(string));
    }
    @Quando("preencho todos os campos obrigatorios do produto")
    public void preencho_todos_os_campos_obrigatorios_do_produto() {
    	
    	LocalDate dataAtual = LocalDate.now().plusDays(32);
    	DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String dataFormatada = dataAtual.format(formato);
        getStartDateElement().sendKeys(dataFormatada);
        getInsuranceSumSelect().selectByIndex(7);
        getMeritRatingSelect().selectByIndex(9);
        getDamageInsuranceSelect().selectByIndex(3);
        acoes.moveToElement(getOptionalProductsElement()).click().perform();
        getCourtesyCarSelect().selectByIndex(1);
    }
    @Entao("vou para a pagina de selecao de precos")
    public void vou_para_a_pagina_de_selecao_de_precos() {
        getNextElement().click();
    }
}
