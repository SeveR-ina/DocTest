package pages;

import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

class BasePage {
    private static WebDriver driver;

    BasePage(WebDriver driver) {
        BasePage.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
    }

    WebElement getElement(By element){
        return driver.findElement(element);
    }

    void waitForVisibilityOf(By locator, long timeOutInSeconds) {
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
