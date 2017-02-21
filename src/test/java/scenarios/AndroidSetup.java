package scenarios;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;


class AndroidSetup {
    AndroidDriver driver;
    Properties testProperties = new Properties();
    private String APPIUM_VERSION, PLATFORM_NAME, PLATFORM_VERSION, DEVICE_NAME, ABSOLUTE_PATH_TO_DOC_APP, DOC_APP_PACKAGE, DOC_APP_ACTIVITY, ANDROID_DRIVER_URL;

    void loadPropertiesFromFile() throws IOException{
        String propertiesPath = "D:\\work\\IntellijIDEAProjects\\DocTest\\src\\test\\java\\resources\\test.properties";
        FileInputStream testPropertiesFile = new FileInputStream(propertiesPath);
        testProperties.load(testPropertiesFile);
    }

    private void getBaseProperties() throws IOException {
        loadPropertiesFromFile();
        APPIUM_VERSION = testProperties.getProperty("appium-version");
        PLATFORM_NAME = testProperties.getProperty("platformName");
        PLATFORM_VERSION = testProperties.getProperty("platformVersion");
        DEVICE_NAME = testProperties.getProperty("deviceName");
        ABSOLUTE_PATH_TO_DOC_APP = testProperties.getProperty("absolutePathToDocApp");
        DOC_APP_PACKAGE = testProperties.getProperty("docAppPackage");
        DOC_APP_ACTIVITY = testProperties.getProperty("docAppActivity");
        ANDROID_DRIVER_URL = testProperties.getProperty("androidDriverUrl");
    }

    void prepareAndroidForAppium() throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        getBaseProperties();
        capabilities.setCapability("appium-version", APPIUM_VERSION);
        capabilities.setCapability("platformName", PLATFORM_NAME);
        capabilities.setCapability("platformVersion", PLATFORM_VERSION);
        capabilities.setCapability("deviceName", DEVICE_NAME);
        capabilities.setCapability("app", ABSOLUTE_PATH_TO_DOC_APP);
        capabilities.setCapability("docAppPackage", DOC_APP_PACKAGE);
        capabilities.setCapability("docAppActivity", DOC_APP_ACTIVITY);
        driver = new AndroidDriver(new URL(ANDROID_DRIVER_URL), capabilities);
    }
}
