package tests.PatientTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.PatientScreens.MainScreen;
import tests.AndroidSetup;

import java.io.IOException;

public class MainPageTests extends AndroidSetup {

    private MainScreen mainScreen;

    @Parameters({"platformName", "platformVersion", "appiumServerURL", "deviceName", "UDID"})
    @BeforeMethod
    public void setUpLoginPage(String platformName, String platformVersion, String appiumServerURL, String deviceName, String UDID) throws Exception {
        this.setUp(platformName, platformVersion, appiumServerURL, deviceName, UDID);
        mainScreen = new MainScreen(driver);
        Assert.assertNotNull(mainScreen);
        //Assert.assertTrue(mainScreen.isLoginFieldVisible());
    }

    @AfterMethod
    public void closeApp() throws Exception {
        this.tearDown();
    }

    @Test
    public void openAskDoctorsScreen() throws IOException {
        //mainScreen.
    }
}
