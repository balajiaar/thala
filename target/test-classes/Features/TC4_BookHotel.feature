@BookHotel
Feature: Verifying Adactin Hotel Book Hotel details

  Scenario Outline: Verifying Adactin Hotel Book Hotel by Select all fields
    Given User is on the adactin page
    When User should perform Login "<Username>" and "<password>"
    Then User should verify after Login success message "Hello Naveenaso!"
    And User should perform search hotel by using all selected fields "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultPerRoom>" and "<childPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should perform select hotel by hotel name
    Then User should verify after select hotel success message "Book A Hotel"
    And User should perform book hotel by select all fields "<First Name>","<Last Name>" and "<Billing Address>"
      | Credit Card No.  | Credit Card Type | Expiry Month | Expiry Year | CVV Number |
      | 1234567891234567 | VISA             | June         |        2022 |        234 |
      | 7544564242424567 | Master Card      | July         |        2022 |        758 |
      | 8653442591234567 | VISA             | May          |        2022 |        853 |
      | 5356547891234567 | American Express | April        |        2022 |        323 |
    Then User should verify after book hotel success message "Booking Confirmation" and save the generated order id

    Examples: 
      | Username  | password     | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultPerRoom | childPerRoom | First Name | Last Name | Billing Address |
      | naveenaso | Naveenmech1! | London   | Hotel Sunshine | Standard | 5 - Five  | 25/11/2022  | 26/11/2022   | 2 - Two      | 2 - Two      | Naveen     | Asokan    | Chennai         |

  Scenario Outline: Verifying Adactin Hotel Book Hotel by without Select any fields
    Given User is on the adactin page
    When User should perform Login "<Username>" and "<password>"
    Then User should verify after Login success message "Hello Naveenaso!"
    And User should perform search hotel by using all selected fields "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultPerRoom>" and "<childPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should perform select hotel by hotel name
    Then User should verify after select hotel success message "Book A Hotel"
    And User should perform book hotel by without Select any fields
    Then User should verify after book hotel error message "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | Username  | password     | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultPerRoom | childPerRoom |
      | naveenaso | Naveenmech1! | London   | Hotel Sunshine | Standard | 5 - Five  | 25/11/2022  | 26/11/2022   | 2 - Two      | 2 - Two      |
