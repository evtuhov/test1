package academy.kovalevskyi.codingbootcamp.week2.day1;


import academy.kovalevskyi.codingbootcamp.week2.day1.models.Box;
import academy.kovalevskyi.codingbootcamp.week2.day1.view.*;

import java.sql.SQLOutput;

public class Main {
    public static void main (String args[]) {
      Box.Builder builder = new Box.Builder();
//      Box box = builder.width(6).height(8).wall("h").corner("f").message("Stri").build();
//      System.out.println(box);
//
//      Box.Builder builder1 = new Box.Builder();
//      builder1 = builder1.width(6);
//      builder1 = builder1.height(8);
//      builder1 = builder1.wall("h");
//      builder1 = builder1.corner("s");
//      builder1 = builder1.message("sdsd");
//      Box box1 = builder1.build();
//      System.out.println(box1);

      //"Box[width=15, height=3, wall=^, corner=*, message=Text in box]"



      Box box2 = new Box(15, 3, "^", "*", "Text in box");

      Printer printer = new ConsolePrinter();
      Reader reader = new KeyboardReader();
      BoxView boxView = new BoxView(printer, reader);
      boxView.drawBox(box2);





//      String str = "";
//      System.out.println(str == null || str.isEmpty());    // true




    }




}
