Feature: User can add and export the contacts

  Scenario: User can add new contact
    Given user login to the system with email usera1@gmail.com and password Wati@123456
    And  go to the Contact page
    When user add new contact
    And export the contacts to excel
    Then verify the excel file includes the created contact



  Scenario: Send post request and get the contact that has "Valid" value
    Given send post request to server
    Then get the response that has Contact is Valid