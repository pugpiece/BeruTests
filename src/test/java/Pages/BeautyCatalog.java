package Pages;

import io.qameta.allure.Step;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BeautyCatalog {
    private WebElement webElement;

    private By electricToothbrushes = By.cssSelector("a[href^='/catalog/elektricheskie-zubnye-shchetki']");

    @Step("Выбор раздела с электрическими зубными щетками")
    public void ElectricToothbrushesClick(ChromeDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(electricToothbrushes));
        webElement = driver.findElement(electricToothbrushes);
        webElement.click();
    }
}
