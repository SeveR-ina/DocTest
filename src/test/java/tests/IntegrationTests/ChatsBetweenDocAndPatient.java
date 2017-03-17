package tests.IntegrationTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import tests.AndroidSetup;

public class ChatsBetweenDocAndPatient extends AndroidSetup {

    @Parameters({"platformName", "platformVersion", "appiumServerURL", "deviceName", "UDID"})
    @BeforeMethod
    public void setAppTests(String platformName, String platformVersion, String appiumServerURL, String deviceName, String UDID) throws Exception {

    }

    @AfterMethod
    public void closeApps() throws Exception {
        this.tearDown();
    }
}
