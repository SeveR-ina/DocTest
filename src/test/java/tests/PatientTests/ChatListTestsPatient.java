package tests.PatientTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.MainSetup;

public class ChatListTestsPatient extends BasePatientMethods {
    //private ChatListScreenPatient chatsScreenPatient;

    @Parameters({"port", "appName", "platformName", "platformVersion", "appiumServerURL", "deviceName", "UDID"})
    @BeforeMethod
    public void setUpChatsScreen(int port, String appName, String platformName, String platformVersion, String appiumServerURL, String deviceName, String UDID) throws Exception {

    }

    @AfterMethod
    public void closeApp() throws Exception {
        this.tearDown();
    }

    @Test(priority = 1)
    public void isAnyChatHere() {
        //Assert.assertNotNull(chatsScreenPatient.getSomeChat(0));
    }

    @Test(priority = 2) //(dependsOnMethods = {"isAnyChatHere"})
    public void openAnyChat() {
        //chatsScreenPatient.openSomeChat(0);
        //ChatScreenTestsPatient openedChatScreen = chatsScreenPatient.getOneChatScreen();
        //Assert.assertNotNull(openedChatScreen);
    }
}
