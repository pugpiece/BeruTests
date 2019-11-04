package Tests;

import Methods.TestMethods;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class CityTest {
    private ChromeDriver driver;
    private String url;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();

        url = "https://beru.ru";
    }

    @Test
    public void Test() throws InterruptedException {
        TestMethods authorize = new TestMethods();
        authorize.OpenBeru(driver,url);
        authorize.ChangeCity(driver);
        authorize.CheckCity(driver);
    }

}
