package pages.DocAppScreens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BaseMethods;

import java.util.List;

public class ChatsScreen extends BaseMethods {
    private List<WebElement> chatsList;
    private WebElement toolbar;

    private By toolbarBy = By.id("com.greitkonsalt.medgreat:id/activity_my_toolbar");
    private By chatsListBy = By.id("ConsultationsListView");

    public ChatsScreen(AndroidDriver driver) {
        super(driver);
        waitForVisibilityOf(toolbarBy, 20);
        setAllElements();
    }

    private void setAllElements() {
        chatsList = getListOfElements(chatsListBy);
        toolbar = getElement(toolbarBy);
    }

    public boolean isChatsPageVisible() {
        return toolbar.isDisplayed();
    }

    public WebElement getSomeChat(int indexOfChat) {
        return chatsList.get(indexOfChat);
      /*  for(WebElement chat : chatsList) {
            return
        }*/
    }

    public void openSomeChat(int indexOfChat) {
        getSomeChat(indexOfChat).click();
    }

}
