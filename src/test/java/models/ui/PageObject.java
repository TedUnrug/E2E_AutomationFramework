package models.ui;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PageObject {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public PageObject(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    protected void waitUntilElementsAreVisible(List<WebElement> elementList) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
        } catch (StaleElementReferenceException | ElementNotInteractableException exception){
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(elementList)));
        }
    }

    protected void clickElement(WebElement element){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (StaleElementReferenceException | ElementNotInteractableException exception){
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element))).click();
        }
    }

    protected void clickElementOnListByMatchingText(List<WebElement> elementList, String text){
        waitUntilElementsAreVisible(elementList);
        elementList.stream()
                .filter(element -> element.getText().equals(text))
                .findFirst()
                .ifPresentOrElse(this::clickElement, ()-> {throw new RuntimeException("There is no matching text option on the list.");});
    }

    protected void enterText(WebElement element, String text){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
        } catch (StaleElementReferenceException | ElementNotInteractableException exception){
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element))).sendKeys(text);
        }
    }

    protected WebElement getTableRowByGivenRowCellTextContent(List<WebElement> tableRows, By tableRowCell, String expectedCellContent){
        WebElement tableRowToBeReturned = null;
        waitUntilElementsAreVisible(tableRows);
        for (WebElement tableRow: tableRows) {
            String email = tableRow.findElement(tableRowCell).getText();
            if (email.equals(expectedCellContent)){
                tableRowToBeReturned = tableRow;
                break;
            }
        }
        if (tableRowToBeReturned == null){
            throw new RuntimeException("Cell with expected content was not found in the table.");
        }
        return tableRowToBeReturned;
    }
}