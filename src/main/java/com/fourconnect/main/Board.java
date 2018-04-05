package com.fourconnect.main;

public class Board {

  private static final int ROW_ZERO = 0;
  private static final int COL_ZERO = 0;
  static final int COLUMNS = 7;
  static final int ROWS = 6;
  private static final String DEFAULT_VALUE = " ";

  private final String[][] board;

  public Board() {
    board = new String[ROWS][COLUMNS];
    initializeBoard();
  }

  private void initializeBoard() {
    for (int i = ROW_ZERO; i < ROWS; i++) {
      for (int j = COL_ZERO; j < COLUMNS; j++) {
        board[i][j] = DEFAULT_VALUE;
      }
    }
  }

  /**
   * Used only for initial test purposes in test-driven development
   * */
  @Deprecated
  public int countDiscInColumn(int col) {
    int count = 0;
    for (int i = ROW_ZERO; i < ROWS; i++) {
      if (!board[i][col - 1].equals(DEFAULT_VALUE)) {
        count++;
      }
    }
    return count;
  }

  public boolean checkHorizontal(String player) {
    for (int j = 0; j < COLUMNS - 3; j++) {
      for (int i = 0; i < ROWS; i++) {
        if (board[i][j].equals(player) &&
            board[i][j + 1].equals(player) &&
            board[i][j + 2].equals(player) &&
            board[i][j + 3].equals(player)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean checkVertical(String player) {
    for (int i = 0; i < ROWS - 3; i++) {
      for (int j = 0; j < COLUMNS; j++) {
        if (board[i][j].equals(player) &&
            board[i + 1][j].equals(player) &&
            board[i + 2][j].equals(player) &&
            board[i + 3][j].equals(player)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean checkDiagonals(String player) {
    for (int i = 3; i < ROWS; i++) {
      for (int j = 0; j < COLUMNS - 3; j++) {
        if (board[i][j].equals(player) &&
            board[i - 1][j + 1].equals(player) &&
            board[i - 2][j + 2].equals(player) &&
            board[i - 3][j + 3].equals(player)) {
          return true;
        }
      }
    }

    for (int i = 3; i < ROWS; i++) {
      for (int j = 3; j < COLUMNS; j++) {
        if (board[i][j].equals(player) &&
            board[i - 1][j - 1].equals(player) &&
            board[i - 2][j - 2].equals(player) &&
            board[i - 3][j - 3].equals(player)) {
          return true;
        }
      }
    }
    return false;
  }

  public void insertInColumn(String player, int col) {
    int counter = 1;

    while (true) {
      if (col > COLUMNS) {
        System.out.println("Not a valid column");
        break;
      }

      if (board[ROW_ZERO][col - 1].equals(DEFAULT_VALUE)) {
        board[ROW_ZERO][col - 1] = player;
        break;
      }
      if (!board[ROW_ZERO][col - 1].equals(DEFAULT_VALUE)) {
        if (board[ROW_ZERO + counter][col - 1].equals(DEFAULT_VALUE)) {
          board[ROW_ZERO + counter][col - 1] = player;
          break;
        }
      }
      counter++;
      if (counter == COLUMNS) {
        System.out.println("This column is full");
        break;
      }
    }
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for (int i = board.length - 1; i >= ROW_ZERO; i--) {
      builder.append(i + 1).append("|");
      for (int j = COL_ZERO; j <= board[i].length - 1; j++) {
        builder.append(board[i][j]).append("|");
      }
      builder.append("\n");
    }
    builder.append("\n");
    return builder.toString();
  }
}
