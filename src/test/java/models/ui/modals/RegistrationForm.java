package models.ui.modals;

import models.ui.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationForm extends PageObject {

    @FindBy(css = ".modal-body #firstName")
    private WebElement firstNameTextBox;

    @FindBy(css = ".modal-body #lastName")
    private WebElement lastNameTextBox;

    @FindBy(css = ".modal-body #userEmail")
    private WebElement eMailTextBox;

    @FindBy(css = ".modal-body #age")
    private WebElement ageTextBox;

    @FindBy(css = ".modal-body #salary")
    private WebElement salaryTextBox;

    @FindBy(css = ".modal-body #department")
    private WebElement departmentTextBox;

    @FindBy(css = ".modal-body #submit")
    private WebElement submitButton;

    public RegistrationForm(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public RegistrationForm enterFirstName(String firstName){
        enterText(firstNameTextBox, firstName);
        return this;
    }

    public RegistrationForm enterLastName(String lastName){
        enterText(lastNameTextBox, lastName);
        return this;
    }

    public RegistrationForm enterEmail(String email){
        enterText(eMailTextBox, email);
        return this;
    }

    public RegistrationForm enterAge(String age){
        enterText(ageTextBox, age);
        return this;
    }

    public RegistrationForm enterSalary(String salary){
        enterText(salaryTextBox, salary);
        return this;
    }

    public RegistrationForm enterDepartment(String department){
        enterText(departmentTextBox, department);
        return this;
    }

    public void clickSubmitButton(){
        clickElement(submitButton);
    }
}