package Tests;

import Methods.AuthorizationMethods;
import Methods.CityMethods;
import Methods.ToothbrushMethods;
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

    @Test
    public void AuthorizationTest() throws InterruptedException {

        AuthorizationMethods authorize = new AuthorizationMethods();
        authorize.Authorise(driver, login, password);
        authorize.CheckAuthorization(driver);

    }

    @Test
    public void CityTest() throws InterruptedException {

        CityMethods changecity = new CityMethods();
        changecity.ChangeCity(driver, city);
        changecity.CheckCity(driver, city);
    }


    public void ToothbrushTest() throws InterruptedException {

        ToothbrushMethods checktoothbrush = new ToothbrushMethods();
        checktoothbrush.ChoseToothbrush(driver);
        checktoothbrush.ChoseToothbrushPrice(driver, lowPrice, highPrice);
        checktoothbrush.checkPriceList(driver, lowPrice, highPrice);
    }
}
