package Pages;

import io.qameta.allure.Step;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CiteCatalog {
    private WebElement webElement;

    private By beautySection = By.className("_19FPGVzRi9");

    @Step("Выбор раздела красоты и гигиены в каталоге товаров")
    public void BeautySectionClick(ChromeDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(beautySection));
        webElement = driver.findElement(beautySection);
        webElement.click();
    }



}
