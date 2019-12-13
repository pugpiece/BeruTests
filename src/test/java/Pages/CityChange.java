package Pages;

import io.qameta.allure.Step;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CityChange {
    private WebElement webElement;

    private By cityChange = By.cssSelector("div._1U2ErCeoqP  input[data-tid=\"37e0ab2d\"]");
    private By popUpCity = By.cssSelector("li#react-autowhatever-region--item-0 div._229JDbp_Z8");
    private By cityConfirmButton = By.cssSelector("button[data-tid='71e1c78d']._4qhIn2-ESi.Pjv3h3YbYr.THqSbzx07u");
    int i = 0;

    @Step("Смена города с заданного по умолчанию на {city}")
    public void ChangeCity(ChromeDriver driver, String city) {
        char[] charArray = city.toCharArray();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cityChange));
        webElement = driver.findElement(cityChange);
        webElement.click();
        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) driver1 -> {

            driver1.findElement(cityChange).sendKeys(charArray[i] + "");
            i++;
            return driver1.findElement(popUpCity).getText().split("\n")[0].equals(city);
        });

        wait.until(ExpectedConditions.elementToBeClickable(popUpCity));
        webElement = driver.findElement(popUpCity);
        webElement.click();
        wait.until(ExpectedConditions.elementToBeClickable(cityConfirmButton));
        webElement = driver.findElement(cityConfirmButton);
        webElement.click();
    }
}
