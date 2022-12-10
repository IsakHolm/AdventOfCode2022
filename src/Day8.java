import java.util.ArrayList;
import java.util.Scanner;

public class Day8 {

    private Scanner sc;

    public Day8(Scanner sc) {
        this.sc = sc;
    }

    public int[][] getForestArray(ArrayList<String> ls) {
        int[][] res = new int[ls.size()][];
        for(int i = 0; i < res.length; i++) {
            res[i] = new int[ls.get(0).length()]; // Need to instantiate outside for loop because of scope
        }
        for(int i = 0; i < ls.size(); i++) {
            char[] cArr = ls.get(i).toCharArray();
            for(int j = 0; j < cArr.length; j++) {
                res[i][j] = Character.getNumericValue(cArr[j]);
            }
        }
        return res;
    }

    public boolean isHidden(int[][] forest, int row, int col) {
        if(row == 0 || row == forest.length-1 || col == 0 || col == forest[row].length-1) return false; // Is outermost tree
        boolean hiddenUp = false;
        boolean hiddenDown = false;
        boolean hiddenLeft = false;
        boolean hiddenRight = false;

        for(int i = 0; i < row; i++) {
            if(forest[i][col] >= forest[row][col]) {
                hiddenUp = true;
                break;
            }
        }
        for(int i = row+1; i < forest.length; i++) {
            if(forest[i][col] >= forest[row][col]) {
                hiddenDown = true;
                break;
            }
        }
        for(int i = 0; i < col; i++) {
            if(forest[row][i] >= forest[row][col]) {
                hiddenLeft = true;
                break;
            }
        }
        for(int i = col+1; i < forest[row].length; i++) {
            if(forest[row][i] >= forest[row][col]) {
                hiddenRight = true;
                break;
            }
        }
        return hiddenUp && hiddenDown && hiddenLeft && hiddenRight;
    }

    public int solve1() {
        ArrayList<String> input = new ArrayList<>();
        while(sc.hasNextLine()) {
            input.add(sc.nextLine());
        }
        int[][] forest = getForestArray(input);
        int res = 0;
        for(int i = 0; i < forest.length; i++) {
            for(int j = 0; j < forest[i].length; j++) {
                if(!isHidden(forest, i, j)) res++;
            }
        }
        return res;
    }

    public int getScenicScore(int[][] forest, int row, int col) {
        int scoreUp = 0, scoreDown = 0, scoreLeft = 0, scoreRight = 0;
        for(int i = row; i > 0; i--) {
            scoreUp++;
            if(forest[i-1][col] >= forest[row][col]) break;
        }
        for(int i = row; i < forest.length-1; i++) {
            scoreDown++;
            if(forest[i+1][col] >= forest[row][col]) break;
        }
        for(int i = col; i > 0; i--) {
            scoreLeft++;
            if(forest[row][i-1] >= forest[row][col]) break;
        }
        for(int i = col; i < forest[row].length-1; i++) {
            scoreRight++;
            if(forest[row][i+1] >= forest[row][col]) break;
        }
        return scoreUp * scoreDown * scoreLeft * scoreRight;
    }

    public int solve2() {
        ArrayList<String> input = new ArrayList<>();
        while(sc.hasNextLine()) {
            input.add(sc.nextLine());
        }
        int[][] forest = getForestArray(input);
        int res = 0;
        for(int i = 0; i < forest.length; i++) {
            for(int j = 0; j < forest[i].length; j++) {
                int score = getScenicScore(forest, i, j);
                if(score > res) res = score;
            }
        }
        return res;
    }

}
