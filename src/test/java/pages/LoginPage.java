package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    //@WithTimeout(time = 20, unit = TimeUnit.SECONDS)
    @FindBy(id = "EmailEntry")
    private WebElement loginField;

    @AndroidFindBy(id = "PasswordEntry")
    private WebElement passwordField;

    @AndroidFindBy(id = "LoginButton")
    private WebElement loginButton;

    @AndroidFindBy(id = "snackbar_text")
    private WebElement snackBar;

    private By loginFieldBy = By.id("EmailEntry");
    private By snackBarBy = By.id("snackbar_text");

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean warningTextEquals(String snackBarText) {
        waitForVisibilityOf(snackBarBy, 10);
        return snackBar.getText().equalsIgnoreCase(snackBarText);
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
        waitForVisibilityOf(loginFieldBy, 20);
        return loginField.isDisplayed();
    }

}
