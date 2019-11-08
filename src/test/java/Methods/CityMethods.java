package Methods;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CityMethods {

    private By cityButton = By.className("_2LxmV3b641");
    private By cityChange = By.xpath("/html/body/div[7]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div[1]/div/div/input");
    private By cityConfirmButton1 = By.xpath("/html/body/div[7]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div[2]/ul/li[1]/div/div[1]");
    private By cityConfirmButton2 = By.xpath("/html/body/div[7]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div/div[2]/div[2]/button");
    private By cityResult = By.xpath("//span[contains(@data-auto,'region-form-opener')]//span[2]");
    int i;

    public void ChangeCity(ChromeDriver driver, String city)
    {
        char[] charArray = city.toCharArray();
        WebElement webElement = driver.findElement(cityButton);
        webElement.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cityChange));
        webElement = driver.findElement(cityChange);
        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) driver1 -> {

            driver1.findElement(cityChange).sendKeys(charArray[i] + "");
            i++;
            return driver1.findElement(cityConfirmButton1).getText().split("\n")[0].equals(city);
        });

        wait.until(ExpectedConditions.elementToBeClickable(cityConfirmButton1));
        webElement = driver.findElement(cityConfirmButton1);
        webElement.click();
        wait.until(ExpectedConditions.elementToBeClickable(cityConfirmButton2));
        webElement = driver.findElement(cityConfirmButton2);
        webElement.click();
    }

    public void CheckCity(ChromeDriver driver, String city) {
        String text = driver.findElement(cityResult).getText();
        if (text.equals(city))
        {
            driver.quit();
        }
    }
}
