# Test plan
 ### Contents
  1. [Introduction](#1)
  2. [Test object](#2)
  3. [The risks](#3)
  4. [Testing Aspects](#4)<br>
  5. [Testing Approaches](#5)
  6. [Presentation of Results](#6)
  7. [Сonclusions](#7)
  <a name="1"></a>
 ## 1. Introduction
The contents of this document describes an application testing plan "ProjectALLigator". Test purpose - application verification in accordance with SRS.
<a name="2"></a>
 ## 2. Test object
### 1. Functional suitability
-   #### Functional completeness
    The application features should cover all the features described in SRS.
-   #### Functional correctness
    The application must perform all the declared functions correctly.
-   #### Functional expediency.
    There are no unclaimed functions that would prevent the application from performing its original tasks.
### 2. Ease of use
-   #### UI Availability
   Object controls should always be available to the user.
-   #### Relevance
    All changes occur in real time.
<a name="3"></a>
## 3. The risks
Risks include:
- If there is no JVM on the PC, the application will not start
- Missing SQLite Database
- The processing speed of the game logic depends on the PC processor
- Occurrence of errors, processing related DB
<a name="4"></a>
 ## 4. Testing Aspects
During testing should be checked implementation of the main functions of the application:  
1. Start the game
2. Registration
3. Sign In
4. Guess the character
5. Do not guess the character
6. Read the rules of the game
7. Exit to the menu after the end of the game 
8. Play again after the end of the game
9. Close application

### Functional requirements:
#### 1. Start the game
This use case needs to be tested for the ability to start the game.

#### 2. Registration
This use case needs to be tested for the ability to register.

#### 3. Singn In
This use case must be tested for the ability to log into your account.

#### 4. Guess the character
This use case must be tested when trying to guess the character.

#### 5. Do not guess the character
This use case must be tested when trying to guess the character.

#### 6. Read the rules of the game
This use case needs to be tested for the ability to display game rules when you click on the "Game Rules" menu button.

#### 7. Exit to the menu after the end of the game
This use case needs to be tested for the ability to press the "Menu" button after the end of the game.

#### 8.Play again after the end of the game
This use case needs to be tested for the possibility of clicking the "Continue the game" button and continue the game after the end of the game.

#### 9. Close application
This use case must be tested by clicking on the button in the "Exit" main menu. In this case, the application should end.

### Non-functional requirements:
#### 1. Clear gameplay
Understanding what to do after one or three games.

#### 2. Performance
Lack of friezes while using the application.

<a name="5"></a>
## 5. Testing Approaches
To test the application, you must manually verify each aspect of the test.

<a name="6"></a>
## 6. Presentation of Results
Test results are presented in the [document](https://github.com/bar47ney/trtpo_two/blob/master/test/Test%20result.md).

<a name="7"></a>
## 7. Conclusion
This test plan allows you to test main application functionality. Successful completion of all tests with high probability can talk about good performance.
    

