package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    public WebDriver driver;

    public WebDriver WebDriverManager() throws IOException
    {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//global.properties");
        Properties prop = new Properties();
        prop.load(fis);

        String url = prop.getProperty("QAUrl");
        String browser_props = prop.getProperty("browser");
        String browser_commandLine = System.getProperty("browser");   //to check the browser value entered in maven cmd line

        String browser = browser_commandLine!=null ? browser_commandLine : browser_props;   //command line browser value is the priority, if it's null - the browser value in properties file will be taken.

        if (driver == null) {
            if (browser.equalsIgnoreCase("Chrome"))
            {
//                System.setProperty(System.getProperty("user.dir"),"//src//test//resources//chromedriver");  //Just a Placeholder, might not be needed in latest Selenium version
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("Firefox"))
            {
//                System.setProperty(System.getProperty("user.dir"),"//src//test//resources//geckodriver");   // Placeholder
                driver = new FirefoxDriver();
            }

            assert driver != null;
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
            driver.get(url);
        }

        return driver;

    }
}
