package scenarios;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class AndroidSetup {
    protected AndroidDriver driver;

    protected void prepareAndroidForAppium() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.4.16");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("deviceName", "Nexus");
        String absolutePath = "D:\\work\\IntellijIDEAProjects\\DocTest\\apps\\MedGreat Doctors_v2.0.5.apk";
        capabilities.setCapability("app", absolutePath);
        capabilities.setCapability("appPackage", "com.greitkonsalt.medgreat");
        capabilities.setCapability("appActivity", "md52a2818ca98838453339ce3d8b836c7ca.MainActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}
