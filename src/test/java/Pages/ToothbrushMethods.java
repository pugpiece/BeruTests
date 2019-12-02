package Pages;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ToothbrushMethods {

    private By citeCatalog = By.className("_3RM4_n5whA");
    private By beautySection = By.xpath("/html/body/div[7]/div/div[1]/div/div/div/div/div[1]/ul/li[11]/div/a/span");
    private By electricToothbrushes = By.xpath("/html/body/div[1]/div/div/div[3]/div/div/div/div/div[1]/div/div/div/div[17]/div[3]/div/a/span");
    private By electricToothbrushesLowPrice = By.cssSelector("input[name='Цена от");
    private By electricToothbrushesHighPrice = By.cssSelector("input[name='Цена до");
    private By loadCurtain = By.cssSelector(".preloadable__preloader.preloadable__preloader_visibility_visible.preloadable__paranja");
    private By productsDiv = By.cssSelector("div[data-bem*='{\"b-zone\":{\"name\":\"snippet-list\"}'].n-snippet-list.n-snippet-list_type_grid.n-snippet-list_size_4.b-zone.b-spy-init.i-bem.b-spy-init_js_inited");
    private By inGarbageButton = By.cssSelector("button._4qhIn2-ESi._3OWdR9kZRH.THqSbzx07u");
    private By toGarbageButton = By.cssSelector("a[data-tid=\"f54fb4c8 ad969e88\"]._3ioN70chUh._3Uc73lzxcf");


    public void ChoseToothbrush(ChromeDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement webElement = driver.findElement(citeCatalog);
        webElement.click();
        wait.until(ExpectedConditions.elementToBeClickable(beautySection));
        webElement = driver.findElement(beautySection);
        webElement.click();

        webElement = driver.findElement(electricToothbrushes);
        webElement.click();
    }

    public void ChoseToothbrushPrice(ChromeDriver driver, int lowPrice, int highPrice){

        WebElement webElement = driver.findElement(electricToothbrushesLowPrice);
        webElement.click();
        webElement.sendKeys(String.valueOf(lowPrice));

        webElement = driver.findElement(electricToothbrushesHighPrice);
        webElement.click();
        webElement.sendKeys(String.valueOf(highPrice));
    }

    public Boolean checkPriceList(ChromeDriver driver, int lowPrice, int highPrice) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(loadCurtain));
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.stalenessOf(driver.findElement(loadCurtain)));
        WebElement webElement = driver.findElement(productsDiv);
        List<WebElement> prices = webElement.findElements(By.cssSelector("span._1u3j_pk1db._1pTV0mQZJz > span[data-tid='c3eaad93']:not(._3nXvrJWiZ0)"));
        for (WebElement price : prices) {
            int p = Integer.parseInt(price.getText().replaceAll(" ", ""));
            if (p < lowPrice || p > highPrice) {
                return false;
            }
        }
        return true;
    }
}
