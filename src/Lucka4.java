import java.util.Scanner;

public class Lucka4 {

    private Scanner sc;

    public Lucka4(Scanner sc) {
        this.sc = sc;
    }

    // Is 'a' a subset of 'b'?
    public boolean isSubset(int a1, int a2, int b1, int b2) {
        return b1 <= a1 && a2 <= b2;
    }

    public int[] getNumbers(String s) {
        int[] res = new int[4];
        String[] sArr = s.split(",");
        res[0] = Integer.parseInt(sArr[0].substring(0, sArr[0].indexOf('-')));
        res[1] = Integer.parseInt(sArr[0].substring(sArr[0].indexOf('-')+1));
        res[2] = Integer.parseInt(sArr[1].substring(0, sArr[1].indexOf('-')));
        res[3] = Integer.parseInt(sArr[1].substring(sArr[1].indexOf('-')+1));
        return res;
    }

    public int solve1() {
        int res = 0;
        int[] arr;
        while(sc.hasNextLine()) {
            arr = getNumbers(sc.nextLine());
            if(isSubset(arr[0], arr[1], arr[2], arr[3]) || isSubset(arr[2], arr[3], arr[0], arr[1])) res++;
        }
        return res;
    }

    // Do the sets intersect?
    public boolean overlap(int a1, int a2, int b1, int b2) {
        return a1 >= b1 && a1 <= b2 || a2 >= b1 && a2 <= b2;
    }

    public int solve2() {
        int res = 0;
        int[] arr;
        while(sc.hasNextLine()) {
            arr = getNumbers(sc.nextLine());
            if(overlap(arr[0], arr[1], arr[2], arr[3]) || overlap(arr[2], arr[3], arr[0], arr[1])) res++;
        }
        return res;
    }


}
