package Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ChatsPage;

public class ChatsTests extends LoginTests {

    private ChatsPage chatsPage;

    @Parameters({"platformName", "platformVersion", "appiumServerURL", "deviceName", "UDID"})
    @BeforeMethod
    public void setUpChatsPage(String platformName, String platformVersion, String appiumServerURL, String deviceName, String UDID) throws Exception {
        this.setUpLoginPage(platformName, platformVersion, appiumServerURL, deviceName, UDID);
        chatsPage = this.correctLoginTest();
    }

    @AfterMethod
    public void closeApp() throws Exception {
        this.tearDown();
    }

    @Test
    public void isAnyChatHere(){

    }

    @Test(dependsOnMethods = {"isAnyChatHere"})
    public void openChat(){

    }

}
