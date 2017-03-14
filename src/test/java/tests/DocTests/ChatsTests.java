package tests.DocTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DocAppScreens.OneChatScreen;

public class ChatsTests extends LoginTests {
    private OneChatScreen oneChatScreen;

    @Parameters({"platformName", "platformVersion", "appiumServerURL", "deviceName", "UDID"})
    @BeforeMethod
    public void setUpChatsPage(String platformName, String platformVersion, String appiumServerURL, String deviceName, String UDID) throws Exception {
        this.setUpLoginPage(platformName, platformVersion, appiumServerURL, deviceName, UDID);
        this.correctLoginTest();
        Assert.assertTrue(chatsScreen.isChatsPageVisible());
    }

    @AfterMethod
    public void closeApp() throws Exception {
        this.tearDown();
    }

    @Test
    public void isAnyChatHere() {
        Assert.assertNotNull(chatsScreen.getSomeChat(0));
    }

    @Test(dependsOnMethods = {"isAnyChatHere"})
    public void openChat() {
        chatsScreen.openSomeChat(0);
        oneChatScreen = new OneChatScreen(driver);
        Assert.assertTrue(oneChatScreen.isChatOpened());
    }

}
