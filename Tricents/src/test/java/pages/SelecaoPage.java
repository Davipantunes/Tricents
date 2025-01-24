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
        List<WebElement> selectGold = browser.findElements(By.id("selectgold"));
        assertEquals(1, selectGold.size());
        return selectGold.get(0);
    }

    public WebElement getNextElement() {
        List<WebElement> next = browser.findElements(By.id("nextsendquote"));
        assertEquals(1, next.size());
        return next.get(0);
    }

}
