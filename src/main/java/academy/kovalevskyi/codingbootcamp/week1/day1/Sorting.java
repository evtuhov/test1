package academy.kovalevskyi.codingbootcamp.week1.day1;

import java.util.Comparator;

public class Sorting<T> {
  public static <T> void sort(T[] target, Comparator<T> comparator) {
    T t;
    boolean isSorted = false;
    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < target.length - 1; i++) {

        if (comparator.compare(target[i], target[i + 1]) > 0) {
          t = target[i];
          isSorted = false;
          target[i] = target[i + 1];
          target[i + 1] = t;
        }
      }
    }
  }

  public static <T> void  sortReversedOrder(T[] target, Comparator<T> comparator) {
    sort(target, comparator.reversed());
  }
}
