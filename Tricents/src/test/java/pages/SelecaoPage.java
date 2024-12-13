package pages;

import Utils.ConfigBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SelecaoPage extends ConfigBrowser {

    public WebElement getAbaSelecao() {

        return browser.findElement(By.cssSelector(".idealsteps-step-active a"));
    }
    public WebElement getOptionElement() {
        List<WebElement> selectSilver = browser.findElements(By.id("selectsilver"));
        assertEquals(1, selectSilver.size());
        return selectSilver.get(0);
    }

    public WebElement getNextElement() {
        List<WebElement> next = browser.findElements(By.id("nextsendquote"));
        assertEquals(1, next.size());
        return next.get(0);
    }

}
