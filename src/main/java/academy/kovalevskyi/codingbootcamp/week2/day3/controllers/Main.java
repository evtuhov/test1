package academy.kovalevskyi.codingbootcamp.week2.day3.controllers;

import academy.kovalevskyi.codingbootcamp.week2.day3.models.Board;
import academy.kovalevskyi.codingbootcamp.week2.day3.models.Player;
import academy.kovalevskyi.codingbootcamp.week2.day3.view.ConsolePrinter;
import academy.kovalevskyi.codingbootcamp.week2.day3.view.KeybordReader;
import academy.kovalevskyi.codingbootcamp.week2.day3.view.Printer;
import academy.kovalevskyi.codingbootcamp.week2.day3.view.Reader;

public class Main {
  public static void main(String[] args) {
    Printer printer = new ConsolePrinter();
    Reader reader = new KeybordReader();
    Player player1 = new Player('X');
    Player player2 = new Player('0');
    Board board = new Board();

    Game game = new Game(printer, reader, player1, player2, board);
    game.start();
    }

}
