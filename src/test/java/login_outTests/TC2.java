package login_outTests;

import helpMethods.AssertHelper;
import helpMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IndexPage;
import sharedData.SharedData;

public class TC2 extends SharedData {
    private static final Logger log = LoggerFactory.getLogger(TC2.class);

    @Test
    public void testMethod() {
        IndexPage indexPage = new IndexPage(driver);

        String usernameValue = "problem_user";
        String passwordValue = "secret_saucer";

        indexPage.clickOnUsernameBox();
        indexPage.fillUsername(usernameValue);

        indexPage.clickOnPasswordBox();
        indexPage.fillPassword(passwordValue);

        indexPage.clickOnLoginButton();

        indexPage.verifyErrorMessageTC2(driver,"Epic sadface: Username and password do not match any user in this service");

    }
}
