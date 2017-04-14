package tests.PatientTests;

import org.testng.Assert;
import org.testng.annotations.*;
import screens.PatientScreens.ChatListScreenPatient;
import screens.PatientScreens.LoginScreenPatient;

import java.io.IOException;

public class LoginTestsPatient extends BasePatientMethods {
    private String WARNING_EMPTY_FIELDS;
    private String CORRECT_LOGIN, CORRECT_PASS;
    private LoginScreenPatient loginScreenPatient;

    @Parameters({"port", "appName", "platformName", "platformVersion", "deviceName", "UDID"})
    @BeforeClass
    public void setUpCapabilities(int port, String appName, String platformName, String platformVersion, String deviceName, String UDID) throws Exception {
        setCapabilities(appName, platformName, platformVersion, deviceName, UDID);
        prepareAppiumServer(port);
    }

   @BeforeMethod
    public void setUpLoginScreen() throws Exception {
        //setCapabilities(appName, platformName, platformVersion, deviceName, UDID);
        //prepareAppiumServer(port);
        driver = getAndroidDriver(); //?
        loginScreenPatient = openPatientLoginScreen();
        Assert.assertNotNull(loginScreenPatient);
        WARNING_EMPTY_FIELDS = testProperties.getProperty("snackBarEmptyFields");
    }

    @AfterMethod
    public void closeApp() throws Exception {
        this.tearDown();
    }

    @Test//(enabled = false)
    public void correctLoginPatientTest() throws IOException {
        Assert.assertTrue(loginScreenPatient.areInputFieldsVisible());
        typeToFieldAndHideKeyboard("login", CORRECT_LOGIN);
        loginScreenPatient.clearFieldAndTypeText("password", CORRECT_PASS);
        loginScreenPatient.pressOkayOnKeyBoard();

        ChatListScreenPatient chatListScreenPatient = loginScreenPatient.getPatientChatsScreen();
        Assert.assertNotNull(chatListScreenPatient);
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
