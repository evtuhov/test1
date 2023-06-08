package academy.kovalevskyi.codingbootcamp.week1.day2;

import java.util.Arrays;

public class StringUtils {

  //public static boolean isAsciiNumeric(char ch) {
  //  return Character.isDigit(ch);
  //}

  //  public static boolean isCirilicUTF8(char c) {
  //    if ((int)c >= 65 && (int)c <= 90 || (int)c == 1105 || (int)c == 1025)
  //            return true;
  //        return false;
  //    }
  //    public static void main(String [] args) {
  //        String ss = "ёсC aА eЁ";
  //        for (int i = 0; i < ss.length(); i++) {
  //            if (isCirilicUTF8(ss.charAt(i)))
  //                System.out.println(i + "-й символ в строке " + ss.charAt(i) + " из кирилицы");
  //        }
  //    }


  public static boolean isAsciiUppercase(char ch) {
    checkChar(ch);
    return (ch >= 'A' && (int) ch <= 'Z');
  }
  public static boolean isAsciiLowercase(char ch) {
    checkChar(ch);
    return ((int) ch >= 'a' && (int) ch <= 'z');
  }

  public static boolean isAsciiNumeric(char ch) {
    checkChar(ch);
    return (ch >= '0' && (int) ch <= '9');
  }
  //if ((int)c >= 65 && (int)c <= 90 || (int)c == 1105 || (int)c == 1025)

  public static boolean isAsciiAlphabetic(char ch) {
    checkChar(ch);
    return isAsciiUppercase(ch) || isAsciiLowercase(ch);
    //return ((int) ch >= 97 && (int) ch <= 122 || (int) ch >= 65 && (int) ch <= 90);
  }


  private static void checkChar(char ch) {
    if (ch > 126) {
      throw new IllegalArgumentException();
    }
  }

  public static char toAsciiUppercase(char ch) {
    checkChar(ch);
    //return (( ch < 'a') || ((int) ch > 'z')) ? ch : (char) ((int) ch - 32);
    return isAsciiLowercase(ch) ? (char) (ch - 32) : ch;
  }

  public static char toAsciiLowercase(char ch) {
    checkChar(ch);
    return (( ch < 'A') || ((int) ch > 'Z')) ? ch : (char) ((int) ch + 32);
  }


  public static StringBuilder makeUppercase(char[] input) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < input.length; i++) {
      sb.append(toAsciiUppercase(input[i]));
      //input[i] = toAsciiUppercase(input[i]);
    }
    return sb;
  }
  public static StringBuilder makeLowercase(char[] input) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < input.length; i++) {
      input[i] = toAsciiLowercase(input[i]);
    }
    return sb.append(input);
    //return sb;
  }
  public static StringBuilder makeCamel(char[] input) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < input.length; i += 2) {
      if (isAsciiUppercase(input[i])) {
        input[i] = toAsciiLowercase(input[i]);
        //sb.append(toAsciiUppercase(input[i]));
      }
    }
    for (int i = 1; i < input.length; i += 2) {
      if (isAsciiLowercase(input[i])) {
        input[i] = toAsciiUppercase(input[i]);
        //sb.append(toAsciiUppercase(input[i]));
      }
    }
    //return sb;
    return sb.append(input);
  }
  public static boolean isStringAlphaNumerical(char[] input) {
    for (int i = 0; i < input.length; i++) {
      if (isAsciiAlphabetic(input[i]) || isAsciiNumeric(input[i]) || (int) (input[i]) == 32) {
        continue;
      }
      return false;
    }
    return true;
  }
  public static char[] concatStrings(char[][] input) {
    int size = 0;
    for (int i = 0; i < input.length; i++) {
      size += input[i].length;
    }

    char[] arr = new char[size];
    int k = 0;
    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j < input[i].length; j++) {
        if ((int) input[i][j] > 256) {
          throw new IllegalArgumentException();
        }
        arr[k++] = input[i][j];
     //   k++;
      }
    }
    return arr;
  }



//  public static int toInt(char[] input) {
//   if (input.length == 0) {
//      throw new IllegalArgumentException();
//    }
//
//    int value = 0;
//    int sign = 1;

//    if (input[0] == '-') {
//      sign = -1;
//      for (int i = 1; i < input.length; i++) {
//
//        if (isAsciiNumeric(input[i])) {
//          value = (value * 10 + input[i] - '0');
//        }//i else {
////          throw new NumberFormatException();
////        }
//      }
//
//
//    } else {
//      for (int i = 0; i < input.length; i++) {
//        if (isAsciiNumeric(input[i])) {
//          value = (value * 10 + input[i] - '0');
//        } else {
//          throw new NumberFormatException();
//        }
//
//      }
//    }
//    return value * sign;
//  }





  public static int toInt(char[] input) {

    if (input.length == 0) {
      throw new IllegalArgumentException();
    }

    int res = 0;
    int sign = 1;

    if (input[0] == '-') {
      sign = -1;
      for (int i = 1; i < input.length; i++) {
        if (isAsciiNumeric(input[i])) {
          res = (res * 10 + input[i] - '0');
        }
      }
    } else {
      for (int i = 0; i < input.length; i++) {
        if (isAsciiNumeric(input[i])) {
          res = (res + input[i]);
        } else {
          throw new NumberFormatException();
        }
      }
    }
    return res * sign;
  }





  public static void main(String[] args) {
   // System.out.println("gggg");
    //System.out.println(isAsciiUppercase('h'));
    char[] base = new char[] {'h', 'e', 'l', 'L', 'o'};
    System.out.println(makeUppercase(base));

    //StringBuilder stringBuilder = makeUppercase(base);
    //System.out.println(stringBuilder);

    char[] base1 = new char[] {'h', 'e', 'l', 'L', 'o'};
    System.out.println(makeCamel(base1));



    //char[] inp = new char[]{'3', '2', 'a'};
    //char[] inp = new char[]{'3', '2'};
   // char[] inp = new char[]{'-', '1', '2', '2' };
   // System.out.println(toInt(inp));


    char [][] input = {{'a','b'}, {'c','d','g'}};
    System.out.println(input.length);


    int size = 0;
    for (int i = 0; i < input.length; i++) {
      //size += input[i].length;
      size =  size + input[i].length;
    }
    System.out.println("size "+ size);

    char[] arr = new char[size];
    int k = 0;
    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j < input[i].length; j++) {
        if ((int) input[i][j] > 256) {
          throw new IllegalArgumentException();
        }
        arr[k++] = input[i][j];
      //  k++;

      }
    }
  //  return arr;
    System.out.println(arr);

//    char[][] input = new char{{'a','b'}, {'c','d'}};
//    int size = 0;
//    //char[][] input = new char['a', 'b'] ['c', 'd'];
//
//    for (int i = 0; i < input.length; i++) {
//      size += input[i].length;
//    }
//
//    char[] arr = new char[size];
//    int k = 0;
//    for (int i = 0; i < input.length; i++) {
//      for (int j = 0; j < input[i].length; j++) {
//        if ((int) input[i][j] > 256) {
//          throw new IllegalArgumentException();
//        }
//        arr[k] = input[i][j];
//        k++;
//      }
//    }
//    return arr;
//    char[][] re2 = new char['a', 'b']['c', 'd'];
    //System.out.println(concatStrings(re2));
   //char[] res = new char[]{'a', 'b'}, {'c', 'd'};
  //  System.out.println(concatStrings('a', 'b'}, {'c', 'd'));

  }

}

