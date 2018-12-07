Feature: Deck Of Cards

@ValidNumericValue
Scenario: To validate positive value for number of players

Given I have a deck of cards
When I shuffle the deck of cards
When I provide "4" value for number of players
Then I should see the message as "Cards dealt successfully to players!!!"

@InvalidNumericValue
Scenario: To validate negative value for number of players

Given I have a deck of cards
When I shuffle the deck of cards
When I provide "0" value for number of players
Then I should see the message as "Error!!! Number of players cannot be negative!!!"


@InvalidAplhaValue
Scenario: To validate alpha value for number of players

Given I have a deck of cards
When I shuffle the deck of cards
When I provide "ab" value for number of players
Then I should see the message as "Error!!! Number of players cannot be alphabets or special characters!!!"

@InvalidValueGreaterThanAvalilableCard
Scenario: To validate when number of cards for a player is equal to zero

Given I have a deck of cards
When I shuffle the deck of cards
When I provide "60" value for number of players
Then I should see the message as "Error!!! Number of players exceeds number of cards!!!"

@Shuffle
Scenario: To validate the shuffled deck of cards

Given I have a deck of cards
When I shuffle the deck of cards
Then I should see orginal deck of cards should not match after shuffled deck

@DealCard
Scenario: To validate the shuffled deck of cards

Given I have a deck of cards
When I shuffle the deck of cards
When I provide "5" value for number of players
Then I should see "52" cards dealt to players and "2" players should have eleven cards and "3" players should have ten cards
