Feature:Advertise

  Scenario Outline:User want to Add an advertisement with a specific category
    Given open My App in lang"<lang>"
    When  click on post an Ad icon in navigation bar in Home screen
    Then  user should be redirected to Post Ad page
    When  click on cheoose categories on Post Ad page
    Then  user should be redirected to Choose Categories Page
    When  click on a specific "<category>" in Choose Categories Screen
    And   click on a specific "<section>" in the "<category>" screen
    Then  user should be redirected to Post Ad page page
    When  click on next button on  Post Ad Screen
    Then  descriptive error message will appear

    Examples:
      | lang | category    | section |
      | en   | Electronics | Audio   |
      | ar   | إلكترونيات  | سماعات  |

