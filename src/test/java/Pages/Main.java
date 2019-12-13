package Pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    private WebElement webElement;

    private By authorizeButton = By.className("_1FEpprw_Km");
    private By loginText = By.className("pFhTbV17qj");
    private By cityButton = By.className("_2LxmV3b641");
    private By citeCatalog = By.className("_3RM4_n5whA");
    private By cityUpRight = By.cssSelector("span[data-auto='region-form-opener']._2XJ6yiRp5w");

    @Step("Нажатие на кнопку авторизации")
    public void AuthoriseClick(ChromeDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(authorizeButton));
        webElement = driver.findElement(authorizeButton);
        webElement.click();
    }

    @Step("Проверка удачной авторизации по тексту кнопки Мой профиль")
    public void CheckAuthorization(ChromeDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(loginText));
        String text = driver.findElement(loginText).getText();
        Assert.assertEquals(text, "Мой профиль");
    }

    @Step("Нажатие на кнопку смены города")
    public void ChangeCityClick(ChromeDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cityButton));
        webElement = driver.findElement(cityButton);
        webElement.click();
    }

    @Step("Нажатие на кнопку выбора каталога")
    public void  CatalogClick(ChromeDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(citeCatalog));
        webElement = driver.findElement(citeCatalog);
        webElement.click();
    }

    @Step("Проверка того, что город в вверхнем правом углу {city}")
    public void CityCheck(ChromeDriver driver, String city){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cityUpRight));
        webElement = driver.findElement(cityUpRight);
        Assert.assertEquals(webElement.getText(), city);
    }

    @Step("Наведение мыши на кнопку аккаунта")
    public void AccountClick(ChromeDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(authorizeButton));
        webElement = driver.findElement(authorizeButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
    }




}
