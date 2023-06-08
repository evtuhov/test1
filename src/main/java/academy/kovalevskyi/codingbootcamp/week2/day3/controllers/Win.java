package academy.kovalevskyi.codingbootcamp.week2.day3.controllers;

import academy.kovalevskyi.codingbootcamp.week2.day3.models.Board;

public class Win {

  public boolean isWin(Board board, char figure) {
    char[][] array = board.toCharArray();

    if (array[0][0] == figure && array[1][0] == figure && array[2][0] == figure) {
      return true;
    }
    if (array[0][1] == figure && array[1][1] == figure && array[2][1] == figure) {
      return true;
    }
    if (array[0][2] == figure && array[1][2] == figure && array[2][2] == figure) {
      return true;
    }

    if (array[0][0] == figure && array[0][1] == figure && array[0][2] == figure) {
      return true;
    }
    if (array[1][0] == figure && array[1][1] == figure && array[1][2] == figure) {
      return true;
    }
    if (array[2][0] == figure && array[2][1] == figure && array[2][2] == figure) {
      return true;
    }

    if (array[0][0] == figure && array[1][1] == figure && array[2][2] == figure) {
      return true;
    }
    if (array[0][2] == figure && array[1][1] == figure && array[2][0] == figure) {
      return true;
    }

    return false;
  }

  public boolean isDraw(Board board, char figure) {
    if (isWin(board, figure)) {
      return false;
    }

    for (int i = 0; i < Board.SIDE; i++) {
      for (int j = 0; j < Board.SIDE; j++) {
        if (board.isFree(i, j)) {
          return false;
        }
      }

    }
    return true;
  }

}
