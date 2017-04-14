package screens.DocAppScreens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import screens.BaseMethods;

public class ChatScreenDoc extends BaseMethods {
    private WebElement toolbar;

    By slidingTabs = By.id("com.greitkonsalt.medgreat:id/sliding_tabs"); //tabs in chat (chat/info/etc)
    private By toolbarBy = By.id("com.greitkonsalt.medgreat:id/activity_my_toolbar");

    ChatScreenDoc(AndroidDriver driver) {
        super(driver);
        waitForVisibilityOf(toolbarBy, 20);
        setDocChatElements();
    }

    private void setDocChatElements() {
        toolbar = getElement(toolbarBy);
    }


}
