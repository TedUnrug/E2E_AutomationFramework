package models.ui.pages;

import models.ui.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

// URL: demoqa.com/webtables

public class WebTables extends PageObject {

    @FindBy(id = "addNewRecordButton")
    private WebElement addButton;

    @FindBy(css = ".rt-tbody div[class='rt-tr-group']")
    private List<WebElement> personTableRows;

    public WebTables(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickAddButton(){
        clickElement(addButton);
    }

    public WebElement getPersonByEmailAddress(String expectedEmail){
        return getTableRowByGivenRowCellTextContent(personTableRows, By.cssSelector(".rt-td:nth-of-type(4)"), expectedEmail);
    }

    public List<String> getAllAttributesForGivenPerson(WebElement personTableRow){
        List<String> personAttributes = new ArrayList<>();
        List<WebElement> personTableRowCells = personTableRow.findElements(By.cssSelector(".rt-td"));
        for (int i = 0; i < personTableRowCells.size() -1; i++){
            personAttributes.add(personTableRowCells.get(i).getText());
        }
        return personAttributes;
    }
}