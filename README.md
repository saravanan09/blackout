blackout

I have scripted the solution in Java and used cucumber feature to run the unit test. You will be able to execute the test, by importing the zip file into the IDE and run the RunnerTest.java file.
 
The folder structure is as follows,
- src/main/java
  - deck.of.cards.main
    - Cards.java - Contains the functions for Create, Shuffle, Deal and Display Cards
- src/test/java
  - deck.of.cards.stepDefs.runner
    - RunnerTest.java - Contains Cucumber Runner Class to execute the unit test
    - StepDefs.java - Contains the step definitions for the corresponding feature file
  - featuers
    - deckOfCard.feature - Contains the Unit Test Scenarios
- target
  - Reports available after the execution of unit test
