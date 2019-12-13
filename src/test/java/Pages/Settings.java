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
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Settings {
    private WebElement webElement;

    private By cityUpRight = By.cssSelector("span[data-auto='region-form-opener']._2XJ6yiRp5w");
    private By citySettings = By.xpath("//*[@id=\"region\"]/div/div/div/span/span/span");

    @Step("Проверка того, что город в вверхнем левом углу - {city}")
    public void CheckCity(ChromeDriver driver, String city) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cityUpRight ));
        String city1 = driver.findElement(cityUpRight ).getText();
        wait.until(ExpectedConditions.elementToBeClickable(citySettings));
        String city2 = driver.findElement(citySettings).getText();
        if (city1.equals(city2))
        {
            driver.quit();
        }
        Assert.assertEquals(city1, city2);
        Assert.assertEquals(city1, city);
        Assert.assertEquals(city2, city);
    }
}
