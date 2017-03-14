package pages.DocAppScreens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BaseMethods;

public class LoginScreen extends BaseMethods {

    private WebElement loginField;
    private WebElement loginButton;
    private WebElement passwordField;
    private By loginFieldBy = By.id("EmailEntry");
    private By snackBarBy = By.id("snackbar_text");
    private By loginButtonBy = By.id("LoginButton");

    public LoginScreen(AndroidDriver driver) {
        super(driver);
        waitForVisibilityOf(loginFieldBy, 20);
        setAllElements();
    }

    private void setAllElements() {
        loginField = getElement(loginFieldBy);
        loginButton = getElement(loginButtonBy);
        By passwordFieldBy = By.id("PasswordEntry");
        passwordField = getElement(passwordFieldBy);
    }

    public WebElement getWarning() {
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
            System.out.println("Введите правильное название поля: либо логин либо пароль");
        }
    }

    private void clearElement(WebElement field) {
        waitForVisibilityOf(loginFieldBy, 30);
        field.click();
        field.clear();
    }

    public void pressLoginButton() {
        waitForVisibilityOf(loginButtonBy, 20);
        loginButton.isDisplayed();
        loginButton.click();
    }

    public void hideKeyBoard() {
        driver.pressKeyCode(AndroidKeyCode.BACK);
    }

    private void clearElementByAndSendKeys(WebElement element, String keys) {
        clearElement(element);
        element.sendKeys(keys);
    }

    public boolean isLoginFieldVisible() {
        return loginField.isDisplayed();
    }

}
