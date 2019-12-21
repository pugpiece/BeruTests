package ru.beru.Pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.beru.WebSettings;

public class Main extends WebSettings {

    public Main(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private By authorizeButton = By.className("_3odNv2Dw2n");
    private By loginText = By.className("pFhTbV17qj");
    private By citeCatalog = By.className("_3RM4_n5whA");
    private By cityUpRight = By.cssSelector("span[data-auto='region-form-opener'].zB1fta3NQ5");
    private By annoyingCommercial = By.cssSelector("div[data-apiary-widget-name='@marketplace/HeaderPromo']");

    @Step("Нажатие на кнопку авторизации")
    public void AuthoriseClick(){
        wait.until(ExpectedConditions.elementToBeClickable(authorizeButton));
        webElement = driver.findElement(authorizeButton);
        webElement.click();
    }

    @Step("Проверка удачной авторизации по тексту кнопки {myProfile}")
    public void CheckAuthorization(String myProfile)
    {
        wait.until(ExpectedConditions.elementToBeClickable(loginText));
        String text = driver.findElement(loginText).getText();
        Assert.assertEquals(text, myProfile);
    }

    @Step("Нажатие на кнопку смены города")
    public void ChangeCityClick()
    {
        wait.until(ExpectedConditions.elementToBeClickable(cityUpRight));
        webElement = driver.findElement(cityUpRight);
        webElement.click();
    }

    @Step("Нажатие на кнопку выбора каталога")
    public void  CatalogClick(){
        wait.until(ExpectedConditions.elementToBeClickable(citeCatalog));
        webElement = driver.findElement(citeCatalog);
        webElement.click();
    }

    @Step("Проверка того, что город в вверхнем правом углу {city}")
    public void CityCheck(String city){
        wait.until(ExpectedConditions.elementToBeClickable(cityUpRight));
        webElement = driver.findElement(cityUpRight);
        Assert.assertEquals(webElement.getText(), city);
    }

    @Step("Наведение мыши на кнопку аккаунта")
    public void AccountClick(){
        wait.until(ExpectedConditions.elementToBeClickable(annoyingCommercial));
        webElement = driver.findElement(authorizeButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
    }




}
