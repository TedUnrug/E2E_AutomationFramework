package steps;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.contexts.TestContext;
import utils.framework.WebDriverSetup;

public class Hooks {

    private WebDriver driver;
    private WebDriverWait wait;

    TestContext testContext;
    WebDriverSetup webDriverSetup;

    public Hooks(TestContext testContext){
        this.testContext = testContext;
    }

    @BeforeAll
    public static void beforeAll(){
        // Test Suite setup activities, e.g.: connection to database, test data generation, access token acquisition, etc.
    }

    @Before ("@ui")
    public void setUpUiTest(){
        webDriverSetup = testContext.getWebDriverSetup();
        driver = webDriverSetup.getDriver();
        wait = webDriverSetup.getWait();
        driver.manage().window().maximize();
        driver.get(System.getProperty("env"));
        wait.until(ExpectedConditions.urlContains(System.getProperty("env")));
    }

    @Before ("@api")
    public void setUpApiTest(){

    }

    @After ("@ui")
    public void tearDownUiTest(Scenario scenario){
        if (scenario.isFailed()){
            final byte[] failureScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(failureScreenshot, "image/png", scenario.getName());
        }
        driver.quit();
    }

    @After ("@api")
    public void tearDownApiTest(){

    }

    @AfterAll
    public static void afterAll(){
        // Test Suite closure activities
    }
}