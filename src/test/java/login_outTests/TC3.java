package login_outTests;

import helpMethods.ElementHelper;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.MainPage;
import sharedData.SharedData;

public class TC3 extends SharedData {
    @Test
    public void testMethod(){
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

       indexPage.verifyCurrentUrlTC3(driver,"https://www.saucedemo.com/" );

    }

}
