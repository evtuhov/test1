package academy.kovalevskyi.codingbootcamp.week2.day2;

public class Calculator {
  public static void main(String[] args) {
    if (args.length != 3) {
      System.out.println("Please provide 3 input arguments, example: 2 + 3");
      return;
    }
    try {
      boolean isDouble = args[0].contains(".") || args[2].contains(".");
      Number result = null;
      if (isDouble || args[1].equalsIgnoreCase("/"))  {
        if (args[1].equalsIgnoreCase("/") && args[2].equalsIgnoreCase("0")) {
          throw new ArithmeticException();
        }
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[2]);
        result = calculate(Double.parseDouble(args[0]), args[1], b);
      } else {
        long a = Long.parseLong(args[0]);
        long b = Long.parseLong(args[2]);
        result = calculate(a, args[1], b);
      }
      System.out.println("result: " + result);
    } catch (NumberFormatException e) {
      throw  new IllegalArgumentException("Fail convert!");
    } catch (ArithmeticException e) {
      System.out.println("Division by zero is impossible!");
    }
  }
  private static Long calculate(long a, String operator, long b) {
    return switch (operator) {
      case "+" -> a + b;
      case "-" -> a - b;
      case "*" -> a * b;
      case "/" -> a / b;
      case "%" -> a % b;
      default -> throw new IllegalArgumentException("Illegal operator: " + operator);
     };
  }
  private static Double calculate(double a, String operator, double b) {
    return switch (operator) {
      case "+" -> a + b;
      case "-" -> a - b;
      case "*" -> a * b;
      case "/" -> a / b;
      case "%" -> a % b;
      default -> throw new IllegalArgumentException("Illegal operator: " + operator);
    };
  }
}
