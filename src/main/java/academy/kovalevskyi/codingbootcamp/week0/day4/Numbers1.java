package academy.kovalevskyi.codingbootcamp.week0.day4;

public class Numbers1 {

    public static void main(String[] args) {
        //System.out.println(indexForMax);
        // int[] nums = new int[100];
        //Вывод массива от 0 до 99
        System.out.println(generateNumbers());
        //Возвращает большее из 2-х чисел
        System.out.println(findBiggest(5, 10));
        //Возвращает большее из 3-х чисел
        System.out.println(findBiggest(35, 25, 10));
//    //System.out.println(findBiggest(new int[]{5,18,3}));
        //метод принимает на вход массив целых чисел, а вернуть должен самое большое число в этом массиве
        System.out.println(findBiggest(new int[]{5543, 145, 2264, 545, 2}));
//    //индекс любого самого большого числа в массиве
        System.out.println(findIndexOfBiggestNumber(new int[]{555, 1000, 3}));
//    // System.out.println(findIndexOfBiggestNumber(new int[10]));
//    //метод принимает на вход целое число и отвечает на вопрос: “Оно отрицательное?
        System.out.println(isNegative(5));
        //  System.out.print(Numbers1.convertToCharArray(-2147483));
        System.out.println(convertToCharArray(-358));
    }

    public static int[] generateNumbers() {
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
            System.out.print(numbers[i] + " ");
        }
        return numbers;
    }

    public static int findBiggest(int left, int right) {
        return left > right ? left : right;
    }


    public static int findBiggest(int left, int mid, int right) {
        //   int  max = left > mid ? left : mid;
        //   return max > right ? max : right;
        return findBiggest(findBiggest(left, mid), right);
    }

//    public static int findBiggest(int[] numbers) {
//        int max = numbers[0];
//        for (int item : numbers) {
//            if (item > max) {
//                max = item;
//            }
//        }
//        return max;
//    }


    public static int findBiggest(int[] numbers) {
        int imax = findIndexOfBiggestNumber(numbers);
        return numbers[imax];
    }


    public static int findIndexOfBiggestNumber(int[] numbers) {
        //    int[] numbers = {43, 45, 64, 545, 2};
        int max = numbers[0];
        int imax = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                imax = i;
            }
        }
        return imax;
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }


    //  public static char[] convertToCharArray(int number) {
    //    if (number == 0) {
    //      return new char[]{'0'};
    //    }

    //    int count = 0;
    //    int n = number;

    //    while (number != 0) {
    //      count++;
    //      number /= 10;
    //    }

    //    int[] digits = new int[count];

    //   for (int i = count - 1; i >= 0; i--) {
    //     digits[i] = n % 10;
    //     n /= 10;
    //   }

    //   for (int i = 1; i < digits.length; i++) {
    //     if (isNegative(digits[i])) {
    //       digits[i] *= -1;}
    //     }
    //   }

    // if (isNegative(number)) {
    //char[] charsPositiveNumber = new char[count];
    //  char[] charsNegativeNumber = new char[count + 1];

    //  if (isNegative(digits[0])) {
    //    charsNegativeNumber[0] = '-';
    //    charsNegativeNumber[1] = (char) ((digits[0] * -1) + '0');
    //    for (int i = 1; i < digits.length; i++) {
    //      charsNegativeNumber[i + 1] = (char) (digits[i] + '0';
    //    }
    //  }

    //  for(int i = 0; i < digits.length; i++) {
    //    charPositiveNumber[i] = (char) (digits[i] + '0';
    //  }

    //    return isNegative(digits[0]) ? charsNegativeNumber : charsPositiveNumber;

    // }

//  public static char[] convertToCharArray(int number) {
//
//        if (number == 0) {
//            //return new char[]{48};
//            // return new char[0];
//            return new char[]{'0'};
//        }
//
//        int minus = isNegative(number) ? 1 : 0;
//        int min = number == Integer.MIN_VALUE ? 1 : 0;
//
//        char[] positiveCharArray = convertPositiveToCharArray(number + min);
//        char[] charArray = new char[positiveCharArray.length + minus];
//        if (minus == 1) {
//            ///charArray[0] = 45;
//            charArray[0] = '-';
//        }
//        for (int i = 0; i < positiveCharArray.length; i++) {
//            charArray[i + minus] = positiveCharArray[i];
//        }
//
//        charArray[charArray.length - 1] = (char) (charArray[charArray.length - 1] + min);
//        //charArray= convertPositiveToCharArray(number);
//        return charArray;
//    }

//  private static char[] convertPositiveToCharArray(int number) {
//
//        //if (number==Integer.MIN_VALUE){return new char[]{48};}
//    int num = number < 0 ? -number : number;
//    int length = 0;
//    while (num > 0) {
//       length++;
//       // num = num / 10;  //strip out the last digit
//       num /= 10;
//       }
//       num = number < 0 ? -1 * number : number;
//       System.out.println(length);
//       System.out.println(num);
//       char[] arr;
//       arr = new char[length];
//       for (int i = length - 1; i >= 0; i--) {
//            //int tmp = (num % 10) + 48;
//            //int tmp = (num % 10) + '0';
//            //arr[length - i] = (char) (num % 10 + 48);
//
//            arr[i] = (char) (num % 10 + '0');
//            num /= 10;
//
//        }
//        return arr;
//    }



//    public static char[] convertToCharArray(int number) {
//        char[] allNumbers = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
//        char[] result;
//        int i = 0;
//        int temp = number;
//       //если число отрицательное делаем его положительным
//        if (number < 0) {
//            temp *= -1;
//            i++;
//        }
//        //вычисляем кол-во цифр в числе
//        while (temp >= 1) {
//            temp = temp / 10;
//            i++;
//            System.out.println(temp);
//        }
//
//        //манипуляции с минусом и запись результата в массив
//        if (number < 0) {
//            result = new char[i];
//            result[0] = '-';
//            temp = -1 * number;
//        } else if (number > 0) {
//            result = new char[i];
//            temp = number;
//        } else {
//            result = new char[]{'0'};
//        }
//
//        int temp2 = 0;
//        while (temp >= 1) {
//            temp2 = temp % 10;
//            temp = temp / 10;
//            i--;
//            result[i] = allNumbers[temp2];
//        }
//        if (number == Integer.MIN_VALUE) {
//            return new char[] {'-', '2', '1', '4', '7', '4', '8', '3', '6', '4', '8'};
//        }
//
//        return result;
//    }



    public static char[] convertToCharArray(int number) {
        int temp = number;
        int arrSize = len(number);
        char[] result = new char[arrSize];

        if (number < 0) {
            result[0] = '-';
        } else if (number > 0) {
            temp = -1 * number;
        } else {
            result = new char[]{'0'};
        }

        int i = arrSize - 1;
        while (temp != 0) {
            int temp2 = temp % 10;
            temp = temp / 10;
            result[i] = (char) ('0' - temp2);
            i--;
        }
        return result;
    }

    public static int len(int number) {
        int i = number <= 0 ? 1 : 0;
        while (number != 0) {
            number = number / 10;
            i++;
        }
        return i;
    }





}

