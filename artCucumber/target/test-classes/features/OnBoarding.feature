Feature: Creating a new partner for ART application 

  Scenario: 
    Given I open a chrome browser and enter the art url 
     When I click on I am a saudi citizen 
      And I enter a valid saudi number 
      And I click on Next button 
     Then I Should see the OTP screen 
  
  Scenario Outline: 
    Given I enter <otp1>, <otp2>, <otp3> and <otp4> 
      And I click on Verify button 
     Then I should see one last feet page 
    Examples: 
      | otp1 | otp2 | otp3 | otp4 | 
      | 9    | 9    | 9    | 9    | 
  
  Scenario Outline: 
    Given I enter the <name> and <email> 
      And I click on Letsgetstarted button 
     Then I Should see home page 
      And a message welcome partner 
    Examples: 
      | name      | email                   | 
      | ART Saudi | artmobiledemo@gmail.com | 
  
  
