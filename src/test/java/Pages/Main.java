package Pages;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    private WebElement webElement;

    private By authorizeButton = By.className("_3ZGcN3lbEg");
    private By loginText = By.className("pFhTbV17qj");
    private By cityButton = By.className("_2LxmV3b641");
    private By cityResult = By.cssSelector("span[data-auto='region-form-opener']._2XJ6yiRp5w");
    private By citeCatalog = By.className("_3RM4_n5whA");

    public void AuthoriseClick(ChromeDriver driver) throws InterruptedException {
        webElement = driver.findElement(authorizeButton);
        webElement.click();
    }

    public void CheckAuthorization(ChromeDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(loginText));
        String text = driver.findElement(loginText).getText();
        if (text.equals("Мой профиль"))
        {
            driver.quit();
        }
    }

    public void ChangeCityClick(ChromeDriver driver)
    {
        webElement = driver.findElement(cityButton);
        webElement.click();
    }

    public void CheckCity(ChromeDriver driver, String city) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cityResult));
        String text = driver.findElement(cityResult).getText();
        if (text.equals(city))
        {
            driver.quit();
        }
    }

    public void  CatalogClick(ChromeDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        webElement = driver.findElement(citeCatalog);
        webElement.click();
    }


}
