package screens.PatientScreens;

import io.appium.java_client.android.AndroidDriver;
import screens.BaseMethods;

public class MainScreen extends BaseMethods {

    public MainScreen(AndroidDriver driver) {
        super(driver);
        //waitForVisibilityOf(loginFieldBy, 20);
        setLoginElements();
    }

    private void setMainScreenElements() {
        //By passwordFieldBy = By.id("PasswordEntry");
        //passwordField = getElement(passwordFieldBy);
    }

}
