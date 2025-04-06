package mainPageTests;

import helpMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.MainPage;
import sharedData.SharedData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TC8 extends SharedData {
    @Test
    public void testMethod(){
        IndexPage indexPage = new IndexPage(driver);

        String usernameValue = "problem_user";
        String passwordValue = "secret_sauce";

        indexPage.clickOnUsernameBox();
        indexPage.fillUsername(usernameValue);

        indexPage.clickOnPasswordBox();
        indexPage.fillPassword(passwordValue);

        indexPage.clickOnLoginButton();

        MainPage mainPage = new MainPage(driver);

        mainPage.clickOnFilterBox();
        mainPage.clickOnAToZFilter();
        mainPage.clickOnFilterBox();
        mainPage.clickOnZToAFilter();
        mainPage.clickOnFilterBox();
        mainPage.clickOnHighToLowFilter();
        mainPage.clickOnFilterBox();
        mainPage.clickOnLowToHighFilter();

        mainPage.verifyProductOrderTC8(driver, Arrays.asList("Sauce Labs Onesie\", \"Sauce Labs Bike Light\", \"Sauce Labs Bolt T-Shirt\", \"Test.allTheThings() T-Shirt (Red)\", \"Sauce Labs Backpack\", \"Sauce Labs Fleece\")"));

    }

}
