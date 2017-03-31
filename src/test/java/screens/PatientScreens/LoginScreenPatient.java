package screens.PatientScreens;

import io.appium.java_client.android.AndroidDriver;
import screens.BaseMethods;

public class LoginScreenPatient extends BaseMethods {


    public LoginScreenPatient(AndroidDriver driver) {
        super(driver);
        //waitForVisibilityOf(loginFieldBy, 20);
        setLoginElements();
    }



}
