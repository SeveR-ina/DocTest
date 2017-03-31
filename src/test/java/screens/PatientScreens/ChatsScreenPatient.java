package screens.PatientScreens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import screens.BaseMethods;

import java.util.List;

public class ChatsScreenPatient extends BaseMethods {
    private List<WebElement> chatsList;

    public By toolbarBy = By.id("com.greitkonsalt.medgreat:id/activity_my_toolbar");
    //private By chatsListBy = By.id("ConsultationsListView");

    public ChatsScreenPatient(AndroidDriver driver) {
        super(driver);
        waitForVisibilityOf(toolbarBy, 30);
        //setElements();
    }

}
