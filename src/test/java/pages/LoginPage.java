package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {
    //By login_Field = By.xpath("//android.widget.EditText[@text='введите логин']");
    By login_Field = By.name("введите логин");
    By label = By.name("MedGreat Доктор");
    By password_Field = By.xpath("//android.view.ViewGroup[@index='3']/android.widget.EditText");
    By login_Button = By.name("ВОЙТИ");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage invalidLogin() throws InterruptedException {
        waitForVisibilityOf(login_Field);
        driver.findElement(login_Field).click();
        driver.findElement(login_Field).clear();
        driver.findElement(login_Field).sendKeys("someone@test.com");
        driver.findElement(label).click();
        driver.findElement(password_Field).click();
        driver.findElement(password_Field).sendKeys("test123");
        driver.findElement(label).click();
        driver.findElement(login_Button).click();
        Assert.assertTrue(driver.findElement(By.id("snackbar_text")).getText().equalsIgnoreCase("Почта или пароль неверны"));
        return new LoginPage(driver);
    }
}
