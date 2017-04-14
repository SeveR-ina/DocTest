package screens.PatientScreens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import screens.BaseMethods;

public class MainScreenPatient extends BaseMethods {
    private WebElement doctorRatingsButton, askDoctorButton;

    private By toolbarBy = By.id("com.greitkonsalt.medgreatpacient:id/activity_my_toolbar");
    private By doctorRatingsButtonBy = By.id("GoGeneralListButton");
    private By askDoctorButtonBy = By.id("GoFilterButton");

    private By updateFrameBy = By.id("com.greitkonsalt.medgreatpacient:id/action_bar_root"); //com.greitkonsalt.medgreat:id/alertTitle
    private By noUpdateButtonBy = By.id("android:id/button2");

    public MainScreenPatient(AndroidDriver driver) {
        super(driver);
        closeAlertIfVisible();
        setMainScreenElements();
    }

    private void setMainScreenElements() {
        doctorRatingsButton = getElement(doctorRatingsButtonBy);
        askDoctorButton = getElement(askDoctorButtonBy);
    }
    public void pressAskDoctorsButton(){
        askDoctorButton.click();
    }

    private void closeAlertIfVisible() {
        waitForVisibilityOf(updateFrameBy, 15);
        if (isElementVisible(updateFrameBy)) {
            driver.findElement(noUpdateButtonBy).click();
        }
        waitForVisibilityOf(toolbarBy, 8);
    }


}
