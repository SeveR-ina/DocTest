package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private By loginFieldBy = By.name("введите логин");
    private By docAppLabelBy = By.name("MedGreat Доктор");
    private By passwordFieldBy = By.xpath("//android.view.ViewGroup[@index='3']/android.widget.EditText");
    private By loginButtonBy = By.name("ВОЙТИ");
    private By snackBarBy = By.id("snackbar_text");
    private By myAnswersLabelBy = By.name("Мои ответы");

    public void login(String loginText, String passwordText) throws IOException {
        waitForVisibilityOf(loginFieldBy, 20);
        clearField(loginFieldBy);
        typeToFieldSomeText("login", loginText);
        hideKeyBoard();
        clearField(passwordFieldBy);
        typeToFieldSomeText("password", passwordText);
        hideKeyBoard();
        pressLoginButton();
    }

    public boolean warningTextEquals(String snackBarText){
        waitForVisibilityOf(snackBarBy, 10);
        return (getElement(snackBarBy).getText()).equalsIgnoreCase(snackBarText);
    }

    public boolean correctLoginWorks(){
        waitForVisibilityOf(myAnswersLabelBy, 20);
        return getElement(myAnswersLabelBy).isDisplayed();
    }

    public void typeToFieldSomeText(String field, String keys){
        if (field.equalsIgnoreCase("login")) {
            sendKeys(loginFieldBy, keys);
        }
        else if (field.equalsIgnoreCase("password")) {
            sendKeys(passwordFieldBy, keys);
        }
        else {
            System.out.println("Введите правильное название поля: либо login либо password");
        }

    }

    private void clearField(By fieldBy){
        WebElement field = getElement(fieldBy);
        field.click();
        field.clear();
    }

    public void pressLoginButton(){
        WebElement button = getElement(loginButtonBy);
        button.click();
    }

    public void hideKeyBoard(){
        WebElement label = getElement(docAppLabelBy);
        label.click();
    }

    private void sendKeys(By elementBy, String keys){
        clearField(elementBy);
        getElement(elementBy).sendKeys(keys);
    }

}
