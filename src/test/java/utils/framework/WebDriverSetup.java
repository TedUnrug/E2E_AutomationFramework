package utils.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverSetup {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public WebDriverSetup(){
        final String driverTimeoutSeconds = "driver.timeout.seconds";

        // Browser selection:
        final String browser = System.getProperty("browser");
        switch(Browser.valueOf(browser.toUpperCase())){
            case CHROME -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");

                driver = new ChromeDriver(chromeOptions);
                wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(System.getProperty(driverTimeoutSeconds))));
            }
            case FIREFOX -> {
                driver = new FirefoxDriver();
                wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(System.getProperty(driverTimeoutSeconds))));
            }
            default -> throw new RuntimeException("Browser was not specified or not supported by the Test Automation Framework.");
        }
    }

    public WebDriver getDriver(){
        return driver;
    }

    public WebDriverWait getWait(){
        return wait;
    }
}