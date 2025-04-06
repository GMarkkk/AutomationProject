package mainPageTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.IndexPage;
import pages.MainPage;
import sharedData.SharedData;

public class TC15 extends SharedData {
    @Test
    public void testMethod() {
        IndexPage indexPage = new IndexPage(driver);
        MainPage mainPage = new MainPage(driver);

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

        WebElement button = driver.findElement(By.id("remove-sauce-labs-backpack"));

        mainPage.verifyButtonText1(driver, button, "Remove");

        mainPage.removeBackpack();

        mainPage.verifyButtonTextUpdated(driver, button, "Add to cart");

    }
}
