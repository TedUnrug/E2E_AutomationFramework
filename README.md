# E2E_AutomationFramework

## GENERAL ##

1. This is test automation project for functional UI and API tests.

## TEST SUITES AND TEST SCENARIOS ##

1. Test Scenarios are located in .feature files under src/test/resources/features
2. Test Suites are built by adding appropriate tag above Scenario Outline, e.g. "@regression"
3. Test Layer must be specified by adding appropriate tag above Scenario Outline, each Scenario is either "@api" or "@ui"
4. Test Suites are run by choosing run configuration file (under src/test/resources/runConfigurations) or passing maven command, e.g. mvn test -D"cucumber.filter.tags=@regression and @ui" -Dbrowser="chrome"

## TEST REPORT ##

1. After each test run, the html Extent Report is generated under target/extent-reports/HTML_20Report
