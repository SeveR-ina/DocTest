package tests.DocTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.DocAppScreens.ChatsScreen;
import pages.DocAppScreens.LoginScreen;
import pages.DocAppScreens.OneChatScreen;
import tests.AndroidSetup;

public class OneChatTests extends AndroidSetup {

    private OneChatScreen oneChatScreen;

    @Parameters({"platformName", "platformVersion", "appiumServerURL", "deviceName", "UDID"})
    @BeforeMethod
    public void setUpOneChatPage(String platformName, String platformVersion, String appiumServerURL, String deviceName, String UDID) throws Exception {
        setUp(platformName, platformVersion, appiumServerURL, deviceName, UDID);
        LoginTests loginTests = new LoginTests();
        loginTests.loginScreen = new LoginScreen(driver);
        loginTests.CORRECT_LOGIN = testProperties.getProperty("correctLogin");
        loginTests.CORRECT_PASS = testProperties.getProperty("correctPass");

        loginTests.correctLoginTest();
        ChatsScreen chatsScreen = loginTests.loginScreen.getChatsScreen();
        Assert.assertNotNull(chatsScreen);
        oneChatScreen = chatsScreen.getOneChatScreen();
        Assert.assertNotNull(chatsScreen);
    }

    @AfterMethod
    public void closeApp() throws Exception {
        this.tearDown();
    }
}
