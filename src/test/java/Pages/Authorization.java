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

public class Authorization {
    private WebElement webElement;

    private By loginInput = By.id("passp-field-login");
    private By enterButton = By.cssSelector("button.control.button2.button2_view_classic.button2_size_l.button2_theme_action.button2_width_max.button2_type_submit.passp-form-button");
    private By passwordInput = By.id("passp-field-passwd");

    @Step("Авторизация по заданному логину {login} и паролю {password}")
    public void Authorise(ChromeDriver driver, String login, String password) throws InterruptedException {
        webElement = driver.findElement(loginInput);
        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        webElement.sendKeys(login);
        webElement = driver.findElement(enterButton);
        webElement.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        webElement = driver.findElement(passwordInput);
        webElement.clear();
        webElement.sendKeys(password);
        webElement = driver.findElement(enterButton);
        webElement.click();
    }

}
