package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.SeguroPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeguroStep extends SeguroPage {
    @Dado("que eu esteja na pagina do seguro {string}")
    public void que_eu_esteja_na_pagina_do_seguro(String string) {
       assertTrue(getAbaSeguro().getText().contains(string));
    }
    @Quando("preencho todos os campos obrigatorios do seguro")
    public void preencho_todos_os_campos_obrigatorios_do_seguro()  {
        getFirstNameElement().sendKeys("name");
        getLastNameElement().sendKeys("ultimo");
        getDateOfBirthElement().sendKeys("05/05/2001");
        acoes.moveToElement(getGenderSelect()).click().perform();
        getStreetAddressElement().sendKeys("rua");
        getCountrySelect().selectByIndex(2);
        getZipCodeElement().sendKeys("00000");
        getCityElement().sendKeys("terra");
        getOccupationSelect().selectByIndex(1);
        acoes.moveToElement(getHobbiesElement()).click().perform();
        getWebsiteElement().sendKeys("http://www.capital.sp.gov.br");
    }
    @Entao("vou para a pagina do produto")
    public void vou_para_a_pagina_do_produto() {
        getNextElement().click();
    }
}
