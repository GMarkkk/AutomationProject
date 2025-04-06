package login_outTests;

import helpMethods.ElementHelper;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IndexPage;
import sharedData.SharedData;

public class TC1 extends SharedData {
    @Test
    public void testMethod() {

        IndexPage indexPage = new IndexPage(driver);

        String usernameValue = "problem_user";
        String passwordValue = "secret_sauce";

        indexPage.clickOnUsernameBox();
        indexPage.fillUsername(usernameValue);

        indexPage.clickOnPasswordBox();
        indexPage.fillPassword(passwordValue);

        indexPage.clickOnLoginButton();

        indexPage.verifyCurrentUrlTC1(driver, "https://www.saucedemo.com/inventory.html");

    }

}

