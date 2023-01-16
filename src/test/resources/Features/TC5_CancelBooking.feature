@CancelBooking
Feature: Verifying Adactin Hotel Cancel Booking details

  Scenario Outline: Verifying Adactin Hotel Cancel booking by Generated Oder Id
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
    And User should perform cancel the generated order id
    Then User should verify after cancel the order id success message "The booking has been cancelled."

    Examples: 
      | Username  | password     | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultPerRoom | childPerRoom | First Name | Last Name | Billing Address |
      | naveenaso | Naveenmech1! | London   | Hotel Sunshine | Standard | 5 - Five  | 25/11/2022  | 26/11/2022   | 2 - Two      | 2 - Two      | Naveen     | Asokan    | Chennai         |

  Scenario Outline: Verifying Adactin Hotel Cancel booking by Existing Oder Id
    Given User is on the adactin page
    When User should perform Login "<Username>" and "<password>"
    Then User should verify after Login success message "Hello Naveenaso!"
    And User should perform cancel the existing order id "<Order Id>"
    Then User should verify after cancel the order id success message "The booking has been cancelled."

    Examples: 
      | Username  | password     | Order Id   |
      | naveenaso | Naveenmech1! | YWUT2F2RUC |
