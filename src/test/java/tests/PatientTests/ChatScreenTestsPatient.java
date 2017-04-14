package tests.PatientTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import tests.MainSetup;

public class ChatScreenTestsPatient extends BasePatientMethods {

    @Parameters({"port", "appName", "platformName", "platformVersion", "appiumServerURL", "deviceName", "UDID"})
    @BeforeMethod
    public void setUpChatScreen(int port, String appName, String platformName, String platformVersion, String appiumServerURL, String deviceName, String UDID) throws Exception {

    }

    @AfterMethod
    public void closeApp() throws Exception {
        this.tearDown();
    }

}
