# Sample Feature with sample UI Scenario:

Feature: Web Elements

    @ui
    @regression
    @smoke
    Scenario Outline: Add Person to the Web Table
      Given I navigate to Web Tables page
      When I enter a new Person with <First Name>, <Last Name>, <Age>, <Email> and <Department> in the Registration Form
      Then New Person is displayed in the Web Table with <First Name>, <Last Name>, <Age>, <Email> and <Department>

      Examples:
        | First Name | Last Name | Age | Email           | Department |
        | Mike       | Smithy    | 43  | smithy@mail.com |  Finance   |

