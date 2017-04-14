package tests.DocTests;

import org.testng.Assert;
import org.testng.annotations.*;
import screens.DocAppScreens.ChatListScreenDoc;
import screens.DocAppScreens.LoginScreenDoc;
import screens.DocAppScreens.ChatScreenDoc;

public class ChatListTestsDoc extends BaseDocMethods {
    private ChatListScreenDoc chatListScreenDoc;

    @Parameters({"port", "appName", "platformName", "platformVersion", "deviceName", "UDID"})
    @BeforeClass
    public void setUpCapabilities(int port, String appName, String platformName, String platformVersion, String deviceName, String UDID) throws Exception {
        setCapabilities(appName, platformName, platformVersion, deviceName, UDID);
        prepareAppiumServer(port);
        //driver = getAndroidDriver();
    }

    @BeforeMethod
    public void setUpChatsScreen() throws Exception {
        driver = getAndroidDriver(); //?
        LoginScreenDoc loginScreenDoc = openDocLoginScreen();
        Assert.assertNotNull(loginScreenDoc);
        chatListScreenDoc = correctLoginInDocApp();
        Assert.assertNotNull(chatListScreenDoc);
    }

    @AfterMethod
    public void closeApp() throws Exception {
        this.tearDown();
    }

    @Test(priority = 1)
    public void isAnyChatHere() {
        Assert.assertNotNull(chatListScreenDoc.getSomeChat(0));
    }

    @Test(priority = 2) //(dependsOnMethods = {"isAnyChatHere"})
    public void openAnyChat() {
        chatListScreenDoc.openSomeChat(0);
        ChatScreenDoc chatScreenDoc = chatListScreenDoc.getOneChatScreen();
        Assert.assertNotNull(chatScreenDoc);
    }

}
