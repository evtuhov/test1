package academy.kovalevskyi.codingbootcamp.week2.day1.controllers;

import academy.kovalevskyi.codingbootcamp.week2.day1.models.Box;

public class BoxController {
  public Box madeBoxWithText(String text) {
    int width = text.length() + 4;
    Box.Builder builder = new Box.Builder();
    Box box = builder.width(width).height(3).wall("#").corner("%").message(text).build();
    return box;
  }

  public Box madeBoxWithText(String text, String wall, String corner) {
    int width = text.length() + 4;
    Box.Builder builder = new Box.Builder();
    Box box = builder.width(width).height(3).wall(wall).corner(corner).message(text).build();
    return box;
  }

  public Box shiftNumberInTheTextInBox(Box box) {
    int width = box.width();
    int height = box.height();
    String wall = box.wall();
    String corner = box.corner();
    String message = box.message();
    String newMessage = changeMessage(message);
    Box.Builder builder = new Box.Builder();
    Box newBox = builder.width(width)
            .height(height).
            wall(wall).
            corner(corner).message(newMessage).build();
    return newBox;
  }

  private static String changeMessage(String message) {
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < message.length(); i++) {
      char currentSymbol = message.charAt(i);
      boolean isDigit = Character.isDigit(currentSymbol);
      if (isDigit) {
        int value = currentSymbol - '0';
        value++;
        value = value % 10;
        char newSymbol = (char) (value + '0');
        builder.append(newSymbol);
      } else {
        builder.append(currentSymbol);
      }
    }
    return builder.toString();
  }

  public Box replaceMessage(Box box, String newMessage) {
    int height = box.height();
    String wall = box.wall();
    String corner = box.corner();
    int newWidth = calcWidth(newMessage);
    //int newWidth = newMessage.length() + 4;
    Box.Builder builder = new Box.Builder();
    Box newBox = builder.width(newWidth).height(height).wall(wall).corner(corner).message(newMessage).build();
    return newBox;
  }

  private static int calcWidth(String message) {
    return message.length() + 4;
  }
}



