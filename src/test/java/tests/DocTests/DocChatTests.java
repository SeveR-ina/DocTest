package tests.DocTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import screens.DocAppScreens.ChatsScreenDoc;
import screens.DocAppScreens.LoginScreenDoc;
import screens.DocAppScreens.DocChatScreen;
import tests.MainSetup;

public class DocChatTests extends MainSetup {

    private DocChatScreen docChatScreen;

    @Parameters({"appName", "platformName", "platformVersion", "appiumServerURL", "deviceName", "UDID"})
    @BeforeMethod
    public void setUpOneChatPage(String appName, String platformName, String platformVersion, String appiumServerURL, String deviceName, String UDID) throws Exception {
        LoginScreenDoc loginScreenDoc = openLoginPage(appName, platformName, platformVersion, appiumServerURL, deviceName, UDID);
        Assert.assertNotNull(loginScreenDoc);

        ChatsScreenDoc chatsScreenDoc = correctLogin();
        Assert.assertNotNull(chatsScreenDoc);

        docChatScreen = chatsScreenDoc.getOneChatScreen();
        Assert.assertNotNull(docChatScreen);
    }

    @AfterMethod
    public void closeApp() throws Exception {
        this.tearDown();
    }
}
