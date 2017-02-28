package Tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTests extends AndroidSetup {
    private String TEXT_OF_CORRECT_LOGIN, TEXT_OF_CORRECT_PASS, WARNING_EMPTY_FIELDS;

    @Parameters({"platformName", "platformVersion", "appiumServerURL", "deviceName", "UDID"})
    @BeforeMethod
    public void prepareTest(String platformName, String platformVersion, String appiumServerURL, String deviceName, String UDID) throws Exception {
        this.setUp(platformName, platformVersion, appiumServerURL, deviceName, UDID);
        TEXT_OF_CORRECT_LOGIN = testProperties.getProperty("correctLogin");
        TEXT_OF_CORRECT_PASS = testProperties.getProperty("correctPass");
        WARNING_EMPTY_FIELDS = testProperties.getProperty("snackBarEmptyFields");
    }

    @AfterMethod
    public void closeApp() throws Exception {
        this.tearDown();
    }

    @Test
    public void falseLoginTest() throws IOException {
        String ILLEGAL_LOGIN = testProperties.getProperty("illegalLogin");
        String ILLEGAL_PASS = testProperties.getProperty("illegalPass");
        String WARNING_INCORRECT_LOGIN = testProperties.getProperty("snackBarIncorrectLogin");


        loginPage.login(ILLEGAL_LOGIN, ILLEGAL_PASS);
        Assert.assertTrue(loginPage.warningTextEquals(WARNING_INCORRECT_LOGIN));
        System.out.println("*** falseLoginTest DONE! ***");
    }

    @Test
    public void correctLoginTest() throws IOException {
        loginPage.login(TEXT_OF_CORRECT_LOGIN, TEXT_OF_CORRECT_PASS);
        Assert.assertTrue(loginPage.correctLoginWorks());
        System.out.println("*** correctLoginTest DONE! ***");
    }

    @Test
    public void emptyLoginFieldTest() throws IOException {
        System.out.println("*** check login... ***");
        typeToFieldSomeText("password", TEXT_OF_CORRECT_PASS);
        Assert.assertTrue(loginPage.warningTextEquals(WARNING_EMPTY_FIELDS));
        System.out.println("*** emptyLoginFieldTest DONE! ***");
    }

    @Test
    public void emptyPasswordFieldTest() throws IOException {
        System.out.println("*** check password... ***");
        typeToFieldSomeText("login", TEXT_OF_CORRECT_LOGIN);
        Assert.assertTrue(loginPage.warningTextEquals(WARNING_EMPTY_FIELDS));
        System.out.println("*** emptyPasswordFieldTest DONE! ***");
    }

    @Test
    public void emptyFieldsTest() throws IOException {

        System.out.println("*** emptyFieldsTest is started! ***");
        System.out.println("*** check all fields... ***");
        // all fields are empty. click on the login button:
        loginPage.pressLoginButton();
        Assert.assertTrue(loginPage.warningTextEquals(WARNING_EMPTY_FIELDS));

        System.out.println("*** emptyFieldsTest DONE! ***");
    }

    private void typeToFieldSomeText(String field, String keys){
        loginPage.typeToFieldSomeText(field, keys);
        loginPage.hideKeyBoard();
        loginPage.pressLoginButton();
    }

}

