package screens.PatientScreens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import screens.BaseMethods;

public class ChatScreenPatient extends BaseMethods {
    //WebElement toolbar;
    //By slidingTabs = By.id("com.greitkonsalt.medgreat:id/sliding_tabs"); //tabs in chat (chat/info/etc)
    By toolbarBy = By.id("com.greitkonsalt.medgreat:id/activity_my_toolbar");

    public ChatScreenPatient(AndroidDriver driver) {
        super(driver);
        waitForVisibilityOf(toolbarBy, 20);
        setLoginElements();
    }
/*
    private void setChatElements() {
        toolbar = getElement(toolbarBy);
    }*/

}
