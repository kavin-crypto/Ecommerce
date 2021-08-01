Feature:  Data

  Scenario Outline: Home page
    Given Invoking the browser with chrome
    And Navigate to "https://rahulshettyacademy.com/angularpractice/" site
    When user should enter Name <name> EmailId <email> and password <pass>
    And Click the checkbox
    And Enter Gender<gender> DOB<dob> and click on Employment Status
    Then Click submit
    And Verify login successfully
    #And Close

    Given Click Shop button
    When User should select mobile brand <MobileName> and add to cart
    Then Click Checkout
    When Now check whether selected mobile is present in checkout page
    Then Click checkbox button
    When User should enter delivery location <countryName>
    And Click purchase button
    Then Verify order is placed or not
    And Close the browser

    Examples:
      | name    | email             | pass      | gender | dob        | MobileName | countryName              |
      | Sam     | Sam@gmail.com     | password  | Male   | 10/05/2022 | Nokia Edge | Netherlands              |
      | Chopper | Chopper@gmail.com | qws#$56sc | Male   | 12/08/1992 | iphone X   | United States of America |
      | Ankitha | Ankitha@gmail.com | !@#$%^    | Female | 16/04/1999 | Blackberry | Switzerland              |






