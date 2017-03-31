package screens.DocAppScreens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import screens.BaseMethods;

import java.util.List;

public class ChatsScreenDoc extends BaseMethods {
    private List<WebElement> chatsList;

    private By toolbarBy = By.id("com.greitkonsalt.medgreat:id/activity_my_toolbar");
    private By chatsListBy = By.id("ConsultationsListView");

    private By updateFrameBy = By.id("com.greitkonsalt.medgreat:id/action_bar_root"); //com.greitkonsalt.medgreat:id/alertTitle
    private By noUpdateButtonBy = By.id("android:id/button2"); //cancel update

    public ChatsScreenDoc(AndroidDriver driver) {
        super(driver);
        closeAlertIfVisible();
        setElements();
    }

    private void closeAlertIfVisible() {
        waitForVisibilityOf(updateFrameBy, 15);
        if (isElementVisible(updateFrameBy)) {
            driver.findElement(noUpdateButtonBy).click();
        }
        waitForVisibilityOf(toolbarBy, 8);
    }

    private void setElements() {
        chatsList = getListOfElements(chatsListBy);
    }

    public WebElement getSomeChat(int indexOfChat) {
        return chatsList.get(indexOfChat);
    }

    public DocChatScreen getOneChatScreen() {
        DocChatScreen docChatScreen = new DocChatScreen(driver);
        waitForVisibilityOf(docChatScreen.slidingTabs, 20);
        return docChatScreen;
    }

    public void openSomeChat(int indexOfChat) {
        getSomeChat(indexOfChat).click();
    }


}
