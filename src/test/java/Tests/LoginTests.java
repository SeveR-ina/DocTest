package Tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

public class LoginTests extends AndroidSetup {

    @BeforeMethod
    public void setUp() throws Exception {
        prepareAndroidForAppium();
        loadPropertiesFromFile();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void falseLoginTest() throws IOException {
        String ILLEGAL_LOGIN = testProperties.getProperty("illegalLogin");
        String ILLEGAL_PASS = testProperties.getProperty("illegalPass");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ILLEGAL_LOGIN, ILLEGAL_PASS);
        Assert.assertTrue(loginPage.incorrectLoginWorks());
        System.out.println("*** falseLoginTest DONE! ***");
    }

    @Test
    public void correctLoginTest() throws IOException {
        String CORRECT_LOGIN = testProperties.getProperty("correctLogin");
        String CORRECT_PASS = testProperties.getProperty("correctPass");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(CORRECT_LOGIN, CORRECT_PASS);
        Assert.assertTrue(loginPage.correctLoginWorks());
        System.out.println("*** correctLoginTest DONE! ***");
    }

}

