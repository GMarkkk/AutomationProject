package checkoutTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.IndexPage;
import pages.MainPage;
import sharedData.SharedData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TC14 extends SharedData {
    @Test
    public void testMethod() {
        IndexPage indexPage = new IndexPage(driver);
        MainPage mainPage = new MainPage(driver);
        CartPage cartPage = new CartPage(driver);

        String usernameValue = "problem_user";
        String passwordValue = "secret_sauce";

        indexPage.clickOnUsernameBox();
        indexPage.fillUsername(usernameValue);

        indexPage.clickOnPasswordBox();
        indexPage.fillPassword(passwordValue);

        indexPage.clickOnLoginButton();

        mainPage.addToCartBackpack();
        mainPage.addToCartLight();
        mainPage.addToCartTshirt();
        mainPage.addToCartFleece();
        mainPage.addToCartOnesie();
        mainPage.addToCartAllThingsTshirt();
        mainPage.clickOnCart();

        cartPage.verifyNumberOfProducts(driver, 6);

    }

}
