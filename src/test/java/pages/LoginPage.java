package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private WebElement loginField;
    private WebElement loginButton;
    private WebElement passwordField;
    private By loginFieldBy = By.id("EmailEntry");
    private By snackBarBy = By.id("snackbar_text");
    private By loginButtonBy = By.id("LoginButton");

    public LoginPage(AndroidDriver driver) {
        super(driver);
        waitForVisibilityOf(loginFieldBy, 20);
        getAllElements();
    }

    private void getAllElements(){
        loginField = getElement(loginFieldBy);
        loginButton = getElement(loginButtonBy);
        By passwordFieldBy = By.id("PasswordEntry");
        passwordField = getElement(passwordFieldBy);
    }

    public boolean warningTextEquals(String snackBarText) {
        waitForVisibilityOf(snackBarBy, 20);
        return getElement(snackBarBy).getText().equalsIgnoreCase(snackBarText);
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
        waitForVisibilityOf(loginButtonBy, 10);
        //loginButton.isDisplayed();
        loginButton.click();
    }

    public void hideKeyBoard() {
        driver.hideKeyboard();
    }

    private void clearElementByAndSendKeys(WebElement element, String keys) {
        clearElement(element);
        element.sendKeys(keys);
    }

    public boolean isLoginFieldVisible() {
        return loginField.isDisplayed();
    }

}
