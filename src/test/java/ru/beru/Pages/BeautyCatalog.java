package ru.beru.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.beru.WebSettings;

public class BeautyCatalog extends WebSettings{

    public BeautyCatalog(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private By electricToothbrushes = By.cssSelector("a[href^='/catalog/elektricheskie-zubnye-shchetki']");

    @Step("Выбор раздела с электрическими зубными щетками")
    public void ElectricToothbrushesClick(){
        wait.until(ExpectedConditions.elementToBeClickable(electricToothbrushes));
        webElement = driver.findElement(electricToothbrushes);
        webElement.click();
    }
}
