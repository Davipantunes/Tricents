package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfigBrowser {
    public static Actions acoes;
    public static WebDriver browser;
    public static WebDriverWait espera;

    public static void abrir( ) {

        if (browser == null) {
            System.setProperty("webdriver.chrome.driver", "src/test/driver/chromedriver.exe");
            try {
                browser = new ChromeDriver();
                browser.get("http://sampleapp.tricentis.com/101/app.php");
                browser.manage().window().maximize();
            } catch (Exception e) {
                System.out.println(" ------ Erro no metodo -----" + e.getMessage());
                System.out.println(" ------ Causa do erro -----" + e.getCause());
            }
        }
        acoes = new Actions(browser);
        espera = new WebDriverWait(browser, 10);
    }

    public static void fechar() {
        try {
            browser.close();
        } catch (Exception e) {
            System.out.println(" ------ Erro no metodo -----" + e.getMessage());
            System.out.println(" ------ Causa do erro -----" + e.getCause());
        }
    }
}
