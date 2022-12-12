import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Day10 {

    private Scanner sc;

    public Day10(Scanner sc) {
        this.sc = sc;
    }

    public int solve1() {
        ArrayList<Integer> registerValues = new ArrayList<>();
        int cycle = 20, i = 1, X = 1;
        while(sc.hasNextLine()) {
            String[] command = sc.nextLine().split(" ");
            if(command.length == 1) { // The noop command
                i++;
            }
            else { // The addx command
                i++;
                if(i == cycle) {
                    registerValues.add(X*i);
                    cycle += 40;
                }
                i++;
                X += Integer.parseInt(command[1]);
            }
            if(i == cycle) {
                registerValues.add(X*i);
                cycle += 40;
            }
        }
        int res = 0;
        for(Integer z : registerValues) {
            res += z;
        }
        return res;
    }

    public String solve2() {
        String res = "";
        String[] command = {};
        int SpritePos = 2, CRTWidth = 40, cycle = 1, tmpAdd = 0;
        while(sc.hasNextLine()) {
            if(cycle % CRTWidth == SpritePos-1 || cycle % CRTWidth == SpritePos || cycle % CRTWidth == SpritePos+1) res = res.concat("#");
            else res = res.concat(" ");
            if(cycle % CRTWidth == 0) res = res.concat("\n");
            if(tmpAdd == 0) {
                command = sc.nextLine().split(" ");
                if(command.length == 2) { // The addx command
                    tmpAdd = Integer.parseInt(command[1]);
                }
            }
            else {
                SpritePos += tmpAdd;
                tmpAdd = 0;
            }
            cycle++;
        }
        return res;
    }

}
