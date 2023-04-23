package models.ui.pages;

import models.ui.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

// URL: demoqa.com

public class Homepage extends PageObject {

    @FindBy(css = ".category-cards>div:nth-of-type(1)")
    private WebElement elementsCard;


    public Homepage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickElementsCard(){
        clickElement(elementsCard);
    }
}