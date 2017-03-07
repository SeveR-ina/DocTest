package pages;

import io.appium.java_client.AppiumDriver;

public class ChatsPage extends BasePage {

    /*
        @AndroidFindBy(id = "ConsultationsListView")
        private WebElement consultationsList;

        private By consultationsListBy = By.id("ConsultationsListView");


       public boolean isChatsPageVisible() {
            waitForVisibilityOf(consultationsListBy, 20);
            return consultationsList.isDisplayed();
        }*/
    public ChatsPage(AppiumDriver driver) {
        super(driver);
    }
}
