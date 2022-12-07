import java.util.Scanner;

public class Day1 {

    private Scanner sc;

    public Day1(Scanner sc) {
        this.sc = sc;
    }

    public int solve1() {
        int res = 0, currentElf = 0;
        String read;

        while(sc.hasNextLine()) {
            read = sc.nextLine();
            if(read.equals("")) {
                if(res < currentElf) res = currentElf;
                currentElf = 0;
            }
            else currentElf += Integer.parseInt(read);
        }

        //In order to check the last elf
        if(currentElf > res) res = currentElf;

        return res;
    }

    public int solve2() {
        String read;
        int currentElf = 0, top1 = 0, top2 = 0, top3 = 0;

        while(sc.hasNextLine()) {
            read = sc.nextLine();
            if(read.equals("")) {
                if(currentElf > top1) {
                    top3 = top2;
                    top2 = top1;
                    top1 = currentElf;
                }
                else if(currentElf > top2) {
                    top3 = top2;
                    top2 = currentElf;
                }
                else if(currentElf > top3) top3 = currentElf;
                currentElf = 0;
            }
            else currentElf += Integer.parseInt(read);
        }

        //In order to include the last elf
        if(currentElf > top1) {
            top3 = top2;
            top2 = top1;
            top1 = currentElf;
        }
        else if(currentElf > top2) {
            top3 = top2;
            top2 = currentElf;
        }
        else if(currentElf > top3) top3 = currentElf;

        return top1 + top2 + top3;
    }


}
