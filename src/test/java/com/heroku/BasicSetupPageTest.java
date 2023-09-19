package com.heroku;
import dataProvider.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.net.URL;

public class BasicSetupPageTest extends ConfigReader {

    protected static WebDriver driver;
    String platform = System.getProperty("platform");
    String browser = System.getProperty("browser");
    String osOption = System.getProperty("os");
    String version = System.getProperty("version");
    protected URL url;

    @BeforeSuite
    public void browserSetup() {
         if(platform.equalsIgnoreCase("local")) {
             try {
                 if (browser.equalsIgnoreCase("chrome")) {
                     WebDriverManager.chromedriver().setup();
                     driver = new ChromeDriver();
                 } else if (browser.equalsIgnoreCase("firefox")) {
                     WebDriverManager.firefoxdriver().setup();
                     driver = new FirefoxDriver();
                 } else if (browser.equalsIgnoreCase("edge")) {
                     WebDriverManager.edgedriver().setup();
                     driver = new EdgeDriver();
                 } else {
                    System.out.println("The Browser type is Undefined");
                }
             driver.manage().window().maximize();
             driver.get("https://the-internet.herokuapp.com/");
         } catch (NullPointerException e) {
                 throw new RuntimeException(e);
             } catch (Exception e) {
                 System.out.println(e.getMessage());
             }
        } else if (platform.equalsIgnoreCase("sauceLab")) {
             System.out.println("ToDo: Implement cloud execution logic.");
        }
    }

    @AfterSuite
    public void closeBrowser() {
        driver.quit();
    }
}

