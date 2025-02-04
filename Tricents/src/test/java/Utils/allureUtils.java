package Utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Allure;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class allureUtils {

	public static void capturarScreenshotCompleto() {
		try {
			WebDriver driver = ConfigBrowser.getBrowser();

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

