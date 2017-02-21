package scenarios;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

public class LoginTests extends AndroidSetup {

    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void falseLoginTest() throws IOException {
        loadPropertiesFromFile();
        String ILLEGAL_LOGIN = testProperties.getProperty("illegalLogin");
        String ILLEGAL_PASS = testProperties.getProperty("illegalPass");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ILLEGAL_LOGIN, ILLEGAL_PASS);
        Assert.assertTrue(loginPage.incorrectLoginWorks());
        System.out.println("*** falseLoginTest DONE! ***");
    }

}

