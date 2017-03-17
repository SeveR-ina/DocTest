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

    @Parameters({"platformName", "platformVersion", "appiumServerURL", "deviceName", "UDID"})
    @BeforeMethod
    public void setUpLoginPage(String platformName, String platformVersion, String appiumServerURL, String deviceName, String UDID) throws Exception {
        this.setUp(platformName, platformVersion, appiumServerURL, deviceName, UDID);
        MainScreen mainScreen = new MainScreen(driver);
        Assert.assertNotNull(mainScreen);
    }

    @AfterMethod
    public void closeApp() throws Exception {
        this.tearDown();
    }

    @Test
    public void openAskDoctorsScreen() throws IOException {

    }
}
