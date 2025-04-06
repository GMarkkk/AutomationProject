package pages;

import helpMethods.ElementHelper;
import helpMethods.PageHelper;
import helpMethods.TabWindowHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static locators.CartPageLocators.checkoutButton;
import static locators.CartPageLocators.removeButtonElement;

public class CartPage {
    private WebDriver driver;
    private ElementHelper elementHelper;
    private PageHelper pageHelper;
    private TabWindowHelper tabWindowHelper;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        pageHelper = new PageHelper(driver);
        tabWindowHelper = new TabWindowHelper(driver);

    }

    public void clickOnRemove(){
        elementHelper.clickJSLocator(removeButtonElement);
        LoggerUtility.infoTest("The user clicks on remove");
    }

    public void clickOnCheckout(){
        elementHelper.clickJSLocator(checkoutButton);
        LoggerUtility.infoTest("The user clicks on checkout");
    }

    public void verifyProductRemovedFromCart(WebDriver driver, String productToRemove, Runnable removeAction) {
        List<WebElement> cartItems = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> productNamesBefore = cartItems.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        removeAction.run();
        List<WebElement> updatedCartItems = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> productNamesAfter = updatedCartItems.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assert !productNamesAfter.contains(productToRemove)
                : "Product was NOT removed from cart: " + productToRemove;
        System.out.println("TC10 = PASS! Product successfully removed from cart.");
    }

    public void verifyNumberOfProducts(WebDriver driver, int expectedProductCount) {
        List<WebElement> productElements = driver.findElements(By.xpath("//*[@class='inventory_item_name']"));
        List<String> productNames = productElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        assert productNames.size() == expectedProductCount
                : "TC14 = FAIL! Expected " + expectedProductCount + " products, but found " + productNames.size();

        System.out.println("TC14 = PASS! Number of products is correct: " + productNames.size());
    }

}
