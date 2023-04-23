package steps.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.ui.components.ElementsItem;
import models.ui.modals.RegistrationForm;
import models.ui.pages.Elements;
import models.ui.pages.Homepage;
import models.ui.pages.WebTables;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import utils.contexts.Context;
import utils.contexts.ScenarioContext;
import utils.contexts.TestContext;
import utils.framework.PageObjectManager;

import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class DemoQaSteps {

    Elements elements;
    Homepage homepage;
    RegistrationForm registrationForm;
    WebTables webTables;

    PageObjectManager pageObjectManager;
    ScenarioContext scenarioContext;
    TestContext testContext;

    public DemoQaSteps(TestContext testContext){
        this.testContext = testContext;
        pageObjectManager = testContext.getPageObjectManager();
        scenarioContext = testContext.getScenarioContext();

        elements = pageObjectManager.getElements();
        homepage = pageObjectManager.getHomepage();
        registrationForm = pageObjectManager.getRegistrationForm();
        webTables = pageObjectManager.getWebTables();
    }

    @Given("I navigate to Web Tables page")
    public void navigateToWebTablesPage(){
        homepage.clickElementsCard();
        elements.clickElementsItem(ElementsItem.WEB_TABLES);
    }

    @When("^I enter a new Person with (.+), (.+), (.+), (.+) and (.+) in the Registration Form")
    public void enterNewPersonInRegistrationForm(String firstName, String lastName, String age, String eMail, String department){
        // Step test data generated on the run:
        final String salary = RandomStringUtils.randomNumeric(4);
        scenarioContext.setScenarioContext(Context.SALARY, salary);

        // Instructions:
        webTables.clickAddButton();

        registrationForm.enterFirstName(firstName)
                .enterLastName(lastName)
                .enterEmail(eMail)
                .enterAge(age)
                .enterSalary(salary)
                .enterDepartment(department)
                .clickSubmitButton();
    }

    // VERIFICATION STEPS:
    @Then("^New Person is displayed in the Web Table with (.+), (.+), (.+), (.+) and (.+)")
    public void personIsDisplayedInWebTable(String expectedFirstName, String expectedLastName, String expectedAge, String expectedEmail, String expectedDepartment){
        String expectedSalary = (String) scenarioContext.getScenarioContextByKey(Context.SALARY);

        WebElement personTableRow = webTables.getPersonByEmailAddress(expectedEmail);
        List<String> actualPersonAttributes = webTables.getAllAttributesForGivenPerson(personTableRow);
        List<String> expectedPersonAttributes = List.of(expectedFirstName, expectedLastName, expectedAge, expectedEmail, expectedSalary, expectedDepartment);

        assertThat(actualPersonAttributes, is(equalTo(expectedPersonAttributes)));
    }
}