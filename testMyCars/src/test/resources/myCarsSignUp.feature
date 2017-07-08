#Author: david.lake


Feature: myCars SignUp
	In order to sign into my myCars account
	As a new visitor
	I want to create an myCars account
	
Background: 
Given I am on the homepage
When I click Login
 And I click Sign Up
Then I should see an registration page

Scenario Outline: Sign Up with valid Email Address
Given I enter "<emailAddress>" as an Email 
When I click Sign Up Now! button
Then I should see a confirmation page

#Please Increment Test# by 2 to simulate new user
# test4@gmail.com -> test6@gmail.com 
Examples:
|   emailAddress  |
| test6@gmail.com |
| test7@gmail.com |

	
