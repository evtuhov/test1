package academy.kovalevskyi.codingbootcamp.week1.day0;

public class NumberUtils {

    public static void main(String[] args) {
        System.out.println("Usaul factorial calculation " + getFactorial(3));
        System.out.println("Recursive factorial calculation: " + factorialRecursive(20));
        System.out.println("degree calculation: " + power(2, 2));
        System.out.println("Recursive degree calculation: " + powerRecursive(2, 2));
        System.out.println("sqrt: " + sqrt(9));
        System.out.println("isPrime: " + isPrime(31));
        System.out.println("findNextPrime: " + findNextPrime(5));
    }

    //The usual factorial calculation
    public static long getFactorial(final int number) {
        if (number < 0 || number > 20) {
            System.out.println("errrrr");
            throw new IllegalArgumentException("error");

        } else {
            long factorial = 1;
            for (int i = 2; i <= number; i++) {
                //factorial = factorial * i;
                factorial *= i;
            }
            return factorial;
        }
    }

    //Recursive factorial calculation
    public static long factorialRecursive(int number) {
        verifyFactorial(number);

        if (number < 2) {
            return 1;
        }
        return number * factorialRecursive(number - 1);
    }

    private static void verifyFactorial(int number) {
        if (number < 0 || number > 20) {
            throw new IllegalArgumentException("error");
        }
    }

    //Обычное вычисление степени
    public static double power(int base, int power) {
        double result = 1;
        if (power < 0) {
            for (int i = power; i < 0; i++) {
                result /= base;
            }
        } else {
            for (int i = 1; i <= power; i++) {
                result *= base;
            }
        }
        return result;
    }

    //Рекурсивное вычисление степени
    public static double powerRecursive(int base, int power) {

        if (power == 0) {
            return 1;
        }
        if (power == 1) {
            return base;
        }
        if (power < 0) {
            return power(base, power);
        }
        return base * powerRecursive(base, power - 1);
    }

    //Вычисление числа фибоначчи
    public static int fibRecursive(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        if (index < 2) {
            return index;
        }
        return fibRecursive(index - 1) + fibRecursive(index - 2);
    }

    //Вычисление ряда фибоначчи
    public static int[] fibSequence(int length) {
        if (length < 0) {
            throw new IllegalArgumentException();
        } else {
            int[] fibSequence = new int[length];

            for (int i = 0; i < length; i++) {
                fibSequence[i] = fibRecursive(i);
            }
            return fibSequence;
        }
    }

    //Корень квадратный
    public static int sqrt(int target) {
        if (target < 1) {
            throw new IllegalArgumentException();
        }
        if (target < 2) {
            return target;
        }
        long num;
        int num2;
        int left = 2;
        int right = target / 2;
        while (left <= right) {
            num2 = left + (right - left) / 2;
            num = (long) num2 * num2;
            if (num > target) {
                right = num2 - 1;
            } else if (num < target) {
                left = num2 + 1;
            } else {
                return num2;
            }
        }
        return -1;
    }

    //Простое число
    public static boolean isPrime(int target) {
        //if (target < 0) {
        //  throw new IllegalArgumentException();
        //}
        verifyNegative(target);
        if (target < 2) {
            return false;
        }
        boolean isPrime = true;

        for (int i = 2; i <= target / 2; i++) {
            if (target % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    //Поиск простого числа
    public static int findNextPrime(int target) {
        //if (target < 0) {
        //  throw new IllegalArgumentException();
        //}
        verifyNegative(target);

        boolean result = false;
        int tmp = target;
        while (true) {
            if (isPrime(tmp)) {
                break;
            }
            tmp++;
        }
        return tmp;
    }

    private static void verifyNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void sort(int[] target) {

        if (target == null || target.length == 0) {
            return;
        }
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < target.length - 1; i++) {
                if (target[i] > target[i + 1]) {
                    int tmp = target[i];
                    target[i] = target[i + 1];
                    target[i + 1] = tmp;
                    isSorted = false;
                }
            }
        }
    }
}
