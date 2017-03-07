package Tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;


class AndroidSetup {
    AndroidDriver driver;
    Properties testProperties = new Properties();
    private String ABSOLUTE_PATH_TO_DOC_APP, DOC_APP_PACKAGE, DOC_APP_ACTIVITY;
    private DesiredCapabilities capabilities;

    public void setUp(String platformName, String platformVersion, String appiumServerURL, String deviceName, String UDID) throws Exception {
        capabilities = new DesiredCapabilities();
        setCapabilities(platformName, platformVersion, deviceName, UDID);
        driver = getAndroidDriver(appiumServerURL);
    }

    public void tearDown() throws Exception {
        driver.quit();
    }

    private void loadPropertiesFromFile() throws IOException {
        String propertiesPath = "D:\\work\\IntellijIDEAProjects\\DocTest\\src\\test\\java\\resources\\test.properties";
        FileInputStream testPropertiesFile = new FileInputStream(propertiesPath);
        testProperties.load(testPropertiesFile);
    }

    private void initBaseProperties() throws IOException {
        loadPropertiesFromFile();
        ABSOLUTE_PATH_TO_DOC_APP = testProperties.getProperty("absolutePathToDocApp");
        DOC_APP_PACKAGE = testProperties.getProperty("docAppPackage");
        DOC_APP_ACTIVITY = testProperties.getProperty("docAppActivity");
    }

    private void setCapabilities(String platformName, String platformVersion, String deviceName, String UDID) throws IOException {
        initBaseProperties();
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("udid", UDID);
        capabilities.setCapability("app", ABSOLUTE_PATH_TO_DOC_APP);
        capabilities.setCapability("appPackage", DOC_APP_PACKAGE);
        capabilities.setCapability("appActivity", DOC_APP_ACTIVITY);
    }

    private AndroidDriver getAndroidDriver(String appiumServerURL) throws MalformedURLException {
        //return new AndroidDriver(new URL("http://" + appiumServerURL), capabilities);
        return new AndroidDriver<MobileElement>(new URL("http://" + appiumServerURL), capabilities);
    }
}
