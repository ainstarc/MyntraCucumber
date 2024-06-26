Feature: Myntra Item Order

  Scenario: Ordering a item in Myntra
    Given User is in Myntra Site
    When User searches "<item>"
    Then User gets searched items result
    When User selects a "<brand>"
    Then User gets results of item
    When User clicks on item and switch to item tab
    And select "<size>"
    And add to bag
    And move to bag
    Then bag opens with added item
    When User place order
    Then login page appears
    
    
    Examples:
    | item | brand | size |
    | shirts men | arrow | L42 |
    | shirts men | peter england | M40 |
    | shirts men | arrow | S39 |

