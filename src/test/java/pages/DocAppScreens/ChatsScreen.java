package pages.DocAppScreens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BaseMethods;

import java.util.List;

public class ChatsScreen extends BaseMethods {
    private List<WebElement> chatsList;

    By toolbarBy = By.id("com.greitkonsalt.medgreat:id/activity_my_toolbar");
    private By chatsListBy = By.id("ConsultationsListView");

    ChatsScreen(AndroidDriver driver) {
        super(driver);
        waitForVisibilityOf(toolbarBy, 30);
        setAllElements();
    }

    private void setAllElements() {
        chatsList = getListOfElements(chatsListBy);
        //WebElement toolbar = getElement(toolbarBy);
    }

    public WebElement getSomeChat(int indexOfChat) {
        return chatsList.get(indexOfChat);
        /*  for(WebElement chat : chatsList) {
            return
        }*/
    }

    public OneChatScreen getOneChatScreen() {
        OneChatScreen oneChatScreen = new OneChatScreen(driver);
        waitForVisibilityOf(oneChatScreen.slidingTabs, 20);
        return oneChatScreen;
    }

    public void openSomeChat(int indexOfChat) {
        getSomeChat(indexOfChat).click();
    }

}
