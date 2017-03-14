package tests.DocTests;

import tests.AndroidSetup;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DocAppScreens.ChatsScreen;
import pages.DocAppScreens.LoginScreen;

import java.io.IOException;

public class LoginTests extends AndroidSetup {
    private String CORRECT_LOGIN, CORRECT_PASS, WARNING_EMPTY_FIELDS;
    private LoginScreen loginScreen;
    ChatsScreen chatsScreen;

    @Parameters({"platformName", "platformVersion", "appiumServerURL", "deviceName", "UDID"})
    @BeforeMethod
    public void setUpLoginPage(String platformName, String platformVersion, String appiumServerURL, String deviceName, String UDID) throws Exception {
        this.setUp(platformName, platformVersion, appiumServerURL, deviceName, UDID);
        loginScreen = new LoginScreen(driver);
        Assert.assertNotNull(loginScreen);
        Assert.assertTrue(loginScreen.isLoginFieldVisible());
        CORRECT_LOGIN = testProperties.getProperty("correctLogin");
        CORRECT_PASS = testProperties.getProperty("correctPass");
        WARNING_EMPTY_FIELDS = testProperties.getProperty("snackBarEmptyFields");
    }

    @AfterMethod
    public void closeApp() throws Exception {
        this.tearDown();
    }

    @Test
    public void correctLoginTest() throws IOException {
        //type correct data to login/pass
        typeToFieldAndHideKeyboard("login", CORRECT_LOGIN);
        typeToFieldAndHideKeyboard("password", CORRECT_PASS);

        loginScreen.pressLoginButton();

        chatsScreen = new ChatsScreen(driver);
        Assert.assertNotNull(chatsScreen);
    }

    private void typeToFieldAndHideKeyboard(String field, String text) {
        loginScreen.clearFieldAndTypeText(field, text);
        loginScreen.hideKeyBoard();
    }

    @Test
    public void falseLoginTest() throws IOException {
        String INCORRECT_LOGIN = testProperties.getProperty("incorrectLogin");
        String INCORRECT_PASS = testProperties.getProperty("incorrectPassword");
        String WARNING_INCORRECT_LOGIN = testProperties.getProperty("snackBarIncorrectLogin");

        typeToFieldAndHideKeyboard("login", INCORRECT_LOGIN);
        typeToFieldAndHideKeyboard("password", INCORRECT_PASS);
        loginScreen.pressLoginButton();
        Assert.assertTrue(loginScreen.warningTextEquals(WARNING_INCORRECT_LOGIN));
    }

    @Test
    public void emptyLoginFieldTest() throws IOException {
        //clear field, type text, hide keyboard:
        typeToFieldAndHideKeyboard("password", CORRECT_PASS);
        loginScreen.pressLoginButton();
        Assert.assertTrue(loginScreen.warningTextEquals(WARNING_EMPTY_FIELDS));
    }

    @Test
    public void emptyPasswordFieldTest() throws IOException {
        //clear field, type text, hide keyboard:
        typeToFieldAndHideKeyboard("login", CORRECT_LOGIN);
        loginScreen.pressLoginButton();
        Assert.assertTrue(loginScreen.warningTextEquals(WARNING_EMPTY_FIELDS));
    }

    @Test
    public void emptyFieldsTest() throws IOException {
        // all fields are empty. click on the isAuthSuccess button:
        loginScreen.pressLoginButton();
        Assert.assertTrue(loginScreen.warningTextEquals(WARNING_EMPTY_FIELDS));
    }

}

