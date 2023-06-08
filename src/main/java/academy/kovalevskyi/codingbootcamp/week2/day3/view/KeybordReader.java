package academy.kovalevskyi.codingbootcamp.week2.day3.view;

import java.util.Scanner;

public class KeybordReader implements Reader {

  private final Scanner scanner = new Scanner(System.in);
  @Override
  public String input() {
        return scanner.next();
    }
}