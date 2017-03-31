package tests.PatientTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.PatientScreens.ChatsScreenPatient;
import screens.PatientScreens.LoginScreenPatient;
import tests.MainSetup;

import java.io.IOException;

public class LoginTestsPatient extends MainSetup {
    private String WARNING_EMPTY_FIELDS;
    private String CORRECT_LOGIN, CORRECT_PASS;
    private LoginScreenPatient loginScreenPatient;

    @Parameters({"appName", "platformName", "platformVersion", "appiumServerURL", "deviceName", "UDID"})
    @BeforeMethod
    public void setUpLoginPage(String appName, String platformName, String platformVersion, String appiumServerURL, String deviceName, String UDID) throws Exception {

    }

    @AfterMethod
    public void closeApp() throws Exception {
        this.tearDown();
    }

    @Test//(enabled = false)
    public void correctLoginTest() throws IOException {
        Assert.assertTrue(loginScreenPatient.areInputFieldsVisible());
        typeToFieldAndHideKeyboard("login", CORRECT_LOGIN);
        loginScreenPatient.clearFieldAndTypeText("password", CORRECT_PASS);
        loginScreenPatient.pressOkayOnKeyBoard();

        ChatsScreenPatient chatsScreenPatient = loginScreenPatient.getPatientChatsScreen();
        Assert.assertNotNull(chatsScreenPatient);
    }

    @Test
    public void emptyFieldsTest() throws IOException {
        Assert.assertTrue(loginScreenPatient.areInputFieldsVisible());
        loginScreenPatient.pressLoginButton();
        Assert.assertTrue(loginScreenPatient.warningTextEquals(WARNING_EMPTY_FIELDS));
    }


    @Test
    public void falseLoginTest() throws IOException {
        String INCORRECT_LOGIN = testProperties.getProperty("incorrectLogin");
        String INCORRECT_PASS = testProperties.getProperty("incorrectPassword");
        String WARNING_INCORRECT_LOGIN = testProperties.getProperty("snackBarIncorrectLogin");

        Assert.assertTrue(loginScreenPatient.areInputFieldsVisible());
        typeToFieldAndHideKeyboard("login", INCORRECT_LOGIN);
        typeToFieldAndHideKeyboard("password", INCORRECT_PASS);
        loginScreenPatient.pressLoginButton();
        Assert.assertTrue(loginScreenPatient.warningTextEquals(WARNING_INCORRECT_LOGIN));
    }

    @Test
    public void emptyLoginFieldTest() throws IOException {
        Assert.assertTrue(loginScreenPatient.areInputFieldsVisible());
        typeToFieldAndHideKeyboard("password", CORRECT_PASS);
        loginScreenPatient.pressLoginButton();
        Assert.assertTrue(loginScreenPatient.warningTextEquals(WARNING_EMPTY_FIELDS));
    }

    @Test
    public void emptyPasswordFieldTest() throws IOException {
        Assert.assertTrue(loginScreenPatient.areInputFieldsVisible());
        typeToFieldAndHideKeyboard("login", CORRECT_LOGIN);
        loginScreenPatient.pressLoginButton();
        Assert.assertTrue(loginScreenPatient.warningTextEquals(WARNING_EMPTY_FIELDS));
    }
}
