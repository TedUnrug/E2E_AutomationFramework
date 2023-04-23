package models.ui.pages;

import models.ui.PageObject;
import models.ui.components.ElementsItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

// URL: demoqa.com/elements

public class Elements extends PageObject {

    @FindBy(css = ".element-list.collapse.show li")
    private List<WebElement> elementItems;

    public Elements(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void clickElementsItem(ElementsItem elementsItem){
        switch (elementsItem){
            case TEXT_BOX -> {
                clickElementOnListByMatchingText(elementItems, "Text Box");
            }
            case CHECKBOX -> {
                clickElementOnListByMatchingText(elementItems, "Check Box");
            }
            case RADIO_BUTTON -> {
                clickElementOnListByMatchingText(elementItems, "Radio Button");
            }
            case WEB_TABLES -> {
                clickElementOnListByMatchingText(elementItems, "Web Tables");
            }
            case BUTTONS -> {
                clickElementOnListByMatchingText(elementItems, "Buttons");
            }
            case LINKS -> {
                clickElementOnListByMatchingText(elementItems, "Links");
            }
            case BROKEN_LINKS -> {
                clickElementOnListByMatchingText(elementItems, "Broken Links - Images");
            }
            case UPLOAD_DOWNLOAD -> {
                clickElementOnListByMatchingText(elementItems, "Upload and Download");
            }
            case DYNAMIC_PROPERTIES -> {
                clickElementOnListByMatchingText(elementItems, "Dynamic Properties");
            }
        }
    }
}
