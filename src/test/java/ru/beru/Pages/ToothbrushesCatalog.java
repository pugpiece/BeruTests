package ru.beru.Pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
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

    private By electricToothbrushesLowPrice = By.xpath("//div[contains(@data-auto, " +
            "'filter-range-glprice')]//span[contains(@data-auto, 'filter-range-min')]//input");
    private By electricToothbrushesHighPrice = By.xpath("//div[contains(@data-auto, " +
            "'filter-range-glprice')]//span[contains(@data-auto, 'filter-range-max')]//input");
    private By showMoreButton = By.cssSelector("button[data-auto='pager-more']");
    private By toothbrushCollectionPrices = By.cssSelector("span._1u3j_pk1db._1pTV0mQZJz > span[data-tid='c3eaad93']:not(._3nXvrJWiZ0)");
    private By listOFToothbrush = By.cssSelector("button._4qhIn2-ESi._3OWdR9kZRH.THqSbzx07u");


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
        wait.until(ExpectedConditions.elementToBeClickable(showMoreButton));
        webElement = driver.findElement(showMoreButton);
        webElement.click();
    }

    @Step("Проверка того, что заданный диапазон цен - от {lowPrice} до {highPrice}")
    public void CheckToothbrushesPrices(int lowPrice, int highPrice){
        List<WebElement> prices = webElement.findElements(toothbrushCollectionPrices);
        for (WebElement price : prices) {
            int p = Integer.parseInt(price.getText().replaceAll(" ", ""));
            Assert.assertFalse(p < lowPrice || p > highPrice);
        }
    }

    @Step("Добавление предпоследней расчески в корзину")
    public void BuyPreLastToothbrush(){
        wait.until(ExpectedConditions.elementToBeClickable(listOFToothbrush));
        List<WebElement> buttons = webElement.findElements(listOFToothbrush);
        System.out.println(buttons.size());

    }
}


