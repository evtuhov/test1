package academy.kovalevskyi.codingbootcamp.week1.day2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import static academy.kovalevskyi.codingbootcamp.week1.day2.StringUtils.concatStrings;


public class StdString1 implements Iterable<Character> {
  private char[] base1;

  public static void main(String[] args) {
    System.out.println("ddd");

//    char[] newValue = new char['c' + 'd'];
//
//    //concatStrings('1', '2');
//
//    //return newValue;
//    for (int i = 0; i < this.length(); i++) {
//      newValue[i] = this.toCharArray()[i];
//    }
//    for (int i = 0; i < that.length(); i++) {
//      newValue[i + this.length()] = that.base1[i];
//    }
//    return new StdString1(newValue);

  }
  //char[] base = new char[] {'h', 'e', 'l', 'l', 'o'};

  public StdString1(char[] base) {
    base1 = base.clone();
  }

  public StdString1() {
    this(new char[0]);
  }

  public StdString1(StdString1 stdString1) {
    this(stdString1.toCharArray());
  }

  public char[] toCharArray() {
    return this.base1;
  }

  public int length() {
    return base1.length;
  }

  public StdString1 append(StdString1 that) {
    if (that == null) {
      throw new NullPointerException();
    }

    char[] newValue = new char[this.length() + that.length()];

   //concatStrings('1', '2');

    //return newValue;
//    for (int i = 0; i < this.length(); i++) {
//      newValue[i] = this.toCharArray()[i];
//    }
//    for (int i = 0; i < that.length(); i++) {
//      newValue[i + this.length()] = that.base1[i];
//    }
    return new StdString1(newValue);
  }


  public char charAt(int index) {
    return this.base1[index];
  }

  public int indexOf(char target) {
    int res = -1;
    for (int i = 0; i < length(); i++) {
      if (this.base1[i] == target) {
        res = i;
        break;
      }
    }
    return res;
  }

  public String toString() {
    return new String((this.base1));
  }

  @Override
  public int hashCode() {
    int suma = 0;

    for (int i = 0; i < this.length(); i++) {
      suma += base1[i];
    }

    return suma;

  }

  @Override
  public boolean equals(final Object otherObj) {
    if (this == (StdString1) otherObj) {
      return true;
    }
    if (otherObj instanceof StdString1 obj && base1.length == obj.base1.length) {
      for (int i = 0; i < base1.length; i++) {
        if (base1[i] != obj.base1[i]) {
          return false;
        }
      }
      return true;
    } else {
      return false;
    }
  }


  @Override
  public void forEach(Consumer<? super Character> action) {
    iterator().forEachRemaining(action);
  }

  @Override
  public Iterator<Character> iterator() {

    Iterator<Character> characterIterator = new Iterator<>() {
      private int position;

      @Override
      public boolean hasNext() {
        return position < base1.length;
      }

      @Override
      public Character next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        return base1[position++];
      }
    };
    return characterIterator;
  }

}
