package ru.beru.Pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.beru.WebSettings;

public class Purchase extends WebSettings {
    public Purchase(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private By shippingButton = By.xpath("//div[@data-auto=\"DELIVERY\"]");
    private By itemPrice = By.xpath("//div[@data-auto=\"total-items\"]/span[@data-auto=\"value\"]");
    private By shippingPrice = By.xpath("//div[@data-auto=\"total-delivery\"]//span[@data-auto=\"value\"]");
    private By totalPrice = By.className("_1oBlNqVHPq");
    private By changeOrder = By.cssSelector("div[data-zone-name='ITEMS-CHANGE']");

    @Step("Выбрать достаку курьером")
    public void ChangeShipping(){
        wait.until(ExpectedConditions.elementToBeClickable(shippingButton));
        webElement = driver.findElement(shippingButton);
        webElement.click();
        wait.until(ExpectedConditions.elementToBeClickable(changeOrder));
    }

    @Step("Проверка того, что цена общей доставки правильно посчитана")
    public void CheckCorrectPrice(){
        String[] itemPriceText = driver.findElement(itemPrice).getText().split(" ");
        String[] shippingPriceText = driver.findElement(shippingPrice).getText().split(" ");
        String[] totalPriceText = driver.findElement(totalPrice).getText().split(" ");
        int shippingPriceInt;

        if (driver.findElement(shippingPrice).getText().equals("бесплатно"))
        {
            shippingPriceInt = 0;
        }
        else
        {
            shippingPriceInt = Integer.parseInt(shippingPriceText[0]);
        }

        int itemAndShippingPrice = Integer.parseInt(itemPriceText[0] + itemPriceText[1]) + shippingPriceInt;


        int totalPriceInt = Integer.parseInt(totalPriceText[0] + totalPriceText[1]);

        System.out.println(itemAndShippingPrice);
        System.out.println(totalPriceInt );

        Assert.assertEquals(itemAndShippingPrice, totalPriceInt);


    }

    @Step("Изменить заказ")
    public void GoToCart(){
        wait.until(ExpectedConditions.elementToBeClickable(changeOrder));
        webElement = driver.findElement(changeOrder);
        webElement.click();
    }
}
