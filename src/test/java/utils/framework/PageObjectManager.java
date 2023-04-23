package utils.framework;

import models.ui.modals.RegistrationForm;
import models.ui.pages.Homepage;
import models.ui.pages.Elements;
import models.ui.pages.WebTables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectManager {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public PageObjectManager(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public Homepage getHomepage(){
        return new Homepage(driver, wait);
    }

    public Elements getElements(){
        return new Elements(driver, wait);
    }

    public RegistrationForm getRegistrationForm(){
        return new RegistrationForm(driver, wait);
    }

    public WebTables getWebTables(){
        return new WebTables(driver, wait);
    }
}