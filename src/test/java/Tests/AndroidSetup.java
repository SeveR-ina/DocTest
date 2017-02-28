package Tests;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.LoginPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;


class AndroidSetup {
    private AndroidDriver driver;
    Properties testProperties = new Properties();
    private String ABSOLUTE_PATH_TO_DOC_APP, DOC_APP_PACKAGE, DOC_APP_ACTIVITY;
    LoginPage loginPage;

    public void setUp(String platformName, String platformVersion, String appiumServerURL, String deviceName, String UDID) throws Exception {
        prepareAndroidForAppium(platformName, platformVersion, appiumServerURL, deviceName, UDID);
        loadPropertiesFromFile();
        loginPage = new LoginPage(driver);
    }

    public void tearDown() throws Exception {
        driver.quit();
    }

    private void loadPropertiesFromFile() throws IOException{
        String propertiesPath = "D:\\work\\IntellijIDEAProjects\\DocTest\\src\\test\\java\\resources\\test.properties";
        FileInputStream testPropertiesFile = new FileInputStream(propertiesPath);
        testProperties.load(testPropertiesFile);
    }

    private void getBaseProperties() throws IOException {
        loadPropertiesFromFile();
        ABSOLUTE_PATH_TO_DOC_APP = testProperties.getProperty("absolutePathToDocApp");
        DOC_APP_PACKAGE = testProperties.getProperty("docAppPackage");
        DOC_APP_ACTIVITY = testProperties.getProperty("docAppActivity");
    }

    private void prepareAndroidForAppium(String platformName, String platformVersion, String appiumServerURL, String deviceName, String UDID) throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        getBaseProperties();
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("udid", UDID);
        capabilities.setCapability("app", ABSOLUTE_PATH_TO_DOC_APP);
        capabilities.setCapability("appPackage", DOC_APP_PACKAGE);
        capabilities.setCapability("appActivity", DOC_APP_ACTIVITY);
        driver = new AndroidDriver(new URL("http://"+appiumServerURL), capabilities);
    }
}
