package tests.DocTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import screens.DocAppScreens.ChatListScreenDoc;
import screens.DocAppScreens.LoginScreenDoc;
import screens.DocAppScreens.ChatScreenDoc;

public class ChatTestsDoc extends BaseDocMethods {

    private ChatScreenDoc chatScreenDoc;

    @Parameters({"port", "appName", "platformName", "platformVersion", "deviceName", "UDID"})
    @BeforeClass
    public void setUpCapabilities(int port, String appName, String platformName, String platformVersion, String deviceName, String UDID) throws Exception {
        setCapabilities(appName, platformName, platformVersion, deviceName, UDID);
        prepareAppiumServer(port);
        //driver = getAndroidDriver();
    }

    @BeforeMethod
    public void setUpOneChatScreen() throws Exception {
        driver = getAndroidDriver(); //?
        LoginScreenDoc loginScreenDoc = openDocLoginScreen();
        Assert.assertNotNull(loginScreenDoc);

        ChatListScreenDoc chatListScreenDoc = correctLoginInDocApp();
        Assert.assertNotNull(chatListScreenDoc);

        chatScreenDoc = chatListScreenDoc.getOneChatScreen();
        Assert.assertNotNull(chatScreenDoc);
    }

    @AfterMethod
    public void closeApp() throws Exception {
        this.tearDown();
    }
}
