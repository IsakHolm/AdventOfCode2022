import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Day5 {

    private Scanner sc;

    public Day5(Scanner sc) {
        this.sc = sc;
    }

    public ArrayList<Stack<Character>> readCrates() {
        ArrayList<String> sArr = new ArrayList<>();
        int piles = 0;
        while(true) {
            sArr.add(sc.nextLine());
            if(sArr.get(sArr.size()-1).charAt(1) == '1') {
                piles = (sArr.get(sArr.size()-1).length()+2) / 4;
                sArr.remove(sArr.size()-1);
                break;
            }
        }
        if(piles == 0) throw new IllegalArgumentException("No piles found");
        ArrayList<Stack<Character>> res = new ArrayList<>();
        for(int i = 0; i < piles; i++) {
            res.add(new Stack<>());
        }
        for(int i = sArr.size()-1; i >= 0; i--) {
            for(int j = 1; j <= piles; j++) {
                char tmp = sArr.get(i).charAt(1 + (j-1) * 4);
                if(tmp != ' ') res.get(j-1).push(tmp);
            }
        }
        return res;
    }

    public int[] extractInstructions(String ins) {
        String[] splits = ins.split(" ");
        return new int[]{Integer.parseInt(splits[1]), Integer.parseInt(splits[3]), Integer.parseInt(splits[5])};
    }

    public String solve1() {
        String res = "";
        ArrayList<Stack<Character>> list = readCrates();
        sc.nextLine(); // Get rid of empty line before instructions
        while(sc.hasNextLine()) {
            int[] ins = extractInstructions(sc.nextLine());
            for(int i = 0; i < ins[0]; i++) {
                list.get(ins[2]-1).push(list.get(ins[1]-1).pop());
            }
        }
        for (Stack<Character> s : list) {
            res = res.concat(Character.toString(s.pop()));
        }
        return res;
    }

    public String solve2() {
        String res = "";
        ArrayList<Stack<Character>> list = readCrates();
        sc.nextLine(); // Get rid of empty line before instructions
        while(sc.hasNextLine()) {
            int[] ins = extractInstructions(sc.nextLine());
            Stack<Character> tmpStack = new Stack<>();
            for(int i = 0; i < ins[0]; i++) {
                tmpStack.push(list.get(ins[1]-1).pop());
            }
            for(int i = 0; i < ins[0]; i++) {
                list.get(ins[2]-1).push(tmpStack.pop());
            }
        }
        for (Stack<Character> s : list) {
            res = res.concat(Character.toString(s.pop()));
        }
        return res;
    }

}
