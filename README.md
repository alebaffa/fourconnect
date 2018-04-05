# Four Connect game

This is a Java implementation of Four Connect.

## Languages
- Java 8
- gradle 4.5

## Build and run unit tests
Just run `gradle build`

## Play
Run the class `FourConnectGame`.

The game expects the input from two players in turn, like so (white spaces are allowed, but it will only process positive integer values from 1 to 7):

`Player 1 [RED] - choose column (1-7):`

At each move it will show the current status of the board, as shown in the example below:

```
6| | | | | | | |
5| | | | | | | |
4| | | |G| | | |
3| | |G|R| | | |
2| |G|R|R| | | |
1|G|R|R|R| | | |
```