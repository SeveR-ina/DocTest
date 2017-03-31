package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import screens.DocAppScreens.ChatsScreenDoc;
import screens.DocAppScreens.LoginScreenDoc;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;


public class MainSetup {
    private AndroidDriver driver;
    protected Properties testProperties = new Properties();
    private String DOC_PATH, DOC_APP_PACKAGE, DOC_APP_ACTIVITY;
    private String PATIENT_APP_PATH, PATIENT_APP_PACKAGE, PATIENT_APP_ACTIVITY;
    private DesiredCapabilities capabilities;
    protected String CORRECT_LOGIN, CORRECT_PASS;
    private LoginScreenDoc loginScreenDoc;

    private void setDeviceAndOS(String platformName, String platformVersion, String deviceName, String UDID) throws Exception {
        capabilities = new DesiredCapabilities();
        setOSCapabilies(platformName, platformVersion);
        setDeviceCapabilities(deviceName, UDID);
    }

    public void tearDown() throws Exception {
        driver.quit();
    }

    protected LoginScreenDoc openLoginPage(String appName, String platformName, String platformVersion, String appiumServerURL, String deviceName, String UDID) throws Exception {
        initAppsProperties(appName);
        setDeviceAndOS(platformName, platformVersion, deviceName, UDID);
        setAppCapabilities(appName);
        driver = getAndroidDriver(appiumServerURL);
        loginScreenDoc = new LoginScreenDoc(driver);
        CORRECT_LOGIN = testProperties.getProperty("correctLogin");
        CORRECT_PASS = testProperties.getProperty("correctPass");

        return loginScreenDoc;
    }

    protected ChatsScreenDoc correctLogin() {
        Assert.assertTrue(loginScreenDoc.areInputFieldsVisible());
        typeToFieldAndHideKeyboard("login", CORRECT_LOGIN);
        loginScreenDoc.clearFieldAndTypeText("password", CORRECT_PASS);
        loginScreenDoc.pressOkayOnKeyBoard();

        Assert.assertTrue(loginScreenDoc.isElementInvisible(loginScreenDoc.loginFieldBy));// not sure
        return loginScreenDoc.getDocChatsScreen();
    }

    protected void typeToFieldAndHideKeyboard(String field, String text) {
        loginScreenDoc.clearFieldAndTypeText(field, text);
        loginScreenDoc.hideKeyBoard();
    }

    private void loadPropertiesFromFile() throws IOException {
        String propertiesPath = "D:\\work\\IntellijIDEAProjects\\AppiumTests\\src\\test\\java\\resources\\test.properties";
        FileInputStream testPropertiesFile = new FileInputStream(propertiesPath);
        testProperties.load(testPropertiesFile);
    }

    private void initAppsProperties(String appName) throws IOException {
        loadPropertiesFromFile();
        if (appName.equalsIgnoreCase("MedGreat Doctors")) {
            initDocAppProperties();
        } else if (appName.equalsIgnoreCase("MedGreat")) {
            initPatientAppProperties();
        } else if (appName.equalsIgnoreCase("both")) {
            initDocAppProperties();
            initPatientAppProperties();
        } else {
            System.out.println("Входный параметр appName = MedGreat Doctors || Medgreat, если используются оба, исправьте на both");
        }
    }

    private void setOSCapabilies(String platformName, String platformVersion) {
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("platformVersion", platformVersion);
    }

    private void setDeviceCapabilities(String deviceName, String UDID) {
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("udid", UDID);
    }

    private void setAppCapabilities(String appName) {
        if (appName.equalsIgnoreCase("MedGreat Doctors")) {
            capabilities.setCapability("app", DOC_PATH);
            capabilities.setCapability("appPackage", DOC_APP_PACKAGE);
            capabilities.setCapability("appActivity", DOC_APP_ACTIVITY);
        } else if (appName.equalsIgnoreCase("MedGreat")) {
            capabilities.setCapability("app", PATIENT_APP_PATH);
            capabilities.setCapability("appPackage", PATIENT_APP_PACKAGE);
            capabilities.setCapability("appActivity", PATIENT_APP_ACTIVITY);
        } else {
            System.out.println("Входный параметр String appName не равен предложенному");
            System.out.println("Исправьте название приложения: либо MedGreat Doctors либо MedGreat");
        }
    }

    private AndroidDriver getAndroidDriver(String appiumServerURL) throws MalformedURLException {
        return new AndroidDriver<MobileElement>(new URL("http://" + appiumServerURL), capabilities);
    }

    private void initDocAppProperties() {
        DOC_PATH = testProperties.getProperty("pathToDocApp");
        DOC_APP_PACKAGE = testProperties.getProperty("docAppPackage");
        DOC_APP_ACTIVITY = testProperties.getProperty("docAppActivity");
    }

    private void initPatientAppProperties() {
        PATIENT_APP_PATH = testProperties.getProperty("pathToPatientApp");
        PATIENT_APP_PACKAGE = testProperties.getProperty("patientAppPackage");
        PATIENT_APP_ACTIVITY = testProperties.getProperty("patientAppActivity");
    }
}
