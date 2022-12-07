import java.util.Scanner;

public class Day3 {

    private Scanner sc;

    public Day3(Scanner sc) {
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

    private char findCommonChar(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        for(char c : c1) {
            for(char d : c2) {
                if(c == d) {
                    for(char e : c3) {
                        if(e == d) return e;
                    }
                }
            }
        }
        return ' ';
    }

    public int solve2() {
        int res = 0;
        char common;
        while(sc.hasNextLine()) {
            common = findCommonChar(sc.nextLine(), sc.nextLine(), sc.nextLine());
            res += getPriority(common);
        }
        return res;
    }

}
