package academy.kovalevskyi.codingbootcamp.week1.day4;

import academy.kovalevskyi.codingbootcamp.week1.day2.StdString1;
import academy.kovalevskyi.codingbootcamp.week1.day2.StringUtils;

public class StdString2 extends StdString1 {
    public static void main(String[] args) {

            String s = "Hi";
            System.out.println(s.toLowerCase());        // hi

        //System.out.println(s.m);
        //return new StdString2(StringUtils.makeLowercase([input]).toString().toCharArray())

        //String str = "125/256///";
        //StdString2 test = new StdString2(str.toCharArray());
        //StdString2[] narr = (test.split('/'));
        //System.out.println("========================================");
        //for (int i = 0; i < narr.length; i++) {
        //  System.out.println(narr[i]);
        //}
        //System.out.println("========================================");
    }

    public StdString2() {
        super(); //вызовется в любом случае
    }
    public StdString2(char[] base) {
        super(base);
    }
    public StdString2(StdString2 that) {
      super(that);
      //super(that.toCharArray());
    }

    //Создает копию строки, в которой все символы нижнего регистра.
    public StdString2 toAsciiLowerCase() {
       // return new StdString2(StringUtils.makeLowercase(base).toString().toCharArray());
          return new StdString2(StringUtils.makeLowercase(this.toCharArray()).toString().toCharArray());
    }

    //Создает копию строки, в которой все символы верхнего регистра
    public StdString2 toAsciiUpperCase() throws IllegalArgumentException {
        return new StdString2(StringUtils.makeUppercase(this.toCharArray()).toString().toCharArray());
    }


    //Метод создает новую строку, в которую входят все символы текущей строки, а также все
    //символы каждой строки, которая была передана на вход.
    public StdString2 concat(StdString2... that) {
        // получим 2хмерный массив из входяших + длину текушего об-та
        char[][] newArr = new char[that.length + 1][];
        newArr[0] = this.toCharArray();
        for (int i = 1; i < newArr.length; i++) {
            newArr[i] = that[i - 1].toCharArray();
        }
        //System.out.println(that.toString());
        return new StdString2(StringUtils.concatStrings(newArr));
    }

    //Возвращает подстроку, начиная с заданного индекса (включительно) по
    //заданный индекс (не включительно).
    public StdString2 subString(int from, int to) {
        final int L = length();
        //  System.out.println("L=" + L + " from=" + from + " to=" + to);
        //if (from > L || from < 0 || to > L || to <= 0) {
        if (to > L) {
            throw new IndexOutOfBoundsException("Out Of Bounds");
        }
        if (from > to) {
            throw new IllegalArgumentException("from > to ");
        }

        char[] result = new char[to - from];
        int j = 0;
        for (int i = 0; i < result.length; i++) {

            result[i] = this.toCharArray()[i + from];
        }

        return new StdString2(result);
    }


    //Метод создает новую строку, которая равна текущей, однако без определенного
    //символа, который передан на вход.
  public StdString2 removeCharacter(char toRemove) {
    StringBuilder strBuilder = new StringBuilder();
    for (char c : this.toCharArray()) {
      if (c != toRemove) {
        strBuilder.append(c);
      }
    }
    char[] result = new char[strBuilder.length()];
    strBuilder.getChars(0, strBuilder.length(), result, 0);
    return new StdString2(result);
  }

  //Метод делит текущую строку на подстроки в соответствии с заданным
  //делителем и возвращает массив этих строк.
  public StdString2[] split(char separator) {

    int lenVal = this.toCharArray().length;
    while (this.toCharArray()[lenVal - 1] == separator && lenVal > 0) {
      lenVal--;
    }
    int separCount = 1;
    for (int i = 0; i < lenVal; i++) {
      if (this.toCharArray()[i] == separator) {
        separCount++;
      }
    }

    StdString2[] splitArr;
      if (separCount == 1) {
        splitArr = new StdString2[1];
        splitArr[0] = this.subString(0, lenVal);
      return splitArr;
      }

    splitArr = new StdString2[separCount];
    int begin = 0;
    int i = 0;
    int j = 0;
    while (i < lenVal) {
      if (this.toCharArray()[i] == separator) {
        splitArr[j] = this.subString(begin, i);
        begin = i + 1;
        j++;
      }
    i++;
    }
    splitArr[j] = this.subString(begin, lenVal);
    return splitArr;
  }




  //Метод создает новую строку, которая похожа на текущую, но только без
  //пробелов в начале и в конце строки (если они там вообще есть).
//  public StdString2 trim() {
//    if (length() <= 0) {
//      return new StdString2(new char[]{});
//    }
//
//    int espace = length() - 1;
//    while (isRemovableSym(this.toCharArray()[espace]) && espace > 0) {
//      espace--;
//    }
//    espace++;
//
//    int bspace = 0;
//    while (isRemovableSym(this.toCharArray()[bspace]) && bspace < length()) {
//      bspace++;
//    }
//    return this.subString(bspace, espace);
//  }

  private boolean isRemovableSym(char c) {
    //return (c == ' ' || c == '\t' || c == '\n');
    return c <= ' ';
  }



  public StdString2 trim() {
    int spaceLeft = 0;
    while (spaceLeft < length() && isRemovableSym(this.charAt(spaceLeft))) {
      spaceLeft++;
    }

    int spaceRight = length() - 1;
    while (spaceRight >= 0 && isRemovableSym(this.charAt(spaceRight))) {
      spaceRight--;
    }
     return new StdString2(subString(spaceLeft, spaceRight + 1));
    }


}

