import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Day9 {
    private Scanner sc;

    public Day9(Scanner sc) {
        this.sc = sc;
    }

    private ArrayList<String> getInput() {
        ArrayList<String> res = new ArrayList<>();
        while(sc.hasNextLine()) {
            res.add(sc.nextLine());
        }
        return res;
    }

    public double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2)+ Math.pow(y1-y2, 2));
    }

    public double angle(int x1, int y1, int x2, int y2) {
        double res = Math.atan2(y2 - y1, x2 - x1) * (180 / Math.PI);
        if(res >= 0) return res;
        else return 360+res;
    }

    public int[] moveHead(String dir, int[] pos) {
        switch (dir) {
            case "U" -> pos[1]++;
            case "D" -> pos[1]--;
            case "R" -> pos[0]++;
            case "L" -> pos[0]--;
        }
        return pos;
    }

    public int[] moveTail(int a, int[] pos) {
        switch (a) {
            case 0 -> pos[0]++;
            case 90 -> pos[1]++;
            case 180 -> pos[0]--;
            case 270 -> pos[1]--;
        }
        if(0 < a && a < 90) {
            pos[0]++;
            pos[1]++;
        }
        else if(90 < a && a < 180) {
            pos[0]--;
            pos[1]++;
        }
        else if(180 < a && a < 270) {
            pos[0]--;
            pos[1]--;
        }
        else if(270 < a && a < 360) {
            pos[0]++;
            pos[1]--;
        }
        return pos;
    }

    public int solve1() {
        ArrayList<String> ls = getInput();
        HashSet<String> visited = new HashSet<>();
        visited.add("0,0");
        int[] head = {0,0}, tail = {0,0};
        for(String s : ls) {
            String dir = s.split(" ")[0];
            int moves = Integer.parseInt(s.split(" ")[1]);
            for(int i = 0; i < moves; i++) {
                head = moveHead(dir, head);
                if((int)distance(tail[0], tail[1], head[0], head[1]) > 1) {
                    int angle = (int) angle(tail[0], tail[1], head[0], head[1]);
                    tail = moveTail(angle, tail);
                    visited.add(tail[0] + "," + tail[1]);
                }
            }
        }
        return visited.size();
    }

    public int solve2() {
        ArrayList<String> ls = getInput();
        HashSet<String> visited = new HashSet<>();
        visited.add("0,0");
        int[][] rope = new int[10][2];
        for(int i = 0; i < rope.length; i++) {
            rope[i][0] = 0;
            rope[i][1] = 0;
        }
        for(String s : ls) {
            String dir = s.split(" ")[0];
            int moves = Integer.parseInt(s.split(" ")[1]);
            for(int i = 0; i < moves; i++) {
                rope[0] = moveHead(dir, rope[0]);
                for(int j = 1; j < rope.length; j++) {
                    if((int)distance(rope[j][0], rope[j][1], rope[j-1][0], rope[j-1][1]) > 1) {
                        int angle = (int) angle(rope[j][0], rope[j][1], rope[j-1][0], rope[j-1][1]);
                        rope[j] = moveTail(angle, rope[j]);
                        if(j == rope.length-1) visited.add(rope[j][0] + "," + rope[j][1]);

                    }
                }
            }
        }
        return visited.size();
    }
}
