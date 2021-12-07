# Author: Swathiraj Agaram Venkatavaradan
# Feature: The functionality to test the GET HTTP Request of COVID REST API End point.
# User story : 
# As a user, I want to check total cases of covid for UK
#
@get_covid_api
Feature: Functionality to test the GET HTTP Request of Covid REST API endpoint

  @get_covid_totalcases_UK
  Scenario: Test case to retrieve the total cases of covid for UK 
    Given I set the GET endpoint of COVID REST API
    And I set the query parameter for "country" as "UK"
    When I send Get HTTP request
    Then I verify the status code as "CODE_200"        
    And I retrieve the values for field "totalCases"
    
@get_covid_activecases_India
  Scenario: Test case to retrieve the active cases of covid for India
    Given I set the GET endpoint of COVID REST API
    And I set the query parameter for "country" as "India"
    When I send Get HTTP request
    Then I verify the status code as "CODE_200"        
    And I retrieve the values for field "activeCases"
    
 @get_covid_allData_allCountries
  Scenario: Test case to retrieve all covid data for ALL countries
    Given I set the GET endpoint of COVID REST API    
    When I send Get HTTP request
    Then I verify the status code as "CODE_200"    
    And I retrieve the covid history data for all countries    

@get_covid_allData_USA
  Scenario: Test case to retrieve all covid data for US countries
    Given I set the GET endpoint of COVID REST API
    And I set the query parameter for "country" as "USA"
    When I send Get HTTP request
    Then I verify the status code as "CODE_200"        
    And I retrieve the covid history data for "USA"
    
  @get_covid_data_invalid_endpoint
  Scenario: Test case to verify the error message on hitting an incorrect end point
     Given I set the GET endpoint of COVID REST API
    #And I set the query parameter for "country" as "UK"
    And I provide an invalid endpoint "/dummy"
    When I send Get HTTP request
    Then I verify the status code as "CODE_500"    
    Then I verify the error message "Unknown api" is displayed

  @get_covid_data_invalid_api_token
  Scenario: Test case to verify the error message on sending an invalid authentication token
     Given I set the GET endpoint of COVID REST API
     And I set the token value as "12345"    
    When I send Get HTTP request
    Then I verify the status code as "CODE_401"
    Then I verify the status message as "Unauthorized"
    
    