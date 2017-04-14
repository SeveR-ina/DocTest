package tests.PatientTests;

import org.testng.Assert;
import screens.PatientScreens.ChatListScreenPatient;
import screens.PatientScreens.LoginScreenPatient;
import screens.PatientScreens.MainScreenPatient;
import tests.AppiumServerStartStop;
import tests.MainSetup;

class BasePatientMethods extends MainSetup {

    private LoginScreenPatient loginScreenPatient;
    MainScreenPatient mainScreenPatient;

    MainScreenPatient openMainScreen() throws Exception {
        mainScreenPatient = new MainScreenPatient(driver);
        return mainScreenPatient;
    }

    LoginScreenPatient openPatientLoginScreen() throws Exception {
        loginScreenPatient = new LoginScreenPatient(driver);
        CORRECT_LOGIN = testProperties.getProperty("correctPatientLogin");
        CORRECT_PASS = testProperties.getProperty("correctPatientPass");

        return loginScreenPatient;
    }

    ChatListScreenPatient correctLoginInPatientApp() {
        Assert.assertTrue(loginScreenPatient.areInputFieldsVisible());
        typeToFieldAndHideKeyboard("login", CORRECT_LOGIN);
        loginScreenPatient.clearFieldAndTypeText("password", CORRECT_PASS);
        loginScreenPatient.pressOkayOnKeyBoard();

        Assert.assertTrue(loginScreenPatient.isElementInvisible(loginScreenPatient.loginFieldBy));// not sure
        return loginScreenPatient.getPatientChatsScreen();
    }

    void typeToFieldAndHideKeyboard(String field, String text) {
        loginScreenPatient.clearFieldAndTypeText(field, text);
        loginScreenPatient.hideKeyBoard();
    }
}
