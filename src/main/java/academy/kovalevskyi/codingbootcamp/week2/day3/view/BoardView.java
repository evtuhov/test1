package academy.kovalevskyi.codingbootcamp.week2.day3.view;

import academy.kovalevskyi.codingbootcamp.week2.day3.models.Board;



public class BoardView {
  private final Printer printer;
  private final Board board;

  public BoardView(Printer printer, Board board) {
    this.printer = printer;
    this.board = board;
  }

  public void show() {
    final char[][] array = board.toCharArray();
    for (int i = 0; i < array.length; i++) {
      String line = "|";
      for (int j = 0; j < array[i].length; j++) {
        line = line + array[i][j] + "|";
      }
      printer.out(line);
    }
  }
}
