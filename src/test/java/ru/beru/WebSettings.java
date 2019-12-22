package ru.beru;

import io.qameta.allure.Attachment;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebSettings {
    public static ChromeDriver chromeDriver;
    public static EventFiringWebDriver driver;
    private static SeleniumListener listener;
    private static String url;
    public static String login;
    public static String password;
    public static WebDriverWait wait;
    public static WebElement webElement;

    @Before
    public void beforeClass()
    {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        chromeDriver = new ChromeDriver();
        driver = new EventFiringWebDriver(chromeDriver);
        listener = new SeleniumListener();
        url = "https://beru.ru";
        login = "testlogin.ivanov";
        password = "testpassword.ivanov";
        wait = new WebDriverWait(driver, 100);
        driver.register(listener);
        driver.manage().window().fullscreen();
        driver.get(url);

    }

    @Rule
    public TestWatcher screenshotOnFailure = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            makeScreenshotOnFailure();
        }

        @Override
        protected void finished(Description description) {
            driver.close();
        }

        @Attachment("Screenshot on failure")
        public byte[] makeScreenshotOnFailure() {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }

    };
}
