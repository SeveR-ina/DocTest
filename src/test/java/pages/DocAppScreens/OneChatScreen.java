package pages.DocAppScreens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BaseMethods;

import java.util.List;

public class OneChatScreen extends BaseMethods {
    private List<WebElement> chatsList;
    private WebElement toolbar;

    private By toolbarBy = By.id("com.greitkonsalt.medgreat:id/activity_my_toolbar");

    public OneChatScreen(AndroidDriver driver) {
        super(driver);
        waitForVisibilityOf(toolbarBy, 20);
    }

    private void setAllElements(){
        toolbar = getElement(toolbarBy);
    }

    public boolean isChatOpened(){
        boolean isChatOpened = false;
        if (!toolbar.getText().contentEquals("ответы")){
            isChatOpened = true;
        }
        return isChatOpened;
    }
}
