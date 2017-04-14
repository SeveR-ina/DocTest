package tests.PatientTests;

import org.testng.Assert;
import org.testng.annotations.*;
import screens.PatientScreens.LoginScreenPatient;

import java.io.IOException;

public class MainScreenTestsPatient extends BasePatientMethods {

    @Parameters({"port", "appName", "platformName", "platformVersion", "deviceName", "UDID"})
    @BeforeClass
    public void setUpCapabilities(int port, String appName, String platformName, String platformVersion, String deviceName, String UDID) throws Exception {
        setCapabilities(appName, platformName, platformVersion, deviceName, UDID);
        prepareAppiumServer(port);
    }

    @Parameters({"port", "appName", "platformName", "platformVersion", "appiumServerURL", "deviceName", "UDID"})
    @BeforeMethod
    public void setUpMainScreen() throws Exception {
        //setCapabilities(appName, platformName, platformVersion, deviceName, UDID);
        //prepareAppiumServer(port);
        driver = getAndroidDriver(); //?
        mainScreenPatient = openMainScreen();
        Assert.assertNotNull(mainScreenPatient);
    }

    @AfterMethod
    public void closeApp() throws Exception {
        this.tearDown();
    }

    @Test
    public void openAskDoctorsScreen() throws IOException {
        mainScreenPatient.pressAskDoctorsButton();
        LoginScreenPatient loginScreenPatient = new LoginScreenPatient(driver);
        Assert.assertNotNull(loginScreenPatient);
    }

    /*@Test
    public void checkIfMenuIsAvailable() throws IOException {

    }*/
}
