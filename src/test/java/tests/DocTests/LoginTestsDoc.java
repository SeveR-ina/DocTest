package tests.DocTests;

import tests.MainSetup;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.DocAppScreens.LoginScreenDoc;

import java.io.IOException;

public class LoginTestsDoc extends MainSetup {
    private String WARNING_EMPTY_FIELDS;
    private LoginScreenDoc loginScreenDoc;

    @Parameters({"appName", "platformName", "platformVersion", "appiumServerURL", "deviceName", "UDID"})
    @BeforeMethod
    public void setUpLoginPage(String appName, String platformName, String platformVersion, String appiumServerURL, String deviceName, String UDID) throws Exception {
        loginScreenDoc = openLoginPage(appName, platformName, platformVersion, appiumServerURL, deviceName, UDID);
        Assert.assertNotNull(loginScreenDoc);
        WARNING_EMPTY_FIELDS = testProperties.getProperty("snackBarEmptyFields");
    }

    @AfterMethod
    public void closeApp() throws Exception {
        tearDown();
    }

    @Test//(enabled = false)
    public void correctLoginTest() throws IOException {
        Assert.assertNotNull(correctLogin());
    }

    @Test
    public void emptyFieldsTest() throws IOException {
        Assert.assertTrue(loginScreenDoc.areInputFieldsVisible());
        loginScreenDoc.pressLoginButton();
        Assert.assertTrue(loginScreenDoc.warningTextEquals(WARNING_EMPTY_FIELDS));
    }


    @Test
    public void falseLoginTest() throws IOException {
        String INCORRECT_LOGIN = testProperties.getProperty("incorrectLogin");
        String INCORRECT_PASS = testProperties.getProperty("incorrectPassword");
        String WARNING_INCORRECT_LOGIN = testProperties.getProperty("snackBarIncorrectLogin");

        Assert.assertTrue(loginScreenDoc.areInputFieldsVisible());
        typeToFieldAndHideKeyboard("login", INCORRECT_LOGIN);
        loginScreenDoc.clearFieldAndTypeText("password", INCORRECT_PASS);
        loginScreenDoc.pressOkayOnKeyBoard();
        Assert.assertTrue(loginScreenDoc.warningTextEquals(WARNING_INCORRECT_LOGIN));
    }

    @Test
    public void emptyLoginFieldTest() throws IOException {
        Assert.assertTrue(loginScreenDoc.areInputFieldsVisible());
        typeToFieldAndHideKeyboard("password", CORRECT_PASS);
        loginScreenDoc.pressLoginButton();
        Assert.assertTrue(loginScreenDoc.warningTextEquals(WARNING_EMPTY_FIELDS));
    }

    @Test
    public void emptyPasswordFieldTest() throws IOException {
        Assert.assertTrue(loginScreenDoc.areInputFieldsVisible());
        typeToFieldAndHideKeyboard("login", CORRECT_LOGIN);
        loginScreenDoc.pressLoginButton();
        Assert.assertTrue(loginScreenDoc.warningTextEquals(WARNING_EMPTY_FIELDS));
    }

}

