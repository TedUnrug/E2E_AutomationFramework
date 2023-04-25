package steps.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.api.models.resources.bookstore.BookStoreResources;
import models.api.models.resources.bookstore.responses.Book;
import models.api.models.resources.bookstore.responses.Books;
import utils.contexts.ContextTestData;
import utils.contexts.ScenarioContext;
import utils.contexts.TestContext;
import utils.framework.EndpointManager;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class BookStoreSteps {

    BookStoreResources bookStoreResources;

    EndpointManager endpointManager;
    Response response;
    ScenarioContext scenarioContext;
    TestContext testContext;

    public BookStoreSteps(TestContext testContext){
        this.testContext = testContext;
        endpointManager = testContext.getEndpointManager();
        scenarioContext = testContext.getScenarioContext();

        bookStoreResources = endpointManager.getBookStoreResources();
    }

    @Given("I GET list of books from the BookStore")
    public void getListOfBooksFromBookStore(){
        response = bookStoreResources.getBooks();
    }

    @When("^I find the book (.+) on the list")
    public void findBookOnListByTitle(String bookTitle){
        Books booksResponse = response.getBody().as(Books.class);
        booksResponse.books().stream()
                .filter(book -> book.title().equals(bookTitle))
                .findFirst()
                .ifPresentOrElse(book -> scenarioContext.setScenarioContext(ContextTestData.BOOK, book),
                        ()-> {throw new RuntimeException("There was no book with matching title.");});
    }

    // VERIFICATION STEPS:

    @Then("^The book has correct Publisher (.+)")
    public void verifyBookHasExpectedPublisher(String publisherName){
        Book book = (Book) scenarioContext.getScenarioContextByKey(ContextTestData.BOOK);
        assertThat(book.publisher(), is(equalTo(publisherName)));
    }
}