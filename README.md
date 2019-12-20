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

## Documentation

#### [Working hours](findapairproject/documentation/workinghours.md)

#### [Requirements analysis](findapairproject/documentation/requirements.md)


## Running the program

```mvn compile exec:java -Dexec.mainClass=com.mycompany.findthepair.Main```

### INFO

The project has been made with Java 8. Newer Java versions don't support JavaFX, so any problems occurring when running the program may be linked to that.




