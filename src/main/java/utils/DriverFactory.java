package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private static AndroidDriver driver;

    public DriverFactory() {
        try {
            setUp();
        } catch (Exception e) {

        }
    }

    @BeforeMethod(alwaysRun = true)
    public synchronized void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Lenovo Vibe P1");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app","/Users/Nishant/Development/Office/Kwik-POC/src/main/resources/KWIK24.apk");
        capabilities.setCapability("appPackage","com.app.kwik1");
        capabilities.setCapability("appActivity","com.app.kwik.ui.login.WelcomeActivity");
        capabilities.setCapability("automationName","UiAutomator2");
//        capabilities.setCapability("autoGrantPermissions", "true");

        try {
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        new AppiumServer().stop();
    }

    public AndroidDriver getDriver() {
        return driver;
    }
}