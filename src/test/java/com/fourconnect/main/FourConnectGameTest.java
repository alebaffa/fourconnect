package com.fourconnect.main;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import com.fourconnect.main.FourConnectGame;
import org.junit.Test;

public class FourConnectGameTest {

  @Test
  public void playerRedMove(){
    FourConnectGame fourConnectGame = new FourConnectGame();
    fourConnectGame.playerOneMove(4);
    fourConnectGame.printBoard();
  }

  @Test
  public void playerRedMoveTwiceInSameColumn(){
    FourConnectGame fourConnectGame = new FourConnectGame();
    fourConnectGame.playerOneMove(4);
    fourConnectGame.playerOneMove(4);
    fourConnectGame.printBoard();
    assertThat(fourConnectGame.checkColumn(4), is(2));
  }

  @Test
  public void playerRedMoveThreeTimesInSameColumn(){
    FourConnectGame fourConnectGame = new FourConnectGame();
    fourConnectGame.playerOneMove(4);
    fourConnectGame.playerOneMove(4);
    fourConnectGame.playerOneMove(4);
    fourConnectGame.printBoard();
    assertThat(fourConnectGame.checkColumn(4), is(3));
  }

  @Test
  public void playerRedMoveFiveTimesInSameColumn(){
    FourConnectGame fourConnectGame = new FourConnectGame();
    fourConnectGame.playerOneMove(4);
    fourConnectGame.playerOneMove(4);
    fourConnectGame.playerOneMove(4);
    fourConnectGame.playerOneMove(4);
    fourConnectGame.playerOneMove(4);
    fourConnectGame.printBoard();
    assertThat(fourConnectGame.checkColumn(4), is(5));
  }

  @Test
  public void playerRedAndGreenMoveTwice(){
    FourConnectGame fourConnectGame = new FourConnectGame();
    fourConnectGame.playerOneMove(1);
    fourConnectGame.playerTwoMove(1);
    fourConnectGame.playerOneMove(2);
    fourConnectGame.playerTwoMove(3);
    fourConnectGame.printBoard();
  }

  @Test
  public void playerRedWinsVertically(){
    FourConnectGame fourConnectGame = new FourConnectGame();
    fourConnectGame.playerOneMove(1);
    fourConnectGame.playerOneMove(1);
    fourConnectGame.playerOneMove(1);
    fourConnectGame.playerOneMove(1);
    fourConnectGame.playerTwoMove(2);
    assertTrue(fourConnectGame.isPlayerRedWinner());
    assertFalse(fourConnectGame.isPlayerGreenWinner());
    fourConnectGame.printBoard();
  }

  @Test
  public void playerRedWinsAgainVertically(){
    FourConnectGame fourConnectGame = new FourConnectGame();
    fourConnectGame.playerOneMove(1);
    fourConnectGame.playerOneMove(1);
    fourConnectGame.playerOneMove(1);
    fourConnectGame.playerTwoMove(1);
    fourConnectGame.playerOneMove(2);
    fourConnectGame.playerOneMove(2);
    fourConnectGame.playerOneMove(2);
    fourConnectGame.playerOneMove(2);
    fourConnectGame.printBoard();
    assertTrue(fourConnectGame.isPlayerRedWinner());
    assertFalse(fourConnectGame.isPlayerGreenWinner());
  }

  @Test
  public void playerRedWinsHorizontally(){
    FourConnectGame fourConnectGame = new FourConnectGame();
    fourConnectGame.playerOneMove(1);
    fourConnectGame.playerOneMove(2);
    fourConnectGame.playerOneMove(3);
    fourConnectGame.playerOneMove(4);
    fourConnectGame.printBoard();
    assertTrue(fourConnectGame.isPlayerRedWinner());
  }

  @Test
  public void playerRedWinsAgainHorizontally(){
    FourConnectGame fourConnectGame = new FourConnectGame();
    fourConnectGame.playerOneMove(1);
    fourConnectGame.playerTwoMove(2);
    fourConnectGame.playerOneMove(1);
    fourConnectGame.playerTwoMove(3);
    fourConnectGame.playerOneMove(2);
    fourConnectGame.playerTwoMove(4);
    fourConnectGame.playerOneMove(3);
    fourConnectGame.playerTwoMove(5);
    fourConnectGame.printBoard();
    assertFalse(fourConnectGame.isPlayerRedWinner());
    assertTrue(fourConnectGame.isPlayerGreenWinner());
  }

  @Test
  public void playerGreenWinsDiagonallyAscending(){
    FourConnectGame fourConnectGame = new FourConnectGame();
    fourConnectGame.playerTwoMove(1);
    fourConnectGame.playerOneMove(2);
    fourConnectGame.playerTwoMove(2);
    fourConnectGame.playerOneMove(3);
    fourConnectGame.playerOneMove(3);
    fourConnectGame.playerTwoMove(3);
    fourConnectGame.playerOneMove(4);
    fourConnectGame.playerOneMove(4);
    fourConnectGame.playerOneMove(4);
    fourConnectGame.playerTwoMove(4);

    fourConnectGame.printBoard();
    assertFalse(fourConnectGame.isPlayerRedWinner());
    assertTrue(fourConnectGame.isPlayerGreenWinner());
  }

  @Test
  public void playerRedWinsDiagonallyDescending(){
    FourConnectGame fourConnectGame = new FourConnectGame();
    fourConnectGame.playerTwoMove(1);
    fourConnectGame.playerTwoMove(1);
    fourConnectGame.playerTwoMove(1);
    fourConnectGame.playerOneMove(1);
    fourConnectGame.playerTwoMove(2);
    fourConnectGame.playerTwoMove(2);
    fourConnectGame.playerOneMove(2);
    fourConnectGame.playerTwoMove(3);
    fourConnectGame.playerOneMove(3);
    fourConnectGame.playerOneMove(4);

    fourConnectGame.printBoard();
    assertTrue(fourConnectGame.isPlayerRedWinner());
    assertFalse(fourConnectGame.isPlayerGreenWinner());
  }
}
