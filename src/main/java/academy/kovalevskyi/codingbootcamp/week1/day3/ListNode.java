package academy.kovalevskyi.codingbootcamp.week1.day3;

public class ListNode<T> {

    private ListNode<T> prev;
    private ListNode<T> next;
    private T value;


    public ListNode(ListNode<T> param) {
  this.value = param.value;
        this.setPrev(param.getPrev());
        this.setNext(param.getNext());
    }

  public ListNode(ListNode<T> prev, ListNode<T> next, T value) {
     this.value = value;
     setPrev(prev);
     setNext(next);
    }

    public void  setPrev(ListNode<T> prev) {
      this.prev = prev;
      if (prev != null) {
          prev.next = this;
      }
    }


    public void  setNext(ListNode<T> next) {
        this.next = next;
        if (next != null) {
            next.prev = this;
        }
    }

    public ListNode<T> getNext() {
      return next;
    }

    public ListNode<T> getPrev() {
        return prev;
    }
    public T getValue() {
      return value;
    }

    public String toString() {
      String prev = getPrev() != null ? getPrev().getValue().toString() : "null";
      String next = getNext() != null ? getNext().getValue().toString() : "null";
      String val = getValue() != null ? getValue().toString() : "null";
        return ("Node{prevValue=" + prev + ", nextValue=" + next + ", thisValue=" + val + "}");
     //   return ("Node{prevValue=" + getPrev() + ", nextValue=" + getNext() + ", thisValue=" + getValue() + "}");


    }

}
