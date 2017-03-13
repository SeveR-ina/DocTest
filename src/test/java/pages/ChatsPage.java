package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ChatsPage extends BasePage {
    private List<WebElement> consultationsList;
    private WebElement toolbar;

    private By toolbarBy = By.id("com.greitkonsalt.medgreat:id/activity_my_toolbar");
    private By consultationsListBy = By.id("ConsultationsListView");

    public ChatsPage(AndroidDriver driver) {
        super(driver);
        waitForVisibilityOf(toolbarBy, 20);
        getAllElements();
    }

    private void getAllElements() {
        consultationsList = getListOfElements(consultationsListBy);
        toolbar = getElement(toolbarBy);
    }

    public boolean isChatsPageVisible() {
        return toolbar.isDisplayed();
    }


}
