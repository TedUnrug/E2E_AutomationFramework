# Sample Feature with sample API Scenario

Feature: BookStore

    @api
    @regression
    @smoke
    Scenario Outline: Search for a book in the BookStore and verify its Publisher
      Given I GET list of books from the BookStore
      When I find the book <Title> on the list
      Then The book has correct Publisher <Publisher Name>

      Examples:
        | Title            | Publisher Name |
        | Git Pocket Guide | O'Reilly Media |
        | You Don't Know JS| O'Reilly Media |

