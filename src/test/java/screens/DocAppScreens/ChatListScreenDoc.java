package screens.DocAppScreens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import screens.BaseMethods;

import java.util.List;

public class ChatListScreenDoc extends BaseMethods {
    private List<WebElement> chatsList;

    private By toolbarBy = By.id("com.greitkonsalt.medgreat:id/activity_my_toolbar");
    private By chatsListBy = By.id("ConsultationsListView");

    private By updateFrameBy = By.id("com.greitkonsalt.medgreat:id/alertTitle"); //com.greitkonsalt.medgreat:id/action_bar_root
    private By noUpdateButtonBy = By.id("android:id/button2"); //cancel update

    public ChatListScreenDoc(AndroidDriver driver) {
        super(driver);
        closeAlertIfVisible();
        setChatListDocElements();
    }

    private void closeAlertIfVisible() {
        if (isElementVisible(updateFrameBy)) {
            WebElement noUpdateButton = driver.findElement(noUpdateButtonBy);
            noUpdateButton.click();
        }
        waitForVisibilityOf(toolbarBy, 15);
    }

    private void setChatListDocElements() {
        chatsList = getListOfElements(chatsListBy);
    }

    public WebElement getSomeChat(int indexOfChat) {
        return chatsList.get(indexOfChat);
    }

    public ChatScreenDoc getOneChatScreen() {
        ChatScreenDoc chatScreenDoc = new ChatScreenDoc(driver);
        waitForVisibilityOf(chatScreenDoc.slidingTabs, 20);
        return chatScreenDoc;
    }

    public void openSomeChat(int indexOfChat) {
        getSomeChat(indexOfChat).click();
    }


}
