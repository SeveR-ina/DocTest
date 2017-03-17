package pages;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseMethods {
    protected static AndroidDriver driver;

    protected BaseMethods(AndroidDriver driver) {
        BaseMethods.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

    protected WebElement getElement(By elementBy){
        return driver.findElement(elementBy);
    }

    protected List<WebElement> getListOfElements(By elementBy){
        return driver.findElements(elementBy);
    }

    protected void waitForVisibilityOf(By locator, long timeOutInSeconds) {
        Wait<WebDriver> wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(visibilityOfElementLocated(locator));
    }

    private static ExpectedCondition<WebElement> visibilityOfElementLocated(final By locator) {
        return new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement toReturn = driver.findElement(locator);
                if (toReturn.isDisplayed()) {
                    return toReturn;
                }
                return null;
            }
        };
    }
}
