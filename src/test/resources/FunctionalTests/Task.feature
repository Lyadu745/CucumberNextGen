#Author: Lalit.kumar@taskbucks.work
#Keywords S :
#Feature: 1
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Emailing 
	Description:  The Purpose of this feature file it to automate test cases.
	
Background: For Every Scenario
    Given User is on Login Page 
    When User Enters Bad Credentials
	When User enters "admin" and password 
	Then User perform click on login


@RegressionTest
Scenario: NextGenPage 
     Then User click on Newsletter 
	Then User click on Campaigns 
	And Click on Segments 
	And Click on Reports 
	And Click on Trigger 
	And Click on Planning Module 
	And Click on Schedule Campaign 
	And Click on Settings 
	
	
@SmokeTest	
Scenario: Newsletter Page	 
    Then CLick for Newsletter 
	Then Enter Newsletterdetails And Save Newsletter
	When User click on View Newsletter

@SmokeTest
Scenario: Campign Page
   When Click For Campaign 
   Then Enter Campaign Name
   And  Select NewsletterName 
	