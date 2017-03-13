package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ChatsTests extends LoginTests {

    @Parameters({"platformName", "platformVersion", "appiumServerURL", "deviceName", "UDID"})
    @BeforeMethod
    public void setUpChatsPage(String platformName, String platformVersion, String appiumServerURL, String deviceName, String UDID) throws Exception {
        this.setUpLoginPage(platformName, platformVersion, appiumServerURL, deviceName, UDID);
        this.correctLoginTest();
        Assert.assertTrue(chatsPage.isChatsPageVisible());
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
