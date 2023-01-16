@SearchHotel
Feature: Verifying Adactin Hotel Search details

  Scenario Outline: Verifying Adactin Hotel Search details by using select all fields
    Given User is on the adactin page
    When User should perform Login "<Username>" and "<password>"
    Then User should verify after Login success message "Hello Naveenaso!"
    And User should perform search hotel by using all selected fields "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultPerRoom>" and "<childPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"

    Examples: 
      | Username  | password     | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultPerRoom | childPerRoom |
      | naveenaso | Naveenmech1! | London   | Hotel Sunshine | Standard | 5 - Five  | 25/11/2022  | 26/11/2022   | 2 - Two      | 2 - Two      |

  Scenario Outline: Verifying Adactin Hotel Search details by using mandatory fields
    Given User is on the adactin page
    When User should perform Login "<Username>" and "<password>"
    Then User should verify after Login success message "Hello Naveenaso!"
    And User should perform search hotel by using mandatory fields "<location>","<noOfRooms>","<checkInDate>","<checkOutDate>" and "<adultPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"

    Examples: 
      | Username  | password     | location | noOfRooms | checkInDate | checkOutDate | adultPerRoom |
      | naveenaso | Naveenmech1! | London   | 5 - Five  | 25/11/2022  | 26/11/2022   | 2 - Two      |

  Scenario Outline: Verifying Adactin Hotel Search details by Invalid Date checking
    Given User is on the adactin page
    When User should perform Login "<Username>" and "<password>"
    Then User should verify after Login success message "Hello Naveenaso!"
    And User should perform search hotel by using date checking "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultPerRoom>" and "<childPerRoom>"
    Then User should verify after search hotel error message with "Check-In Date shall be before than Check-Out Date","Check-Out Date shall be after than Check-In Date"

    Examples: 
      | Username  | password     | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultPerRoom | childPerRoom |
      | naveenaso | Naveenmech1! | London   | Hotel Sunshine | Standard | 5 - Five  | 25/11/2022  | 24/11/2022   | 2 - Two      | 2 - Two      |

  Scenario Outline: Verifying Adactin Hotel Search details by without entry any fields
    Given User is on the adactin page
    When User should perform Login "<Username>" and "<password>"
    Then User should verify after Login success message "Hello Naveenaso!"
    And User should perform search hotel by without entry any fields
    Then User should verify after search hotel error message "Please Select a Location"

    Examples: 
      | Username  | password     |
      | Naveenaso | Naveenmech1! |
