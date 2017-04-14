package tests.PatientTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.MainSetup;

public class AskDoctorTestsPatient extends BasePatientMethods {

    @Parameters({"port", "appName", "platformName", "platformVersion", "appiumServerURL", "deviceName", "UDID"})
    @BeforeMethod
    public void setUpAskDoctorScreen(int port, String appName, String platformName, String platformVersion, String appiumServerURL, String deviceName, String UDID) throws Exception {

    }

    @AfterMethod
    public void closeApp() throws Exception {
        this.tearDown();
    }

    @Test(priority = 1)
    public void isAnyChatHere() {

    }

}

