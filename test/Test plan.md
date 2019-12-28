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
1. Начать игру
2. Регистрация
3. Вход в аккаунт
4. Угадать персонажа
5. Не угадать персонажа
6. Ознакомиться с правилами игры
7. Выход в меню после окончания игры
8. Сыграть еще раз после окончания игры
9. Закрыть приложение

### Functional requirements:
#### 1. Start the game
Этот вариант использования небходимо протестировать на возможность начать игру.

#### 2. Registration
Этот вариант использования небходимо протестировать на возможность зарегестрироваться.

#### 3. Account Login
Этот вариант использования небходимо протестировать на возможность войти в свой аккаунт.

#### 4. Guess the character
Этот вариант использования небходимо протестировать при попытке угадать персонажа.

#### 5. Do not guess the character
Этот вариант использования небходимо протестировать при попытке угадать персонажа.

#### 6. Read the rules of the game
Этот вариант использования небходимо протестировать на возможность отображения правил игр при нажатии на кнопку меню "Правила игры".

#### 7. Exit to the menu after the end of the game
Этот вариант использования небходимо протестировать на возможность после кончания игры нажать кнопку "Меню".

#### 8.Play again after the end of the game
Этот вариант использования небходимо протестировать на возможность после кончания игры нажать кнопку "Продолжить игру" и продолжить игру.

#### 9. Close application
Этот вариант использования небходимо протестировать при нажатии на кнопку в главном меню "Выход". В данном случае работа приложения должна завершиться.

### Non-functional requirements:
#### 1. Clear gameplay
Понимание того, что надо делать после одной-трех игр.

#### 2. Performance
Отсутствие фризов во время использования приложения

<a name="5"></a>
## 5. Testing Approaches
Для тестирования приложения необходимо вручную проверить каждый аспект тестирования.

<a name="6"></a>
## 6. Presentation of Results
Результаты тестирования представлены в [документе](https://github.com/bar47ney/trtpo_two/blob/master/test/Test%20result.md).

<a name="7"></a>
## 7. Conclusion
Данный тестовый план позволяет протестировать основной функционал приложения. Успешное прохождение всех тестов с высокой вероятностью можно говорить о хорошей работоспособности, и о том, что данное программное обеспечение работает корректно.

    

