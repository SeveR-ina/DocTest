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
    //private By passwordFieldBy = By.xpath("//text[@value='введите пароль']");
    private By loginButtonBy = By.name("ВОЙТИ");
    private By snackBarBy = By.id("snackbar_text");

    private WebElement getElement(By element){
       return driver.findElement(element);
    }

    public void login(String illegalLogin, String illegalPassword) throws IOException {
        waitForVisibilityOf(loginFieldBy);
        getElement(loginFieldBy).click();
        getElement(loginFieldBy).clear();
        getElement(loginFieldBy).sendKeys(illegalLogin);
        getElement(docAppLabelBy).click();
        getElement(passwordFieldBy).click();
        getElement(passwordFieldBy).sendKeys(illegalPassword);
        getElement(docAppLabelBy).click();
        getElement(loginButtonBy).click();
    }
    public boolean incorrectLoginWorks(){
        return (getElement(snackBarBy).getText()).equalsIgnoreCase("Почта или пароль неверны");
    }
}
