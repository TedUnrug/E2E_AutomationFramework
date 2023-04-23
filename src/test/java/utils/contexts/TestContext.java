package utils.contexts;

import org.openqa.selenium.SessionNotCreatedException;
import utils.framework.EndpointManager;
import utils.framework.PageObjectManager;
import utils.framework.WebDriverSetup;

public class TestContext {

    private EndpointManager endpointManager;
    private PageObjectManager pageObjectManager;
    private final ScenarioContext scenarioContext;
    private WebDriverSetup webDriverSetup;

    public TestContext(){
        final String cucumberFilterTags = System.getProperty("cucumber.filter.tags");
        final String testLayer = cucumberFilterTags.substring(cucumberFilterTags.lastIndexOf("@"));

        scenarioContext = new ScenarioContext();
        switch (testLayer){
            case "@ui" -> {
                try {
                    webDriverSetup = new WebDriverSetup();
                }
                catch (SessionNotCreatedException exception){
                    webDriverSetup = new WebDriverSetup();
                }
                pageObjectManager = new PageObjectManager(webDriverSetup.getDriver(), webDriverSetup.getWait());
            }
            case "@api" -> {
                endpointManager = new EndpointManager(System.getProperty("env"), "method_to_get_access_token_placeholder");
            }
            default -> throw new RuntimeException("Testing layer (UI or API) was not specified correctly.");
        }
    }

    public EndpointManager getEndpointManager(){
        return endpointManager;
    }

    public PageObjectManager getPageObjectManager(){
        return pageObjectManager;
    }

    public ScenarioContext getScenarioContext(){
        return scenarioContext;
    }

    public WebDriverSetup getWebDriverSetup(){
        return webDriverSetup;
    }
}