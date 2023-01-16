@login
Feature: Verifying Adactin Hotel Login details

  Scenario Outline: Verifying Adactin Hotel Login valid
    Given User is on the adactin page
    When User should perform Login "<Username>" and "<password>"
    Then User should verify after Login success message "Hello Naveenaso!"

    Examples: 
      | Username  | password     |
      | Naveenaso | Naveenmech1! |

  Scenario Outline: Verifying Adactin Hotel Login using Enter
    Given User is on the adactin page
    When User should perform Login "<Username>" and "<password>" with Enter key
    Then User should verify after Login success message "Hello Naveenaso!"

    Examples: 
      | Username  | password     |
      | Naveenaso | Naveenmech1! |

  Scenario Outline: Verifying Adactin Hotel Login Invalid credential
    Given User is on the adactin page
    When User should perform Login "<Username>" and "<password>"
    Then User should verify after Login with invalid credential error message contains "Invalid Login details or Your Password might have expired"

    Examples: 
      | Username  | password       |
      | Naveenaso | Naveenmech1sd! |
