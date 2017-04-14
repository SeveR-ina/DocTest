package tests.DocTests;

import org.testng.Assert;
import screens.DocAppScreens.ChatListScreenDoc;
import screens.DocAppScreens.LoginScreenDoc;
import tests.MainSetup;

class BaseDocMethods extends MainSetup {

    LoginScreenDoc loginScreenDoc;

    LoginScreenDoc openDocLoginScreen() throws Exception {
        loginScreenDoc = new LoginScreenDoc(driver);
        CORRECT_LOGIN = testProperties.getProperty("correctDocLogin");
        CORRECT_PASS = testProperties.getProperty("correctDocPass");
        return loginScreenDoc;
    }

    ChatListScreenDoc correctLoginInDocApp() {
        Assert.assertTrue(loginScreenDoc.areInputFieldsVisible());
        typeToFieldAndHideKeyboard("login", CORRECT_LOGIN);
        loginScreenDoc.clearFieldAndTypeText("password", CORRECT_PASS);
        loginScreenDoc.pressOkayOnKeyBoard();

        Assert.assertTrue(loginScreenDoc.isElementInvisible(loginScreenDoc.loginFieldBy));// not sure
        ChatListScreenDoc chatListScreenDoc = new ChatListScreenDoc(driver);
        Assert.assertNotNull(chatListScreenDoc);
        return chatListScreenDoc;
    }

    void typeToFieldAndHideKeyboard(String field, String text) {
        loginScreenDoc.clearFieldAndTypeText(field, text);
        loginScreenDoc.hideKeyBoard();
    }
}
