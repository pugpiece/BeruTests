package ru.beru.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.beru.WebSettings;

public class Authorization extends WebSettings{

    public Authorization(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private By loginInput = By.id("passp-field-login");
    private By enterButton = By.cssSelector("button.control.button2.button2_view_classic.button2_size_l.button2_theme_action.button2_width_max.button2_type_submit.passp-form-button");
    private By passwordInput = By.id("passp-field-passwd");

    @Step("Авторизация по заданному логину {login} и паролю {password}")
    public void Authorise( String login, String password) throws InterruptedException {
        webElement = driver.findElement(loginInput);
        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        webElement.sendKeys(login);
        webElement = driver.findElement(enterButton);
        webElement.click();

        wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        webElement = driver.findElement(passwordInput);
        webElement.clear();
        webElement.sendKeys(password);
        webElement = driver.findElement(enterButton);
        webElement.click();
    }

}
