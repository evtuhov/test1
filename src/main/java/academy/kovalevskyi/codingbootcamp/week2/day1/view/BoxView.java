package academy.kovalevskyi.codingbootcamp.week2.day1.view;


import academy.kovalevskyi.codingbootcamp.week2.day1.models.Box;

public class BoxView {

  public static final String MENU = """
   1. Create a box & put a text in it
   2. Replace text in the box
   3. Shift numbers in a message in a box
   4. Exit
   YOUR CHOICE:\040""";
  public static final String SMALL_MENU = """
   Put text in the box:
     1. Use box with default walls & corners: "#", "%"
     2. Use my symbols for walls & corners
     YOUR CHOICE:\040""";
  public static final String LINE_REQUEST = "Please, input some line: \n";
  public static final String TRY_AGAIN = "TRY AGAIN!\n";
  public static final String GOODBYE = "Goodbye!";
  public static final String OLD_BOX = "Old box: \n";
  public static final String NEW_BOX = "New box: \n";
  public static final String NEED_BOX = "###You should create the box first!###\n";
  public static final String MENU_ERROR = "It is not an expected menu's number!\n";
  public static final String NEED_WALL = "Input walls symbol: ";
  public static final String NEED_CORNER = "Input corners symbol: ";

  private final Printer printer;

  private final Reader reader;

  public BoxView(Printer printer, Reader reader) {
    this.printer = printer;
    this.reader = reader;
  }

  public void drawBox(Box box) {
    if (box.width() < box.message().length()) {
      throw new IllegalArgumentException("The contents of the box cannot be printed within the box.");
    }
    if (box.width() != box.message().length() + 4) {
      throw new IllegalArgumentException("The contents of the box cannot" +
              " be printed within the box.");
    }

    if (box.height() != 3) {
      throw new IllegalArgumentException("The contents of the box cannot" +
              " be printed within the box.");
    }

    String topLine = box.corner() + box.wall().repeat(box.width() - 2) + box.corner() + "\n";
    String midLine = box.wall() + " " + box.message() + " " + box.wall() + "\n";
    String bottomLine = box.corner() + box.wall().repeat(box.width() - 2) + box.corner() + "\n";
    printer.showMessage(topLine + midLine + bottomLine);
  }

  public void showMessage(String str) {
    printer.showMessage(str);
  }

  public int getMenuPoint() {
    while (true) {
      printer.showMessage(MENU);
      try {
        int pointNumber = reader.getNumber();
        if (pointNumber < 1 || pointNumber > 4) {
          printer.showMessage(MENU_ERROR);
          printer.showMessage(TRY_AGAIN);
          continue;
        }
        return pointNumber;
      } catch (NumberFormatException e) {
        printer.showMessage(TRY_AGAIN);

      }
    }
  }

  public int getSmallMenuPoint() {
    while (true) {
      printer.showMessage(SMALL_MENU);
      try {
        int pointNumber = reader.getNumber();
        if (pointNumber < 1 || pointNumber > 2) {
          printer.showMessage(MENU_ERROR);
          printer.showMessage(TRY_AGAIN);
          continue;
        }
        return pointNumber;
      } catch (NumberFormatException e) {
        printer.showMessage(TRY_AGAIN);

      }
    }
  }

  public String getWall() {
    return getSymbol(NEED_WALL);
  }

  public String getCorner() {
    return getSymbol(NEED_CORNER);
  }

  private String getSymbol(String title) {
    while (true) {
      printer.showMessage(title);
      String symbol = reader.getText();
      if (symbol.length() != 1) {
        printer.showMessage(TRY_AGAIN);
        continue;
      }
      return symbol;
    }
  }

  public String getText() {
    printer.showMessage(LINE_REQUEST);
    String text = reader.getText();
    if (text.length() != 1) {
      printer.showMessage("Please, input some line: ");
    }
    return text;
  }

}
