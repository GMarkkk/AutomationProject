package pages;

import helpMethods.AssertHelper;
import helpMethods.ElementHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static locators.IndexLocators.*;

public class IndexPage {
    private WebDriver driver;
    private ElementHelper elementHelper;
    private AssertHelper assertHelper;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        assertHelper = new AssertHelper(driver);
    }

    public void clickOnUsernameBox(){
        elementHelper.clickJSLocator(usernameElement);
        LoggerUtility.infoTest("The user clicks on the username box");
    }

    public void clickOnPasswordBox(){
        elementHelper.clickJSLocator(passwordElement);
        LoggerUtility.infoTest("The user clicks on the password box");
    }

    public void clickOnLoginButton(){
        elementHelper.clickJSLocator(loginButtonElement);
        LoggerUtility.infoTest("The user clicks on the login button");
    }

    public void fillUsername(String usernameValue){
        elementHelper.fillLocator(usernameElement, usernameValue);
        LoggerUtility.infoTest("The user fills the username box");
    }

    public void fillPassword(String passwordValue){
        elementHelper.fillLocator(passwordElement, passwordValue);
        LoggerUtility.infoTest("The user fills the password box");
    }

    public void verifyErrorMessageTC2(WebDriver driver, String expectedMessage) {
        By errorMessageElement = By.xpath("//*[text()='Epic sadface: Username and password do not match any user in this service']");
        WebElement errorElement = driver.findElement(errorMessageElement);

        String actualMessage = errorElement.getText();
        assert actualMessage.equals(expectedMessage)
                : "Expected message: '" + expectedMessage + "', but got: '" + actualMessage + "'";

        System.out.println("TC2 = PASS; Error message is: " + actualMessage);
    }

    public void verifyCurrentUrlTC1(WebDriver driver, String expectedURL) {
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Login failed!");
        System.out.println("TC1 = PASS!; The user has successfully logged in");
    }

    public void verifyCurrentUrlTC3(WebDriver driver, String expectedURL) {
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Login failed!");
        System.out.println("TC3 = PASS!; The user has successfully logged in");
    }

    public void verifyUsernameRequiredErrorTC4(WebDriver driver, String expectedMessage) {
        By errorMessageElement = By.xpath("//*[text()='Epic sadface: Username is required']");
        WebElement errorElement = driver.findElement(errorMessageElement);

        String actualMessage = errorElement.getText();
        assert actualMessage.equals(expectedMessage)
                : "Expected message: '" + expectedMessage + "', but got: '" + actualMessage + "'";

        System.out.println("TC4 = PASS; Error message is: " + actualMessage);
    }

    public void verifyPasswordRequiredErrorTC5(WebDriver driver, String expectedMessage) {
        By errorMessageElement = By.xpath("//*[text()='Epic sadface: Password is required']");
        WebElement errorElement = driver.findElement(errorMessageElement);

        String actualMessage = errorElement.getText();
        assert actualMessage.equals(expectedMessage)
                : "Expected message: '" + expectedMessage + "', but got: '" + actualMessage + "'";

        System.out.println("TC5 = PASS; Error message is: " + actualMessage);
    }

    public void verifyMainPageAccessWithoutLoginError(WebDriver driver, String expectedMessage) {
        By errorMessageElement = By.xpath("//*[text()=\"Epic sadface: You can only access '/inventory.html' when you are logged in.\"]");
        WebElement errorElement = driver.findElement(errorMessageElement);

        String actualMessage = errorElement.getText();
        assert actualMessage.equals(expectedMessage)
                : "Expected message: '" + expectedMessage + "', but got: '" + actualMessage + "'";

        System.out.println("TC6 = PASS; Error message is: " + actualMessage);
    }

    public void verifyCartAccessWithoutLoginError(WebDriver driver, String expectedMessage) {
        By errorMessageElement = By.xpath("//*[text()=\"Epic sadface: You can only access '/cart.html' when you are logged in.\"]");
        WebElement errorElement = driver.findElement(errorMessageElement);

        String actualMessage = errorElement.getText();
        assert actualMessage.equals(expectedMessage)
                : "Expected message: '" + expectedMessage + "', but got: '" + actualMessage + "'";

        System.out.println("TC7 = PASS; Error message is: " + actualMessage);
    }

}
