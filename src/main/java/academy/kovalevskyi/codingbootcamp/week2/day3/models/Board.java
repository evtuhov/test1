package academy.kovalevskyi.codingbootcamp.week2.day3.models;

public class Board {
  public static final int SIDE = 3;

  private static final char EMPTY = ' ';


  private final char[][] array = new char[SIDE][SIDE];

  public Board() {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
         array[i][j] = EMPTY;
      }
    }
  }

  public void put(int x, int y, char ch) {
    if (!isFree(x, y)) {
      throw new IllegalArgumentException("Coordinates is busy: " + x + " " + y);
    }
    array[y][x] = ch;
  }

  public char[][] toCharArray() {
    return array.clone();
  }


  public boolean isFree(int x, int y) {
      return array[y][x] == EMPTY;
  }
}
