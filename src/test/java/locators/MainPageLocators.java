package locators;

import org.openqa.selenium.By;

public class MainPageLocators {
    public static final By productFilterBoxElement = By.xpath("//*[@class=\"product_sort_container\"]\n");
    public static final By aToZFilterElement = By.xpath("//*[text()=\"Name (A to Z)\"]");
    public static final By zToAFilterElement = By.xpath("//*[text()=\"Name (Z to A)\"]");
    public static final By lowToHighFilterElement = By.xpath("//*[text()=\"Price (low to high)\"]");
    public static final By highToLowFilterElement = By.xpath("//*[text()=\"Price (high to low)\"]");
    public static final By burgerMenuElement = By.id("react-burger-menu-btn");
    public static final By logoutElement = By.id("logout_sidebar_link");
    public static final By cartElement = By.xpath("//a[@class='shopping_cart_link']");
    public static final By addToCartBackpackElement = By.id("add-to-cart-sauce-labs-backpack");
    public static final By addToLightElement = By.id("add-to-cart-sauce-labs-bike-light");
    public static final By addToCartTshirtElement = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    public static final By addToCartFleeceElement = By.id("add-to-cart-sauce-labs-fleece-jacket");
    public static final By addToCartOnesieElement = By.id("add-to-cart-sauce-labs-onesie");
    public static final By addToCartAllThingsShirtElement = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    public static final By removeBackpack = By.id("remove-sauce-labs-backpack");

}
