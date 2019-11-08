package Methods;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Methods {

    @Test
    public void OpenBeru(ChromeDriver driver, String url)
    {
        driver.manage().window().fullscreen();
        driver.get(url);
    }

    public void Authorise(ChromeDriver driver) throws InterruptedException {
        driver = driver;
        WebElement authorizeButton = driver.findElementByClassName("_3ZGcN3lbEg");
        authorizeButton.click();
        WebElement login = driver.findElementById("passp-field-login");
        login.clear();
        login.sendKeys("testlogin.ivanov");
        WebElement enter = driver.findElementByXPath("/html/body/div/div/div/div[2]/div/div/div[3]/div[2]/div/div/div[1]/form/div[3]/button[1]");
        enter.click();

        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("passp-field-passwd")));
        WebElement password = driver.findElementById("passp-field-passwd");
        password.clear();
        password.sendKeys("testpassword.ivanov");
        enter = driver.findElementByXPath("/html/body/div/div/div/div[2]/div/div/div[3]/div[2]/div/div/form/div[2]/button[1]");
        enter.click();
    }

    public void CheckAuthorization(ChromeDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("pFhTbV17qj")));
        String text = driver.findElementByClassName("pFhTbV17qj").getText();
        if (text.equals("Мой профиль"))
        {
            driver.quit();
        }
    }

    public void ChangeCity(ChromeDriver driver)
    {
        WebElement cityButton = driver.findElementByClassName("_2LxmV3b641");
        cityButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[7]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div[1]/div/div/input")));
        WebElement city = driver.findElementByXPath("/html/body/div[7]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div[1]/div/div/input");
        city.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        city.sendKeys("Хвалынск");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[7]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div[2]/ul/li[1]/div/div[1]")));
        WebElement confirmCity = driver.findElementByXPath("/html/body/div[7]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div[2]/ul/li[1]/div/div[1]");
        confirmCity.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[7]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div/div[2]/div[2]/button")));
        WebElement anotherConfirm = driver.findElementByXPath("/html/body/div[7]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div/div[2]/div[2]/button");
        anotherConfirm.click();
    }

    public void CheckCity(ChromeDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        String text = driver.findElementByXPath("/html/body/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div/div[3]/div[2]/div/div/div/div/span/span[2]").getText();
        if (text.equals("{Хвалынск}"))
        {
            driver.quit();
        }
    }

    public void ChoseToothbrush(ChromeDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        WebElement catalogs = driver.findElementByClassName("_3RM4_n5whA");
        catalogs.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[7]/div/div[1]/div/div/div/div/div[1]/ul/li[11]/div/a")));
        WebElement toothbrush = driver.findElementByXPath("/html/body/div[7]/div/div[1]/div/div/div/div/div[1]/ul/li[11]/div/a");
        toothbrush.click();
        
        toothbrush = driver.findElementByClassName("_3ioN70chUh _2_vuU821cq");
        toothbrush.click();

        }
    }

