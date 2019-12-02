package Tests;

import Pages.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class BeruTests {
    private ChromeDriver driver;
    private String url;
    private String login;
    private String password;
    private String city;
    private int lowPrice;
    private int highPrice;
    private Main main = new Main();
    private Authorization authorization = new Authorization();
    private CityChange cityChange = new CityChange();
    private CiteCatalog citeCatalog = new CiteCatalog();
    private BeautyCatalog beautyCatalog = new BeautyCatalog();
    private ToothbrushesCatalog toothbrushesCatalog = new ToothbrushesCatalog();

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        url = "https://beru.ru";
        login = "testlogin.ivanov";
        password = "testpassword.ivanov";
        city = "Хвалынск";
        lowPrice = 999;
        highPrice = 1999;
        driver.manage().window().fullscreen();
        driver.get(url);

    }


    public void AuthorizationTest() throws InterruptedException {
        main.AuthoriseClick(driver);
        authorization.Authorise(driver,login,password);
        main.CheckAuthorization(driver);
    }


    public void CityTest() throws InterruptedException {
        main.ChangeCityClick(driver);
        cityChange.ChangeCity(driver, city);
        main.CheckCity(driver, city);

    }

    @Test
    public void ToothbrushTest() throws InterruptedException {
        main.CatalogClick(driver);
        citeCatalog.BeautySectionClick(driver);
        beautyCatalog.ElectricToothbrushesClick(driver);
        toothbrushesCatalog.ChoseToothbrushPrice(driver,lowPrice,highPrice);
        driver.quit();
    }
}
