package login_outTests;

import helpMethods.AlertHelper;
import helpMethods.ElementHelper;
import helpMethods.PageHelper;
import helpMethods.TabWindowHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.MainPage;
import sharedData.SharedData;

public class TC7 extends SharedData {
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

        mainPage.clickOnCart();
        mainPage.clickOnBurgerMenu();
        mainPage.clickOnLogout();
        mainPage.navigateToPreviousPage();

        indexPage.verifyCartAccessWithoutLoginError(driver, "Epic sadface: You can only access '/cart.html' when you are logged in.");

    }

}


