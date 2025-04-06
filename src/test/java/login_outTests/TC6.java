package login_outTests;

import helpMethods.ElementHelper;
import helpMethods.TabWindowHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.MainPage;
import sharedData.SharedData;

import static java.awt.SystemColor.window;

public class TC6 extends SharedData {
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

        mainPage.clickOnBurgerMenu();
        mainPage.clickOnLogout();
        mainPage.navigateToPreviousPage();

        indexPage.verifyMainPageAccessWithoutLoginError(driver, "Epic sadface: You can only access '/inventory.html' when you are logged in.");


    }

}
