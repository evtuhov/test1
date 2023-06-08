package academy.kovalevskyi.codingbootcamp.week2.day3.view;

public class ConsolePrinter implements Printer {

  @Override
  public void out(String message) {
    System.out.println(message);
  }
}
