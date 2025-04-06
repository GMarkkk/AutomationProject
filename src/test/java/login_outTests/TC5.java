package login_outTests;

import helpMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pages.IndexPage;
import sharedData.SharedData;

public class TC5 extends SharedData {

    private static final Logger log = LoggerFactory.getLogger(TC5.class);

    @Test
    public void testMethod() {
        IndexPage indexPage = new IndexPage(driver);

        String usernameValue = "problem_user";
        indexPage.clickOnUsernameBox();
        indexPage.fillUsername(usernameValue);

        indexPage.clickOnLoginButton();

        indexPage.verifyPasswordRequiredErrorTC5(driver, "Epic sadface: Password is required");

    }

}
