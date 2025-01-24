package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfigBrowser {

    public static Actions acoes;
    public static WebDriver browser;
    public static WebDriverWait espera;

    // Método para abrir o navegador
    public static void abrir() {
        String url = "http://sampleapp.tricentis.com/101/app.php";
        if (browser == null) {
            System.setProperty("webdriver.chrome.driver", "src/test/driver/chromedriver.exe");
            try {
                browser = new ChromeDriver();
                browser.manage().window().maximize();

                // Configuração de espera implícita
                browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                browser.get(url);
                
            } catch (Exception e) {
                System.out.println(" ------ Erro no método abrir ----- " + e.getMessage());
                e.printStackTrace();
            }
        }
        acoes = new Actions(browser);
        espera = new WebDriverWait(browser, Duration.ofSeconds(10));
    }

    // Método para fechar o navegador
    public static void fechar() {
        if (browser != null) {
            try {
                browser.quit();
                browser = null;
            } catch (Exception e) {
                System.out.println(" ------ Erro no método fechar ----- " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    // Método para obter o WebDriver
    public static WebDriver getBrowser() {
        if (browser == null) {
            throw new IllegalStateException("O navegador não foi inicializado. Chame o método abrir primeiro.");
        }
        return browser;
    }

    // Método para obter o Actions
    public static Actions getAcoes() {
        if (acoes == null) {
            throw new IllegalStateException("As ações não foram inicializadas. Certifique-se de que o navegador está aberto.");
        }
        return acoes;
    }

    // Método para obter o WebDriverWait
    public static WebDriverWait getEspera() {
        if (espera == null) {
            throw new IllegalStateException("A espera não foi inicializada. Certifique-se de que o navegador está aberto.");
        }
        return espera;
    }
}
