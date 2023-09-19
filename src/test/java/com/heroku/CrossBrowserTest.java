package com.heroku;
import dataProvider.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.net.MalformedURLException;
import java.net.URL;
public class CrossBrowserTest extends ConfigReader {

    protected static WebDriver driver;
    protected static String platform = System.getProperty("platform");
    protected static String browser = System.getProperty("browser");
    protected static String operatingSystem = System.getProperty("operatingSystem");
    protected static String  version = System.getProperty("version");
    protected URL url;
@BeforeSuite
    public void browserSetup () {
        if (platform.equalsIgnoreCase("local")) {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
            } else if (browser.equalsIgnoreCase("firefox") ) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        } else {
            System.out.println("Browser is not supported");
            return;
        }
        driver.get(getBaseUrl());
    }

    public void afterSuite() {
        System.out.println("Closing driver is successful");
        driver.quit();
    }
}
