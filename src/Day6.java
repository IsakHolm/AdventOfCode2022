import java.util.Scanner;

public class Day6 {

    private Scanner sc;

    public Day6(Scanner sc) {
        this.sc = sc;
    }

    public int startOf(String msg,int requiredUnique) {
        int end = requiredUnique;
        boolean noDup;
        String current = msg.substring(0, end);
        while(true) {
            noDup = true;
            for (int i = 0; i < current.length(); i++) {
                if(current.replaceFirst(Character.toString(current.charAt(i)), " ").contains(Character.toString(current.charAt(i)))) {
                    noDup = false;
                    break;
                }
            }
            if(noDup) break;
            current = current.concat(Character.toString(msg.charAt(end++)));
            current = current.substring(1);
        }
        return end;
    }

    public int solve1() {
        String msg = sc.nextLine();
        return startOf(msg, 4);
    }

    public int solve2() {
        String msg = sc.nextLine();
        return startOf(msg, 14);
    }

}
