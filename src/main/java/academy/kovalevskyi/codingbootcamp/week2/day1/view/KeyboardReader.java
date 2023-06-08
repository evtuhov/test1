package academy.kovalevskyi.codingbootcamp.week2.day1.view;

import java.util.Scanner;

public class KeyboardReader implements Reader {
  private final Scanner scanner = new Scanner(System.in);

  @Override
  public int getNumber() {
    if (!scanner.hasNext()) {
      throw new IllegalArgumentException("Scanner invalid");
    }
    String keyValue = scanner.nextLine();
    keyValue = keyValue.trim();
    int number = Integer.parseInt(keyValue);
    return number;
  }

  @Override
  public String getText() {
    String string = scanner.nextLine();
    return string;
  }

}
