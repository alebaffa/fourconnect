package com.fourconnect.main;

import java.util.Scanner;

public class FourConnectGame {

  private final Board board;

  private final String PLAYER_ONE = "R";
  private final String PLAYER_TWO = "G";

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    FourConnectGame game = new FourConnectGame();
    Board board = game.getBoard();
    int maxMoves = Board.COLUMNS * Board.ROWS;

    for (int i = 0; i < maxMoves; i++) {
      System.out.println(board);

      System.out.print("Player 1 [RED] - choose column (1-" + Board.COLUMNS + "): ");
      game.playerOneMove(getUserInput(scanner));

      System.out.println(board);

      if (game.isPlayerOneWinner()) {
        System.out.println("Player 1 [RED] wins!");
        return;
      }

      System.out.print("Player 2 [GREEN] - choose column (1-" + Board.COLUMNS + "): ");
      game.playerTwoMove(getUserInput(scanner));

      System.out.println(board);

      if (game.isPlayerTwoWinner()) {
        System.out.println("Player 2 [GREEN] wins!");
        return;
      }
    }
    System.out.println("No winners...");
  }

  private static int getUserInput(Scanner scanner) {
    String input = scanner.next();

    while (!input.matches("^[1-7]$")) {
      System.out.print("Not valid. Please, choose column (1-" + Board.COLUMNS + "): ");
      input = scanner.next();
    }
    return Integer.parseInt(input);
  }

  FourConnectGame() {
    board = new Board();
  }

  private Board getBoard() {
    return board;
  }

  public void playerOneMove(int col) {
    board.insertInColumn(PLAYER_ONE, col);
  }

  public void playerTwoMove(int col) {
    board.insertInColumn(PLAYER_TWO, col);
  }

  public void printBoard() {
    System.out.println(board);
  }

  /**
   * Used only for initial test purposes in test-driven development
   * */
  @Deprecated
  public int checkColumn(int col) {
    return board.countDiscInColumn(col);
  }

  public boolean isPlayerOneWinner() {
    return board.checkVertical(PLAYER_ONE) || board.checkHorizontal(PLAYER_ONE) || board
        .checkDiagonals(PLAYER_ONE);
  }

  public boolean isPlayerTwoWinner() {
    return board.checkVertical(PLAYER_TWO) || board.checkHorizontal(PLAYER_TWO) || board
        .checkDiagonals(PLAYER_TWO);
  }
}
