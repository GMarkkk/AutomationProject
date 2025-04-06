package pages;

import helpMethods.ElementHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static locators.CheckoutPageLocators.*;

public class CheckoutPage {
    private WebDriver driver;
    private ElementHelper elementHelper;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    public void fillFirstName(String firstNameValue){
        elementHelper.clickJSLocator(firstNameElement);
        elementHelper.fillLocator(firstNameElement, firstNameValue);
        LoggerUtility.infoTest("The user fills the first name box");
    }

    public void fillLastName(String lastNameValue){
        elementHelper.clickJSLocator(lastNameElement);
        elementHelper.fillLocator(lastNameElement, lastNameValue);
        LoggerUtility.infoTest("The user fills the last name box");
    }

    public void fillZipCode(String zipCodeValue){
        elementHelper.clickJSLocator(zipCodeElement);
        elementHelper.fillLocator(zipCodeElement, zipCodeValue);
        LoggerUtility.infoTest("The user fills the postcode box");
    }

    public void clickOnContinue(){
        elementHelper.clickJSLocator(continueElement);
        LoggerUtility.infoTest("The user clicks continue");
    }

    public void verifyCheckoutStepOneUrlTC11(WebDriver driver, String expectedURL) {
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "TC11 = FAIL! URL does not match.");
        System.out.println("TC11 = PASS!; The user is redirected to the next page");
    }

    public void verifyChOutWithNoProducts(WebDriver driver, String expectedURL) {
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "TC12 = FAIL! The client gets redirected to the checkout page without any products in the cart.");
        System.out.println("TC12 = PASS!");
    }

    public void verifyCheckoutStepTwoUrl(WebDriver driver, String expectedURL) {
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "TC13 = FAIL! The user is not redirected to the next page.");
        System.out.println("TC13 = PASS!");
    }

}
