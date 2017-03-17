package pages.DocAppScreens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import pages.BaseMethods;

public class OneChatScreen extends BaseMethods {

    By slidingTabs = By.id("com.greitkonsalt.medgreat:id/sliding_tabs"); //tabs in chat (chat/info/etc)

    OneChatScreen(AndroidDriver driver) {
        super(driver);
        By toolbarBy = By.id("com.greitkonsalt.medgreat:id/activity_my_toolbar");
        waitForVisibilityOf(toolbarBy, 20);
        setAllElements();
    }

    private void setAllElements() {
        //toolbar = getElement(toolbarBy);
    }


}
