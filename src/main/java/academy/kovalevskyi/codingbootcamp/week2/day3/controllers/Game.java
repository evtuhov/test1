package academy.kovalevskyi.codingbootcamp.week2.day3.controllers;

import academy.kovalevskyi.codingbootcamp.week2.day3.models.Board;
import academy.kovalevskyi.codingbootcamp.week2.day3.models.Player;
import academy.kovalevskyi.codingbootcamp.week2.day3.view.BoardView;
import academy.kovalevskyi.codingbootcamp.week2.day3.view.Printer;
import academy.kovalevskyi.codingbootcamp.week2.day3.view.Reader;

public class Game {

  private final Printer printer;
  private final Reader reader;
  private final Player player1;
  private final Player player2;
  private final Board board;
  private Player currentPlayer;

  public Game(Printer printer, Reader reader, Player player1, Player player2, Board board) {
    this.printer = printer;
    this.reader = reader;
    this.player1 = player1;
    this.player2 = player2;
    this.board = board;
    currentPlayer = player1;
  }

  public void  start() {
    BoardView boardView = new BoardView(printer, board);
    Win win = new Win();

    while (true) {
      boardView.show();
      playerMove();
      if (win.isWin(board, currentPlayer.getFigure())) {
        boardView.show();
        printer.out("Победил игрок " + currentPlayer.getFigure());
        break;
      }
      if (win.isDraw(board, currentPlayer.getFigure())) {
        boardView.show();
        printer.out("Ничья");
        break;
      }
      nextPlayer();
    }
  }

  public void nextPlayer() {
    currentPlayer = currentPlayer == player1 ? player2 : player1;
  }

  private void playerMove() {

    while (true) {
      printer.out("Ход игрока " + currentPlayer.getFigure());
      printer.out("Введите x:");
      int x = inputInt("Вы должны ввести цифру");

      printer.out("Введите y:");
        int y = inputInt("Вы должны ввести цифру");

      if (x < 0 || x >= Board.SIDE || y < 0 || y >= Board.SIDE) {
        printer.out("Клетки с такими коордтнатами не существует, введите другую");
        continue;
      }

      boolean isFreeCell = board.isFree(x, y);

      if (!isFreeCell) {
        printer.out("Клетка занята, введите другую");
        continue;
      }
      board.put(x, y, currentPlayer.getFigure());
      return;
    }
   }

  private int inputInt(String fail) {
    while (true) {
      try {
        String value = reader.input();
        int number = Integer.parseInt(value);
        return number;
      } catch (NumberFormatException e) {
        printer.out(fail);
      }
    }
  }

}
