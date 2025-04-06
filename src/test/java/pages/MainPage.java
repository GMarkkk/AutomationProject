package pages;

import helpMethods.ElementHelper;
import helpMethods.PageHelper;
import helpMethods.TabWindowHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static locators.MainPageLocators.*;

public class MainPage {
    private WebDriver driver;
    private ElementHelper elementHelper;
    private PageHelper pageHelper;
    private TabWindowHelper tabWindowHelper;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        pageHelper = new PageHelper(driver);
        tabWindowHelper = new TabWindowHelper(driver);

    }

    public void clickOnFilterBox(){
        elementHelper.clickJSLocator(productFilterBoxElement);
        LoggerUtility.infoTest("The user clicks on the filter option box");
    }

    public void clickOnAToZFilter (){
        elementHelper.clickJSLocator(aToZFilterElement);
        LoggerUtility.infoTest("The user clicks on the A to Z option");
    }

    public void clickOnZToAFilter (){
        elementHelper.clickJSLocator(zToAFilterElement);
        LoggerUtility.infoTest("The user clicks on the Z to A option");
    }

    public void clickOnLowToHighFilter(){
        elementHelper.clickJSLocator(lowToHighFilterElement);
        LoggerUtility.infoTest("The user clicks on the Low to High option");
    }

    public void clickOnHighToLowFilter(){
        elementHelper.clickJSLocator(highToLowFilterElement);
        LoggerUtility.infoTest("The user clicks on the High to Low option");
    }

//    public void clickOnProductFilterBox(){
//        elementHelper.clickJSLocator(productFilterBoxElement);
//    }
//
//    public void selectFilters(List<String> filters){
//        List<WebElement> filtersList = driver.findElements(By.xpath())
//    }

    public void clickOnBurgerMenu(){
        elementHelper.clickJSLocator(burgerMenuElement);
        LoggerUtility.infoTest("The user clicks on the burger menu");
    }

    public void clickOnLogout(){
        elementHelper.clickJSLocator(logoutElement);
        LoggerUtility.infoTest("The user clicks on the logout button");
    }

    public void clickOnCart(){
        elementHelper.clickJSLocator(cartElement);
        LoggerUtility.infoTest("The user clicks on the cart button");
    }

    public void navigateToPreviousPage() {
        driver.navigate().back();
        LoggerUtility.infoTest("The user navigates back to the previous page");
    }

    public void addToCartBackpack(){
        elementHelper.clickJSLocator(addToCartBackpackElement);
        LoggerUtility.infoTest("The user adds the backpack to cart");
    }

    public void addToCartLight() {
        elementHelper.clickJSLocator(addToLightElement);
        LoggerUtility.infoTest("The user adds the bicycle light to cart");
    }

    public void addToCartTshirt() {
        elementHelper.clickJSLocator(addToCartTshirtElement);
        LoggerUtility.infoTest("The user adds the T-shirt to cart");
    }

    public void addToCartFleece() {
        elementHelper.clickJSLocator(addToCartFleeceElement);
        LoggerUtility.infoTest("The user adds the fleece jacket to cart");
    }

    public void addToCartOnesie() {
        elementHelper.clickJSLocator(addToCartOnesieElement);
        LoggerUtility.infoTest("The user adds the onesie to cart");
    }


    public void addToCartAllThingsTshirt() {
        elementHelper.clickJSLocator(addToCartAllThingsShirtElement);
        LoggerUtility.infoTest("The user adds the All Things T-shirt to cart");
    }

    public void removeBackpack(){
        elementHelper.clickJSLocator(removeBackpack);
        LoggerUtility.infoTest("The user removes the backpack from cart");
    }

    public void navigateToPreviousTab(){
        tabWindowHelper.navigateToPreviousPage();
    }

    public void verifyProductOrderTC8(WebDriver driver, List<String> expectedOrder) {
        List<WebElement> productElements = driver.findElements(By.xpath("//*[@class='inventory_item_name']"));

        List<String> productNames = productElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        assert productNames.equals(expectedOrder)
                : "TC8 = FAIL! Product order does not match expected!";

        System.out.println("TC8 = PASS! Product order changes correctly based on the filter.");
    }

    public void verifyRemoveButtonText(WebDriver driver, String expectedMessage) {
        By removeMessageElement = By.id("remove-sauce-labs-backpack");
        WebElement removeElement = driver.findElement(removeMessageElement);

        String actualMessage = removeElement.getText();
        assert actualMessage.equals(expectedMessage)
                : "Expected message: '" + expectedMessage + "', but got: '" + actualMessage + "'";

        System.out.println("TC9 = PASS; Button is: " + actualMessage);
    }

    public void verifyButtonText1(WebDriver driver, WebElement button, String expectedText) {
        String initialText = button.getText();
        assert initialText.equals(expectedText)
                : "Expected initial text '" + expectedText + "' but got: " + initialText;

        System.out.println("Button text verified: " + initialText);
    }

    public void verifyButtonTextUpdated(WebDriver driver, WebElement button, String expectedText) {
        String updatedText = button.getText();
        assert updatedText.equals(expectedText)
                : "TC15 = FAIL! Button text did not change to '" + expectedText + "'. Found: " + updatedText;

        System.out.println("TC15 = PASS! Button text successfully changed to '" + expectedText + "'.");
    }


}
