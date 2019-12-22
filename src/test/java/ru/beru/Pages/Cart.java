package ru.beru.Pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.beru.WebSettings;

public class Cart extends WebSettings {
    public Cart(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private By totalPrice = By.cssSelector("span[data-tid='c3eaad93']");
    private By freeShipping = By.cssSelector("[class=\"_3BLMSktvAP\"]");
    private By purchaseButton = By.cssSelector("[class=\"_4qhIn2-ESi Pjv3h3YbYr THqSbzx07u _39B7yXQbvm _2W4X8tX6r0\"]");
    private By addOneMore = By.cssSelector("[class=\"_4qhIn2-ESi _2sJs248D-A _18c2gUxCdP _3hWhO4rvmA\"]");

    @Step("Проверка поля До бесплатной доставки осталось")
    public void CheckFreeShipping(){
        wait.until(ExpectedConditions.elementToBeClickable(totalPrice));
        String[] totalPriceText = driver.findElement(totalPrice).getText().split(" ");
        int totalPriceInt = Integer.parseInt(totalPriceText[0] + totalPriceText[1]);
        if (totalPriceInt < 2499) {
            wait.until(ExpectedConditions.elementToBeClickable(freeShipping));
            webElement = driver.findElement(freeShipping);
        }

    }

    @Step("Перейти в оформление заказа")
    public void GoToPurchase(){
        wait.until(ExpectedConditions.elementToBeClickable(purchaseButton));
        webElement = driver.findElement(purchaseButton);
        webElement.click();
    }

    @Step("Добавление еще одной копии данного товара")
    public void AddOneMore(){
        wait.until(ExpectedConditions.elementToBeClickable(addOneMore));
        webElement = driver.findElement(addOneMore);
        webElement.click();
    }
}
