Feature: Test  Amazon web web page
  This feature will deal with amazon web page

  Scenario: Verify Amazon product search contains text Nikon D3X
    Given I navigate to  "http://www.amazon.com"
    And I search for the item "Nikon"
    And I sort the results from highest to lowest price
    When I selected and clicked the second product displayed
    Then I verify that product topic contains text "Nikon D4S"