import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class app {

    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(args[2]));
        }
        catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        int arg0 = Integer.parseInt(args[0]); //The day
        int arg1 = Integer.parseInt(args[1]); //The problem for this day (1 or 2)
 
        switch(arg0) {
            case 1:
                if(arg1 == 1) {
                    Day1 day = new Day1(sc);
                    System.out.println(day.solve1());
                }
                else {
                    Day1 day = new Day1(sc);
                    System.out.println(day.solve2());
                }
                break;
            case 2:
                if(arg1 == 1) {
                    Day2 day = new Day2(sc);
                    System.out.println(day.solve1());
                }
                else {
                    Day2 day = new Day2(sc);
                    System.out.println(day.solve2());
                }
            case 3:
                if(arg1 == 1) {
                    Day3 day = new Day3(sc);
                    System.out.println(day.solve1());
                }
                else {
                    Day3 day = new Day3(sc);
                    System.out.println(day.solve2());
                }
            case 4:
                if(arg1 == 1) {
                    Day4 day = new Day4(sc);
                    System.out.println(day.solve1());
                }
                else {
                    Day4 day = new Day4(sc);
                    System.out.println(day.solve2());
                }
            case 5:
                if(arg1 == 1) {
                    Day5 day = new Day5(sc);
                    System.out.println(day.solve1());
                }
                else {
                    Day5 day = new Day5(sc);
                    System.out.println(day.solve2());
                }
            case 6:
                if(arg1 == 1) {
                    Day6 day = new Day6(sc);
                    System.out.println(day.solve1());
                }
                else {
                    Day6 day = new Day6(sc);
                    System.out.println(day.solve2());
                }
            case 7:
                if(arg1 == 1) {
                    Day7 day = new Day7(sc);
                    System.out.println(day.solve1());
                }
                else {
                    Day7 day = new Day7(sc);
                    System.out.println(day.solve2());
                }
        }
    }

}
