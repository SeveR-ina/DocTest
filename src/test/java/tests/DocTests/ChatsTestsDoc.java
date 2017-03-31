package tests.DocTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.DocAppScreens.ChatsScreenDoc;
import screens.DocAppScreens.LoginScreenDoc;
import screens.DocAppScreens.DocChatScreen;
import tests.MainSetup;

public class ChatsTestsDoc extends MainSetup {
    private ChatsScreenDoc chatsScreenDoc;

    @Parameters({"appName", "platformName", "platformVersion", "appiumServerURL", "deviceName", "UDID"})
    @BeforeMethod
    public void setUpChatsPage(String appName, String platformName, String platformVersion, String appiumServerURL, String deviceName, String UDID) throws Exception {
        LoginScreenDoc loginScreenDoc = openLoginPage(appName, platformName, platformVersion, appiumServerURL, deviceName, UDID);
        Assert.assertNotNull(loginScreenDoc);
        chatsScreenDoc = correctLogin();
        Assert.assertNotNull(chatsScreenDoc);
    }

    @AfterMethod
    public void closeApp() throws Exception {
        this.tearDown();
    }

    @Test(priority = 1)
    public void isAnyChatHere() {
        Assert.assertNotNull(chatsScreenDoc.getSomeChat(0));
    }

    @Test(priority = 2) //(dependsOnMethods = {"isAnyChatHere"})
    public void openAnyChat() {
        chatsScreenDoc.openSomeChat(0);
        DocChatScreen docChatScreen = chatsScreenDoc.getOneChatScreen();
        Assert.assertNotNull(docChatScreen);
    }

}
