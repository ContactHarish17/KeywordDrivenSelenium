Feature: feature to test google search functionality 

Scenario: validate google search working 
	Given browser is open 
	And user is on google search 
	When user enters a search text 
	And hits enter 
	Then use is navigated to search results 
	
