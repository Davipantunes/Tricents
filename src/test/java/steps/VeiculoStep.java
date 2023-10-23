package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.VeiculoPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VeiculoStep extends VeiculoPage {

    @Dado("que eu esteja no site")
    public void que_eu_esteja_no_site( ) {
        abrir();
    }
    @Quando("preencho todos os campos obrigatorios")
    public void preencho_todos_os_campos_obrigatorios() {
        getMakeSelect().selectByIndex(2);
        getModelSelect().selectByIndex(2);
        getCylinderCapacityElement().sendKeys("1500");
        getEnginePerformanceElement().sendKeys("80");
        getDateOfManufactureElement().sendKeys("01/01/2021");
        getSeatSelect().selectByIndex(4);
        getHandDriveElement().click();
        getSeatMotorcycleSelect().selectByIndex(2);
        getFuelSelect().selectByIndex(1);
        getPayloadElement().sendKeys("500");
        getTotalWeightElement().sendKeys("10000");
        getListPriceElement().sendKeys("50000");
        getLicensePlateNumberElement().sendKeys("GST-1603");
        getAnnualMileageElement().sendKeys("50000");
        getNextElement().click();
    }
    @Entao("vou para a pagina {string}")
    public void vou_para_a_pagina(String string ) {
        assertTrue(getAba().getText().contains(string));
    }
}
