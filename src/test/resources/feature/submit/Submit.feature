Feature: Submit
  As a user, I can modify a review then press the RATE button, so that I can discard my modifications.
	
  Scenario Outline: Content
	When I start with the content of <content1>
	Then the content after should be <content2>
		
	Examples:
	  | content1 | content2 |
	  | stuff	 | stuff    |
	  | words	 | words    |