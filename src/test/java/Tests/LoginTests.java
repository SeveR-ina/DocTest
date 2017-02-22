package Tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTests extends AndroidSetup {
    private String TEXT_OF_CORRECT_LOGIN, TEXT_OF_CORRECT_PASS, WARNING_EMPTY_FIELDS;

    @BeforeMethod
    public void prepareTest() throws Exception {
        this.setUp();
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
    public void emptyLoginTest() throws IOException {
        System.out.println("*** check login... ***");
        loginPage.typeToFieldSomeText("password", TEXT_OF_CORRECT_PASS);
        loginPage.hideKeyBoard();
        loginPage.pressLoginButton();
        Assert.assertTrue(loginPage.warningTextEquals(WARNING_EMPTY_FIELDS));

        System.out.println("*** emptyLoginTest DONE! ***");
    }

    @Test
    public void emptyFieldsTest() throws IOException {

        System.out.println("*** emptyFieldsTest is started! ***");
        System.out.println("*** check all fields... ***");
        loginPage.pressLoginButton();
        Assert.assertTrue(loginPage.warningTextEquals(WARNING_EMPTY_FIELDS));

        System.out.println("*** emptyFieldsTest DONE! ***");
    }

    @Test
    public void emptyPassTest() throws IOException {

        System.out.println("*** check password... ***");
        loginPage.typeToFieldSomeText("login", TEXT_OF_CORRECT_LOGIN);
        loginPage.hideKeyBoard();
        loginPage.pressLoginButton();
        Assert.assertTrue(loginPage.warningTextEquals(WARNING_EMPTY_FIELDS));

        System.out.println("*** emptyPassTest DONE! ***");
    }





}

