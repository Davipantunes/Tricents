package steps;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.VeiculoPage;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


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
		getNextElement().click();
	}

	@After
	public void capturarScreenshotCompleto() {
		try {
			WebDriver driver = getBrowser();

			// Configuração para capturar a tela inteira com AShot
			Screenshot screenshot = new AShot()
					.shootingStrategy(ShootingStrategies.viewportPasting(100))
					.coordsProvider(new WebDriverCoordsProvider())
					.takeScreenshot(driver);

			// Converter o screenshot para um array de bytes
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			ImageIO.write(screenshot.getImage(), "PNG", outputStream);

			// Anexar ao relatório do Allure
			Allure.addAttachment("Screenshot Completo", new ByteArrayInputStream(outputStream.toByteArray()));

			// (Opcional) Salvar o screenshot em um arquivo local para depuração
			File outputfile = new File("screenshot-completo.png");
			ImageIO.write(screenshot.getImage(), "PNG", outputfile);

		} catch (IOException e) {
			System.err.println("Erro ao capturar screenshot completo: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
