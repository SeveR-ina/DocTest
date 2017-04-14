package tests;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;

public class AppiumServerStartStop {
    static AppiumDriverLocalService service;
    static String service_url;

    static void appiumStart(int port) throws Exception {
        setService(port);
        service.start();
        Thread.sleep(25000);
        service_url = service.getUrl().toString();
    }

    private static void setService(int port) throws Exception {
        String appium_Node_Path = "C:\\Program Files (x86)\\Appium\\node.exe";
        String appium_JS_Path = "C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js";
        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().
                usingPort(port).usingDriverExecutable(new File(appium_Node_Path)).
                withAppiumJS(new File(appium_JS_Path)));
    }

    static void appiumStop(int port) throws Exception {
        setService(port);
        service.stop();
        Thread.sleep(25000);
        service_url = service.getUrl().toString();
    }
}
