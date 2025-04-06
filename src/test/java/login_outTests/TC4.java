package login_outTests;

import helpMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.IndexPage;
import sharedData.SharedData;

public class TC4 extends SharedData {

    @Test
    public void testMethod() {
        IndexPage indexPage = new IndexPage(driver);

        String passwordValue = "secret_sauce";
        indexPage.clickOnPasswordBox();
        indexPage.fillPassword(passwordValue);

        indexPage.clickOnLoginButton();

        indexPage.verifyUsernameRequiredErrorTC4(driver, "Epic sadface: Username is required");

    }
}