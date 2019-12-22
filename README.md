# Find the pair game 

## Overview

The game is a classic memory game. There will be an even number of cards with pictures, all of which have a matching pair. The player's goal is to find matching pairs with as few card turns as possible.

## Features

- A layout of cards which all look similar unturned  ✅
- The player is able to see the picture on a card by clicking it ✅
- A pair for the card is chosen by clicking another card ✅
- If the cards don't match, they will automatically shift back to the default picture ✅
- If they match, they'll be removed from the table ✅
- The player will earn 5 scores when the cards match; if not, they'll lose a score ✅
- There are 3 levels of difficulty; the player will choose the level before the game begins (it will determine the size of the gameboard) ✅
- Pictures will be random by using a random picture API RandomCat ✅
- Without internet connection, the game just uses numbers instead of cat pictures ✅

## Java version info

The project has been made with Java 8. Newer Java versions don't support JavaFX, so any problems occurring when running the program may be linked to that.


## Documentation

#### [Working hours](findapairproject/documentation/workinghours.md)

#### [Requirements analysis](findapairproject/documentation/requirements.md)

#### [Architecture](findapairproject/documentation/architecture.md)

#### [Instructions](findapairproject/documentation/instructions.md)


## Command line commands

### Running the program

`mvn compile exec:java -Dexec.mainClass=com.mycompany.findthepair.Main`

### Testing

#### Running tests

`mvn test`

#### Generating the test report and viewing it

`mvn jacoco:report`

`open target/site/jacoco/index.html`

### Generating jar

`mvn package`

will generate jar file findthepair-1.0-SNAPSHOT.jar

### Generating checkstyle report

`mvn jxr:jxr checkstyle:checkstyle`





