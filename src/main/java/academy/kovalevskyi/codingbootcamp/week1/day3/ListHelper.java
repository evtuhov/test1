package academy.kovalevskyi.codingbootcamp.week1.day3;

import java.util.function.Function;

public class ListHelper {
  public static <T> ListNode<T> createOne(T value) {
        return new ListNode<>(null, null, value);
    }
  public static <T> void connect(ListNode<T> left, ListNode<T> right) {
    left.setNext(right);
    right.setPrev(left);
  }
  public static <T> int length(ListNode<T> someNode) {
    int count = 1;
    ListNode<T> currentNode = someNode.getNext();
    while (currentNode != null) {
      count++;
      currentNode = currentNode.getNext();
    }

    currentNode = someNode.getPrev();
    while (currentNode != null) {
      count++;
      currentNode = currentNode.getPrev();
    }
    return count;
    }
  public static <T> ListNode<T> addToEnd(ListNode<T> someNode, T newValue) {
    ListNode<T> lastNode = getLastNode(someNode);
    return new ListNode<T>(lastNode, null, newValue);
  }
  public static <T> ListNode<T> addToStart(ListNode<T> someNode, T newValue) {
    ListNode<T> firstNode = getFirstNode(someNode);
    ListNode<T> newNode = new ListNode<T>(null, firstNode, newValue);
    firstNode.setPrev(newNode);
    return newNode;
  }
  public static <T> boolean contains(ListNode<T> someNode, T value) {
    if (someNode == null) {
      throw new NullPointerException();
    }
    if (someNode.getValue() == value) {
      return true;
    }
    ListNode<T> currentNode = someNode.getNext();
    while (currentNode != null) {
      if (currentNode.getValue() == value) {
        return true;
      }
      currentNode = currentNode.getNext();
    }

    currentNode = someNode.getPrev();
    while (currentNode != null) {
      if (currentNode.getValue() == value) {
        return true;
      }
      currentNode = currentNode.getPrev();
    }
     return false;
  }
  private static <T> ListNode<T> getLastNode(ListNode<T> current) {
    while (current.getNext() != null) {
      current = current.getNext();
    }
      return current;
  }
  private static <T> ListNode<T> getFirstNode(ListNode<T> current) {
    while (current.getPrev() != null) {
      current = current.getPrev();
    }
      return current;
    }
  public static <T> T delete(ListNode<T> current) {
    ListNode<T> oldPrev = current.getPrev();
    ListNode<T> oldNext = current.getNext();
    if (oldPrev != null) {
      oldPrev.setNext(oldNext);
    }
    if (oldNext != null) {
      oldNext.setPrev(oldPrev);
    }
    current.setPrev(null);
    current.setNext(null);
    return current.getValue();
  }

  public static <T> ListNode<T> insertAfter(ListNode<T> prev, T newValue) {
    return new ListNode<T>(prev, prev.getNext(), newValue);
  }
  public static <T> void insertAfter(ListNode<T> prev, T[] newValues) {
    ListNode<T> newNode;
    for (T newValue : newValues) {
      prev = insertAfter(prev, newValue);
    }
  }
  public static <T, R> ListNode<R> map(ListNode<T> someNode, Function<T, R> mapFunction) {
    if (someNode == null) {
      throw new NullPointerException();
    }
    //if (someNode.getValue() == null) {
    //  return null;
    //}
    // идем по листу, создаем копии , меняем value по mapFunction.apply()

    ListNode<R> beginNode = new ListNode(someNode.getPrev(),
    someNode.getNext(), mapFunction.apply(someNode.getValue()));
    ListNode<T> currentNode = new ListNode<T>(someNode.getNext());
    ListNode<T> pred = someNode;
    while (currentNode != null) {
      pred = currentNode;
      currentNode = currentNode.getNext();
    }
    currentNode = someNode.getPrev();
    while (currentNode != null) {
      currentNode = currentNode.getPrev();
    }
      return beginNode;
  }

}
