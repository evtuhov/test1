package academy.kovalevskyi.codingbootcamp.week0.day3;

public class JavaEntryChallenge {
  public static void printHello(){
    //System.out.println("Hello World");
    //System.out.println(SumOfTwoNumbers(3,2));
    //System.out.println(convertMinToSec(5));
    //compareTwoNumbers(-3,2);
    //concatTwoStrings("Sponge", "Bob");
    //System.out.println(remainder(-15,-7));
    //System.out.println(divisibleBy5(5));
    //int[] arr = new int[] {0, 1};
    //System.out.println(arr[0]);
    //var array = new int[]{3, 2, -1};
    //System.out.println(smallestElementOfArray(array));
    //int[] arrValues = {45,10,60,5,23};
    // int temp = arrValues[0];
    // for(int i=0;i<arrValues.length;i++) {
    //  if(arrValues[i] < temp) {
    //   temp = arrValues[i];
    // }
    //}
    //System.out.println("The smallest element is " + temp);
  }

  public static void main(String[] args) {
    printHello();
  }

  public static int sumOfTwoNumbers(int a, int b) {
    return a + b;
  }

  public static int convertMinToSec(int minutes) {
    return minutes * 60;
  }

  public static void compareTwoNumbers(int a, int b) {
    if (a > b) {
      System.out.print("Result: a is bigger");
    } else if (a < b) {
      System.out.print("Result: b is bigger");
    } else {
      System.out.print("Result: numbers are equal");
    }
  }

  public static void concatTwoStrings(String firstName, String lastName) {
    System.out.print(firstName + " " + lastName);
  }

  public static int remainder(int a, int b) {
    return a % b;
  }

  public static boolean divisibleBy5(int num) {
    if (num % 5 == 0) {
      return true;
    } else {
      return false;
    }
  }

  public static int firstElementOfArray(int[] arr) {
    return arr[0];
  }

  public static int smallestElementOfArray(int[] arr) {
    int min = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (min > arr[i]) {
        min = arr[i];
      }
    }
    return min;
  }

  public static void checkResultOfWork(boolean quick, boolean efficient, boolean reliable) {
    if (quick && efficient && reliable) {
      System.out.print("Result of work: excellent, but you are dreaming");
    } else if (quick && efficient) {
      System.out.print("Result of work: excellent, but pricey");
    } else if (quick && reliable) {
      System.out.print("Result of work: poor, but fast enough");
    } else if (efficient && reliable) {
      System.out.print("Result of work: good, but tired of waiting");
    } else {
      System.out.print("Pick at least two");
    }
  }
}