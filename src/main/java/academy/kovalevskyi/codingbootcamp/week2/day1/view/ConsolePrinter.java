package academy.kovalevskyi.codingbootcamp.week2.day1.view;

public class ConsolePrinter implements Printer {

  @Override
  public void showMessage(String text) {
    System.out.print(text);
  }

}

