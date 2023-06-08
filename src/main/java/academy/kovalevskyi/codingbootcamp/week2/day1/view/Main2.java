package academy.kovalevskyi.codingbootcamp.week2.day1.view;

public class Main2 {
    public static void main(String[] args) {
        Printer printer = new ConsolePrinter();
        Reader reader = new KeyboardReader();
        BoxView boxView = new BoxView(printer, reader);
        boxView.getMenuPoint();

    }
}
