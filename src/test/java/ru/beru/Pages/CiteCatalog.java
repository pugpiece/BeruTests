package ru.beru.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.beru.WebSettings;

public class CiteCatalog extends WebSettings{

    public CiteCatalog(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private By beautySection = By.cssSelector("a[title='Красота и гигиена']");

    @Step("Выбор раздела красоты и гигиены в каталоге товаров")
    public void BeautySectionClick(){
        wait.until(ExpectedConditions.elementToBeClickable(beautySection));
        webElement = driver.findElement(beautySection);
        webElement.click();
    }



}
