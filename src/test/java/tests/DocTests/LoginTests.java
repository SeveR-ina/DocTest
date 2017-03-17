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
    private String WARNING_EMPTY_FIELDS;
    String CORRECT_LOGIN, CORRECT_PASS;
    LoginScreen loginScreen;

    @Parameters({"platformName", "platformVersion", "appiumServerURL", "deviceName", "UDID"})
    @BeforeMethod
    public void setUpLoginPage(String platformName, String platformVersion, String appiumServerURL, String deviceName, String UDID) throws Exception {
        setUp(platformName, platformVersion, appiumServerURL, deviceName, UDID);
        loginScreen = new LoginScreen(driver);
        CORRECT_LOGIN = testProperties.getProperty("correctLogin");
        CORRECT_PASS = testProperties.getProperty("correctPass");
        WARNING_EMPTY_FIELDS = testProperties.getProperty("snackBarEmptyFields");
    }

    @AfterMethod
    public void closeApp() throws Exception {
        this.tearDown();
    }

    @Test//(enabled = false)
    public void correctLoginTest() throws IOException {
        Assert.assertTrue(loginScreen.areInputFieldsVisible());
        typeToFieldAndHideKeyboard("login", CORRECT_LOGIN);
        loginScreen.clearFieldAndTypeText("password", CORRECT_PASS);
        loginScreen.pressOkayOnKeyBoard();

        ChatsScreen chatsScreen = loginScreen.getChatsScreen();
        Assert.assertNotNull(chatsScreen);
    }

    @Test
    public void emptyFieldsTest() throws IOException {
        Assert.assertTrue(loginScreen.areInputFieldsVisible());
        loginScreen.pressLoginButton();
        Assert.assertTrue(loginScreen.warningTextEquals(WARNING_EMPTY_FIELDS));
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

        Assert.assertTrue(loginScreen.areInputFieldsVisible());
        typeToFieldAndHideKeyboard("login", INCORRECT_LOGIN);
        typeToFieldAndHideKeyboard("password", INCORRECT_PASS);
        loginScreen.pressLoginButton();
        Assert.assertTrue(loginScreen.warningTextEquals(WARNING_INCORRECT_LOGIN));
    }

    @Test
    public void emptyLoginFieldTest() throws IOException {
        Assert.assertTrue(loginScreen.areInputFieldsVisible());
        typeToFieldAndHideKeyboard("password", CORRECT_PASS);
        loginScreen.pressLoginButton();
        Assert.assertTrue(loginScreen.warningTextEquals(WARNING_EMPTY_FIELDS));
    }

    @Test
    public void emptyPasswordFieldTest() throws IOException {
        Assert.assertTrue(loginScreen.areInputFieldsVisible());
        typeToFieldAndHideKeyboard("login", CORRECT_LOGIN);
        loginScreen.pressLoginButton();
        Assert.assertTrue(loginScreen.warningTextEquals(WARNING_EMPTY_FIELDS));
    }

}

