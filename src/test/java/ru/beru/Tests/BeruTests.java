package ru.beru.Tests;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import ru.beru.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.tngtech.java.junit.dataprovider.DataProvider;
import ru.beru.Pages.*;


@RunWith(JUnitParamsRunner.class)
public class BeruTests extends WebSettings{
    private Main main = new Main(driver);
    private Authorization authorization = new Authorization(driver);
    private CityChange cityChange = new CityChange(driver);
    private CiteCatalog citeCatalog = new CiteCatalog(driver);
    private BeautyCatalog beautyCatalog = new BeautyCatalog(driver);
    private ToothbrushesCatalog toothbrushesCatalog = new ToothbrushesCatalog(driver);
    private AccountWindow accountWindow = new AccountWindow(driver);
    private Settings settings = new Settings(driver);
    private Cart cart = new Cart(driver);
    private Purchase purchase = new Purchase(driver);

    @Test
    @Parameters({
            "Мой профиль",
            "Не мой профиль"
    })
    public void AuthorizationTest(String myProfile) throws InterruptedException {
        main.AuthoriseClick();
        authorization.Authorise(login,password);
        main.CheckAuthorization(myProfile);
    }


    @Test
    @Parameters({
            "Хабаровск",
            "Москва",
            "Энгельс"
    })
    public void CityTest(String city) throws InterruptedException {
        main.ChangeCityClick();
        cityChange.ChangeCity(city);
        main.CityCheck(city);
        main.AuthoriseClick();
        authorization.Authorise(login,password);
        main.AccountClick();
        accountWindow.OrdersClick();
        settings.CheckCity(city);

    }

    @Test
    public void ToothbrushTest() throws InterruptedException {
        int lowPrice = 999;
        int highPrice = 1999;
        main.CatalogClick();
        citeCatalog.BeautySectionClick();
        beautyCatalog.ElectricToothbrushesClick();
        toothbrushesCatalog.ChoseToothbrushPrice(lowPrice,highPrice);
        toothbrushesCatalog.CheckToothbrushesPrices(lowPrice,highPrice);
        toothbrushesCatalog.ClickShowMore();
        toothbrushesCatalog.BuyPreLastToothbrush();
        cart.CheckFreeShipping();
        cart.GoToPurchase();
        purchase.ChangeShipping();
        purchase.CheckCorrectPrice();
        purchase.GoToCart();
        cart.AddOneMore();
        cart.CheckFreeShipping();
        cart.GoToPurchase();
        purchase.ChangeShipping();
        purchase.CheckCorrectPrice();
}

}
