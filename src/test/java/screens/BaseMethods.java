package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import screens.PatientScreens.ChatListScreenPatient;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseMethods {
    protected static AndroidDriver driver;

    private WebElement loginField, passwordField, loginButton;
    private By loginButtonBy = By.id("LoginButton");
    private By loginFieldBy = By.id("EmailEntry");
    private By snackBarBy = By.id("snackbar_text");

    protected BaseMethods(AndroidDriver driver) {
        BaseMethods.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

    protected WebElement getElement(By elementBy) {
        return driver.findElement(elementBy);
    }

    protected List<WebElement> getListOfElements(By elementBy) {
        return driver.findElements(elementBy);
    }

    protected void waitForVisibilityOf(By locator, long timeOutInSeconds) {
        Wait<WebDriver> wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(visibilityOfElementLocated(locator));
    }

    public boolean isElementInvisible(By locator) {
        if (!driver.findElements(locator).isEmpty()) {
            if (driver.findElement(locator).isDisplayed()) {
                return true;
            }
        }
        return false;
    }

    protected boolean isElementVisible(By locator) {
        if (!driver.findElements(locator).isEmpty()) {
            if (driver.findElement(locator).isDisplayed()) {
                return true;
            }
        }
        return false;
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

    protected void setLoginElements() {
        loginField = getElement(loginFieldBy);
        loginButton = getElement(loginButtonBy);
        By passwordFieldBy = By.id("PasswordEntry");
        passwordField = getElement(passwordFieldBy);
    }

    private WebElement getWarning() {
        waitForVisibilityOf(snackBarBy, 20);
        return getElement(snackBarBy);
    }

    public boolean warningTextEquals(String snackBarText) {
        String warningText = getWarning().getText();
        return warningText.equalsIgnoreCase(snackBarText);
    }

    public void clearFieldAndTypeText(String field, String keys) {
        if (field.equalsIgnoreCase("login")) {
            clearElementByAndSendKeys(loginField, keys);
        } else if (field.equalsIgnoreCase("password")) {
            clearElementByAndSendKeys(passwordField, keys);
        } else {
            System.out.println("Введите правильное название поля: либо login либо password");
        }
    }

    private void clearInputElement(WebElement field) {
        waitForVisibilityOf(loginFieldBy, 30);
        field.click();
        field.clear();
    }

    public void pressOkayOnKeyBoard() {
        driver.pressKeyCode(AndroidKeyCode.ENTER);
    }

    public void pressLoginButton() {
        waitForVisibilityOf(loginButtonBy, 20);
        loginButton.click();
    }

    public ChatListScreenPatient getPatientChatsScreen() {
        ChatListScreenPatient chatListScreenPatient = new ChatListScreenPatient(driver);
        waitForVisibilityOf(chatListScreenPatient.toolbarBy, 20);
        return chatListScreenPatient;
    }

    private void clearElementByAndSendKeys(WebElement element, String keys) {
        clearInputElement(element);
        element.sendKeys(keys);
    }

    public boolean areInputFieldsVisible() {
        return loginField.isDisplayed() && passwordField.isDisplayed();
    }
}
