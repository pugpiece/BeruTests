package Pages;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToothbrushesCatalog {
    private WebElement webElement;

    private By electricToothbrushesLowPrice = By.id("textfield4665056628");
    private By electricToothbrushesHighPrice = By.id("textfield444289596");

    public void ChoseToothbrushPrice(ChromeDriver driver, int lowPrice, int highPrice){
        webElement = driver.findElement(electricToothbrushesLowPrice);
        webElement.click();
        webElement.sendKeys(String.valueOf(lowPrice));

        webElement = driver.findElement(electricToothbrushesHighPrice);
        webElement.click();
        webElement.sendKeys(String.valueOf(highPrice));
    }

}
