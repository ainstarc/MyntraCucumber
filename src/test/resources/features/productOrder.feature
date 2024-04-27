Feature: Myntra Item Order

  Scenario: Ordering a item in Myntra
    Given User is in Myntra Site
    When User searches "<item>"
    Then User gets searched items result
    When User selects an "<brand>"
    Then Item details opens in new tab
    When User switches to new tab
    And select "<size>"
    And add to bag
    And move to bag
    Then bag opens with added item
    When User place order
    Then login page appears
    
    
    Examples:
    | item | brand | size |
    | shirts men | peter england | S |

