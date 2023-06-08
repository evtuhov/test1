package academy.kovalevskyi.codingbootcamp.week0.day4;

public class Alphabet {

  public static void main(String[] args) {
    System.out.println(generateAlphabet());
    System.out.println(generateReversedAlphabet());
  }

//  public static char[] generateAlphabet() {
//    char[] arr = new char[26];
//    for (int i = 0; i < arr.length; i++) {
//      arr[i] = (char) (i + 97);
//    }
//    return arr;
//  }
//
  public static char[] generateReversedAlphabet() {
    char[] arr = new char['z' - 'a' + 1];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (char) ('z' - i);
    }
    return arr;
  }

  public static char[] generateAlphabet() {
    char[] alph = new char['z' - 'a' + 1];
    for (int i = 0; i < alph.length; i++) {
      alph[i] = (char) ('a' + i);
    }
    return alph;
  }

//  public static char[] generateReversedAlphabet() {
//    var length = 'z' - 'a' + 1;
//    char[] arr = new char[length];
//    var last = 'z';
//    for (int i (ch = 'z'; ch >= 'a'; ch--, i++) {
//      arr[i] = ch;
//    }
//    return arr;
//  }





}
