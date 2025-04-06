package checkoutTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.IndexPage;
import pages.MainPage;
import sharedData.SharedData;

public class TC13 extends SharedData {
    @Test
    public void testMethod() {
        IndexPage indexPage = new IndexPage(driver);
        MainPage mainPage = new MainPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        String usernameValue = "problem_user";
        String passwordValue = "secret_sauce";
        String firstNameValue = "John";
        String lastNameValue = "Smith";
        String zipCodeValue = "EP534";

        indexPage.clickOnUsernameBox();
        indexPage.fillUsername(usernameValue);

        indexPage.clickOnPasswordBox();
        indexPage.fillPassword(passwordValue);

        indexPage.clickOnLoginButton();

        mainPage.addToCartBackpack();
        mainPage.clickOnCart();

        cartPage.clickOnCheckout();

        checkoutPage.fillFirstName(firstNameValue);
        checkoutPage.fillLastName(lastNameValue);
        checkoutPage.fillZipCode(zipCodeValue);
        checkoutPage.clickOnContinue();

        checkoutPage.verifyCheckoutStepTwoUrl(driver, "https://www.saucedemo.com/checkout-step-two.html");

    }

}
