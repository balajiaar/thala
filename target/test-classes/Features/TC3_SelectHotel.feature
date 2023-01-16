@SelectHotel
Feature: Verifying Adactin Hotel Select details

  Scenario Outline: Verifying Adactin Hotel Select details by Select Hotel Name
    Given User is on the adactin page
    When User should perform Login "<Username>" and "<password>"
    Then User should verify after Login success message "Hello Naveenaso!"
    And User should perform search hotel by using all selected fields "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultPerRoom>" and "<childPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should perform select hotel by hotel name
    Then User should verify after select hotel success message "Book A Hotel"

    Examples: 
      | Username  | password     | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultPerRoom | childPerRoom |
      | naveenaso | Naveenmech1! | London   | Hotel Sunshine | Standard | 5 - Five  | 25/11/2022  | 26/11/2022   | 2 - Two      | 2 - Two      |

  Scenario Outline: Verifying Adactin Hotel Select details by without Select Hotel Name
    Given User is on the adactin page
    When User should perform Login "<Username>" and "<password>"
    Then User should verify after Login success message "Hello Naveenaso!"
    And User should perform search hotel by using all selected fields "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultPerRoom>" and "<childPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should perform select hotel by without select hotel name
    Then User should verify after select hotel error message "Please Select a Hotel"

    Examples: 
      | Username  | password     | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultPerRoom | childPerRoom |
      | naveenaso | Naveenmech1! | London   | Hotel Sunshine | Standard | 5 - Five  | 25/11/2022  | 26/11/2022   | 2 - Two      | 2 - Two      |
