package helpMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageHelper {
    public WebDriver driver;

    public PageHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollByPixel(int x, int y){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy("+x+","+y+")", "");

    }

    public void waitForThreeSeconds(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }
}
