package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ChatsPage;
import pages.LoginPage;

import java.io.IOException;

public class LoginTests extends AndroidSetup {
    private String CORRECT_LOGIN, CORRECT_PASS, WARNING_EMPTY_FIELDS;
    private LoginPage loginPage;
    ChatsPage chatsPage;

    @Parameters({"platformName", "platformVersion", "appiumServerURL", "deviceName", "UDID"})
    @BeforeMethod
    public void setUpLoginPage(String platformName, String platformVersion, String appiumServerURL, String deviceName, String UDID) throws Exception {
        this.setUp(platformName, platformVersion, appiumServerURL, deviceName, UDID);
        loginPage = new LoginPage(driver);
        Assert.assertNotNull(loginPage);
        Assert.assertTrue(loginPage.isLoginFieldVisible());
        CORRECT_LOGIN = testProperties.getProperty("correctLogin");
        CORRECT_PASS = testProperties.getProperty("correctPass");
        WARNING_EMPTY_FIELDS = testProperties.getProperty("snackBarEmptyFields");
    }

    @AfterMethod
    public void closeApp() throws Exception {
        this.tearDown();
    }

    @Test
    public void falseLoginTest() throws IOException {
        String INCORRECT_LOGIN = testProperties.getProperty("incorrectLogin");
        String INCORRECT_PASS = testProperties.getProperty("incorrectPassword");
        String WARNING_INCORRECT_LOGIN = testProperties.getProperty("snackBarIncorrectLogin");

        typeToFieldAndHideKeyboard("login", INCORRECT_LOGIN);
        typeToFieldAndHideKeyboard("password", INCORRECT_PASS);
        loginPage.pressLoginButton();
        Assert.assertTrue(loginPage.warningTextEquals(WARNING_INCORRECT_LOGIN));
    }

    @Test
    public void correctLoginTest() throws IOException {
        //type correct data to login/pass
        typeToFieldAndHideKeyboard("login", CORRECT_LOGIN);
        typeToFieldAndHideKeyboard("password", CORRECT_PASS);
        loginPage.pressLoginButton();
        //PageFactory.initElements(this.getAndroidDriver(appiumServerURL), ChatsPage.class);
        chatsPage = new ChatsPage(driver);
        Assert.assertNotNull(chatsPage);
    }

    @Test
    public void emptyLoginFieldTest() throws IOException {
        //clear field, type text, hide keyboard:
        typeToFieldAndHideKeyboard("password", CORRECT_PASS);
        loginPage.pressLoginButton();
        Assert.assertTrue(loginPage.warningTextEquals(WARNING_EMPTY_FIELDS));
    }

    @Test
    public void emptyPasswordFieldTest() throws IOException {
        //clear field, type text, hide keyboard:
        typeToFieldAndHideKeyboard("login", CORRECT_LOGIN);
        loginPage.pressLoginButton();
        Assert.assertTrue(loginPage.warningTextEquals(WARNING_EMPTY_FIELDS));
    }

    @Test
    public void emptyFieldsTest() throws IOException {
        // all fields are empty. click on the isAuthSuccess button:
        loginPage.pressLoginButton();
        Assert.assertTrue(loginPage.warningTextEquals(WARNING_EMPTY_FIELDS));
    }

    private void typeToFieldAndHideKeyboard(String field, String text) {
        loginPage.clearFieldAndTypeText(field, text);
        loginPage.hideKeyBoard();
    }

}

