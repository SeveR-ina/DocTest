package pages.DocAppScreens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BaseMethods;

public class LoginScreen extends BaseMethods {

    private WebElement loginField, passwordField, loginButton;
    private By loginButtonBy = By.id("LoginButton");
    private By loginFieldBy = By.id("EmailEntry");
    private By snackBarBy = By.id("snackbar_text");

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

    public ChatsScreen getChatsScreen() {
        ChatsScreen chatsScreen = new ChatsScreen(driver);
        waitForVisibilityOf(chatsScreen.toolbarBy, 20);
        return chatsScreen;
    }

    public void hideKeyBoard() {
        driver.hideKeyboard();
    }

    private void clearElementByAndSendKeys(WebElement element, String keys) {
        clearInputElement(element);
        element.sendKeys(keys);
    }

    public boolean areInputFieldsVisible() {
        return loginField.isDisplayed() && passwordField.isDisplayed();
    }

}
