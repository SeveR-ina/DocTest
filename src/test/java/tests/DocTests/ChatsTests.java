package tests.DocTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DocAppScreens.ChatsScreen;
import pages.DocAppScreens.LoginScreen;
import pages.DocAppScreens.OneChatScreen;
import tests.AndroidSetup;

public class ChatsTests extends AndroidSetup {
    private ChatsScreen chatsScreen;

    @Parameters({"platformName", "platformVersion", "appiumServerURL", "deviceName", "UDID"})
    @BeforeMethod
    public void setUpChatsPage(String platformName, String platformVersion, String appiumServerURL, String deviceName, String UDID) throws Exception {
        setUp(platformName, platformVersion, appiumServerURL, deviceName, UDID);
        LoginTests loginTests = new LoginTests();
        loginTests.loginScreen = new LoginScreen(driver);
        loginTests.CORRECT_LOGIN = testProperties.getProperty("correctLogin");
        loginTests.CORRECT_PASS = testProperties.getProperty("correctPass");

        loginTests.correctLoginTest();
        chatsScreen = loginTests.loginScreen.getChatsScreen();
        Assert.assertNotNull(chatsScreen);
    }

    @AfterMethod
    public void closeApp() throws Exception {
        this.tearDown();
    }

    @Test(priority = 1)
    public void isAnyChatHere() {
        Assert.assertNotNull(chatsScreen.getSomeChat(0));
    }

    @Test(priority = 2) //(dependsOnMethods = {"isAnyChatHere"})
    public void openChat() {
        chatsScreen.openSomeChat(0);
        OneChatScreen oneChatScreen = chatsScreen.getOneChatScreen();
        Assert.assertNotNull(oneChatScreen);

    }

}
