import java.util.Scanner;

public class Lucka3 {

    private Scanner sc;

    public Lucka3(Scanner sc) {
        this.sc = sc;
    }

    private char findDuplicate(String s) {
        String part1 = s.substring(0, s.length()/2);
        char[] part2 = s.substring(s.length()/2).toCharArray();
        for(int i = 0; i < part1.length(); i++) {
            for (char c : part2) {
                if (part1.charAt(i) == c) {
                    return c;
                }
            }
        }
        return ' ';
    }

    private int getPriority(char c) {
        if(Character.isUpperCase(c)) {
            return ((int) c)  - 38;
        }
        else {
            return ((int) c) - 96;
        }
    }

    public int solve1() {
        int res = 0;
        char dup;
        while(sc.hasNextLine()) {
            dup = findDuplicate(sc.nextLine());
            res += getPriority(dup);
        }
        return res;
    }

}
