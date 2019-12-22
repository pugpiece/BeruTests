package ru.beru.Pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.beru.WebSettings;

import java.util.List;

public class ToothbrushesCatalog extends WebSettings{

    public ToothbrushesCatalog(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private By electricToothbrushesLowPrice = By.xpath("//span[@data-auto = 'filter-range-min']//input");
    private By electricToothbrushesHighPrice = By.xpath("//span[@data-auto = 'filter-range-max']//input");
    private By showMoreButton = By.cssSelector("button[data-auto='pager-more']");
    private By labelOfPriceRange = By.cssSelector( "[class=\"_3GNV1gy3cc\"]");
    private By neededToothbrush = By.xpath("(//button[contains(@class,'_4qhIn2-ESi _3OWdR9kZRH THqSbzx07u')])[24]");
    private By goToCart = By.cssSelector("[data-auto=\"executed-cart-button\"]");



    @Step("Установка диапазона цен зубных щеток от {lowPrice} до {highPrice}")
    public void ChoseToothbrushPrice(int lowPrice, int highPrice){
        wait.until(ExpectedConditions.elementToBeClickable(electricToothbrushesLowPrice));
        webElement = driver.findElement(electricToothbrushesLowPrice);
        webElement.click();
        webElement.sendKeys(String.valueOf(lowPrice));

        wait.until(ExpectedConditions.elementToBeClickable(electricToothbrushesHighPrice));
        webElement = driver.findElement(electricToothbrushesHighPrice);
        webElement.click();
        webElement.sendKeys(String.valueOf(highPrice));
    }

    @Step("Нажатие на кнопку показать больше")
    public void ClickShowMore(){
        try {
            webElement = driver.findElement(showMoreButton);
            webElement.click();
        }
        catch (NoSuchElementException e){}
    }

    @Step("Проверка того, что заданный диапазон цен - от {lowPrice} до {highPrice}")
    public void CheckToothbrushesPrices(int lowPrice, int highPrice){
        webElement = driver.findElement(labelOfPriceRange);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        String priceRange = lowPrice + " — " + highPrice + " ₽";
        Assert.assertEquals(priceRange, webElement.getText());
    }

    @Step("Добавление предпоследней расчески в корзину")
    public void BuyPreLastToothbrush(){
        driver.executeScript("window.scrollTo(0, document.body.scrollHeight / 3 * 2);");
        webElement = driver.findElement(neededToothbrush);
        webElement.click();
        wait.until(ExpectedConditions.elementToBeClickable(goToCart));
        webElement = driver.findElement(goToCart);
        webElement.click();

    }
}


