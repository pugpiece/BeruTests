package Pages;

import io.qameta.allure.Step;
import org.junit.Assert;
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

    private By electricToothbrushesLowPrice = By.xpath("//div[contains(@data-auto, " +
            "'filter-range-glprice')]//span[contains(@data-auto, 'filter-range-min')]//input");
    private By electricToothbrushesHighPrice = By.xpath("//div[contains(@data-auto, " +
            "'filter-range-glprice')]//span[contains(@data-auto, 'filter-range-max')]//input");
    private By priceRangeLable = By.cssSelector("[class=\"_3GNV1gy3cc\"]");
    private By showMoreButton = By.xpath("/html/body/div[1]/div[5]/div/div/div/div/div[3]/div/div[6]/div/div/div/div/div/div[1]/button");
    private By neededToothbrush = By.xpath("//div[@class=\"_1uhsh_io8o\"]//div[@class=\"_3rWYRsam78\"][last()]/div[last()]//div[@class=\"_1RjY7YIluf _1zYszmgEzn\"][last()-1]//span[@class=\"_2w0qPDYwej\"]");
    private By cartButton = By.className("_1fe1bLZrkY");

    @Step("Установка диапазона цен зубных щеток от {lowPrice} до {highPrice}")
    public void ChoseToothbrushPrice(ChromeDriver driver, int lowPrice, int highPrice){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(electricToothbrushesLowPrice));
        webElement = driver.findElement(electricToothbrushesLowPrice);
        webElement.click();
        webElement.sendKeys(String.valueOf(lowPrice));

        wait.until(ExpectedConditions.elementToBeClickable(electricToothbrushesHighPrice));
        webElement = driver.findElement(electricToothbrushesHighPrice);
        webElement.click();
        webElement.sendKeys(String.valueOf(highPrice));
    }

    @Step("Проверка того, что заданный диапазон цен - от {lowPrice} до {highPrice}")
    public void CheckPriceRange(ChromeDriver driver, int lowPrice, int highPrice){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        webElement = driver.findElement(priceRangeLable);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        String priceRange = lowPrice + " — " + highPrice + " ₽";
        Assert.assertEquals(priceRange, webElement.getText());
    }

    @Step("Нажатие на кнопку показать больше")
    public void ClickShowMore(ChromeDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(showMoreButton));
        webElement = driver.findElement(showMoreButton);
        webElement.click();
    }

    @Step("Выбор предпоследней зубной щетки")
    public void purchaseLast(ChromeDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(neededToothbrush));
        webElement = driver.findElement(neededToothbrush);
        webElement.click();
        wait.until(ExpectedConditions.elementToBeClickable(neededToothbrush));
    }

    @Step("Переход в корзину")
    public void goToCart(ChromeDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        webElement = driver.findElement(cartButton);
        webElement.click();
    }

}
