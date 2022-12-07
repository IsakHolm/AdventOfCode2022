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
                    Lucka1 lucka = new Lucka1(sc);
                    System.out.println(lucka.solve1());
                }
                else {
                    Lucka1 lucka = new Lucka1(sc);
                    System.out.println(lucka.solve2());
                }
                break;
            case 2:
                if(arg1 == 1) {
                    Lucka2 lucka = new Lucka2(sc);
                    System.out.println(lucka.solve1());
                }
                else {
                    Lucka2 lucka = new Lucka2(sc);
                    System.out.println(lucka.solve2());
                }
            case 3:
                if(arg1 == 1) {
                    Lucka3 lucka = new Lucka3(sc);
                    System.out.println(lucka.solve1());
                }
                else {
                    Lucka3 lucka = new Lucka3(sc);
                    System.out.println(lucka.solve2());
                }
            case 4:
                if(arg1 == 1) {
                    Lucka4 lucka = new Lucka4(sc);
                    System.out.println(lucka.solve1());
                }
                else {
                    Lucka4 lucka = new Lucka4(sc);
                    System.out.println(lucka.solve2());
                }
            case 5:
                if(arg1 == 1) {
                    Lucka5 lucka = new Lucka5(sc);
                    System.out.println(lucka.solve1());
                }
                else {
                    Lucka5 lucka = new Lucka5(sc);
                    System.out.println(lucka.solve2());
                }
        }
    }

}
