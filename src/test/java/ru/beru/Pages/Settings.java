package ru.beru.Pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.beru.WebSettings;

public class Settings extends WebSettings{

    public Settings(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private By cityUpRight = By.cssSelector("span[data-auto='region-form-opener'].zB1fta3NQ5");
    private By citySettings = By.xpath("//*[@id=\"region\"]/div/div/div/span/span/span");

    @Step("Проверка того, что город в вверхнем левом углу - {city}")
    public void CheckCity(String city) {
        wait.until(ExpectedConditions.elementToBeClickable(cityUpRight ));
        String city1 = driver.findElement(cityUpRight ).getText();
        wait.until(ExpectedConditions.elementToBeClickable(citySettings));
        String city2 = driver.findElement(citySettings).getText();
        Assert.assertEquals(city1, city2);
        Assert.assertEquals(city1, city);
        Assert.assertEquals(city2, city);
    }
}
