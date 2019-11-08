package Methods;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorizationMethods {

    private By authorizeButton = By.className("_3ZGcN3lbEg");
    private By loginInput = By.id("passp-field-login");
    private By loginButton = By.xpath("/html/body/div/div/div/div[2]/div/div/div[3]/div[2]/div/div/div[1]/form/div[3]/button[1]");
    private By passwordInput = By.id("passp-field-passwd");
    private By passwordButton = By.xpath("/html/body/div/div/div/div[2]/div/div/div[3]/div[2]/div/div/form/div[2]/button[1]");
    private By loginText = By.className("pFhTbV17qj");

    @Test

    public void Authorise(ChromeDriver driver, String login, String password) throws InterruptedException {
        WebElement webElement = driver.findElement(authorizeButton);
        webElement.click();
        webElement = driver.findElement(loginInput);
        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        webElement.sendKeys(login);
        webElement = driver.findElement(loginButton);
        webElement.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        webElement = driver.findElement(passwordInput);
        webElement.clear();
        webElement.sendKeys(password);
        webElement = driver.findElement(passwordButton);
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


    }

