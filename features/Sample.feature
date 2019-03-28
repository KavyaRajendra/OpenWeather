Feature: Verify the content of the Whether app

#Scenario: sample test for Opencart with before and after scenario
  #Given Opencart Url is been opened
  #Then I should see "" as page title
  #When I Click on login
  #And Enter "username" and "password"
  #When I click on the Login Button
  #Then I should see error message
  
Scenario Outline: sample tests for Weather App
  Given Weather App Url is opened
  Then User should be able to enter the "<cityname>"
  Then User should see table of Data for the weather conditions
  And table should contain data for 5 days
  When User clicks on one of the weather conditions of a day
  Then User should see 3 hours forecast 
  And User should see  All the required fields
  And User should only see Rounded Value
  When User clicks the Weather condition of a Day it should hide the 3 hours forecast data
  Examples:
  		| cityname |
      | aberdeen |
      | dundee |
      | edinburgh  |
      | glasgow  |
      | perth  |
      | stirling  |
      
      
      
#Scenario Outline: sample tests for Weather App
  #Given Weather App Url is opened
  #Then User should be able to enter the "<cityname>"
  #Then User should see table of Data for the weather conditions
  #And table should contain data for 5 days
  #When User clicks on one of the weather conditions of a day
  #Then User should see 3 hours forecast 
  #And User should see  All the required fields
  #And Application should be friendly for Accessibility
  #And User should only see Rounded Value
  #When User clicks the Weather condition of a Day it should hide the 3 hours forecast data
  #Examples:
  #		| cityname |
      #| aberdeen |
      #| dundee |
      #| edinburgh  |
      #| glasgow  |
      #| perth  |
      #| stirling  |