import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Lucka2 {

    private Scanner sc;

    public Lucka2(Scanner sc) {
        this.sc = sc;
    }

    private static class RPS { //Rock Paper Scissors
        private String type;
        public RPS(String s, int solv) {
            if(solv == 1) {
                if(s.equals("A") || s.equals("X")) type = "Rock";
                else if(s.equals("B") || s.equals("Y")) type = "Paper";
                else if(s.equals("C") || s.equals("Z")) type = "Scissor";
            }
            else {
                if(s.equals("A")) type = "Rock";
                else if(s.equals("B")) type = "Paper";
                else if(s.equals("C")) type = "Scissor";
                else type = s;
            }
        }

        /**
         * Find out if a hand is the winner, and returns the correct score
         * @param hand1 'My' hand
         * @param hand2 The opponents hand
         * @return The score based on if hand1 wins or loses, and also based on the type being played
         */
        public static int getScore(RPS hand1, RPS hand2) {
            int score;
            String a = hand1.type;
            String b = hand2.type;

            if(a.equals("Rock")) score = 1;
            else if(a.equals("Paper")) score = 2;
            else score = 3;

            if(a.equals("Rock") && b.equals("Rock") || a.equals("Paper") && b.equals("Paper") || a.equals("Scissor") && b.equals("Scissor")) return score+3;
            if(a.equals("Rock") && b.equals("Scissor") || a.equals("Scissor") && b.equals("Paper") || a.equals("Paper") && b.equals("Rock")) return score+6;
            return score;
        }

        /**
         * This method modifies this hand based on the type. Use this before getScore()
         * @param opponentHand The opponent hand that either has to be defeated, lost to or get a draw with
         */
        public void modifyHand(RPS opponentHand) {
            if(this.type.equals("X")) {
                if(opponentHand.type.equals("Rock")) this.type = "Scissor";
                else if(opponentHand.type.equals("Paper")) this.type = "Rock";
                else this.type = "Paper";
            }
            else if(this.type.equals("Y")) {
                if(opponentHand.type.equals("Rock")) this.type = "Rock";
                else if(opponentHand.type.equals("Paper")) this.type = "Paper";
                else this.type = "Scissor";
            }
            else if(this.type.equals("Z")) {
                if(opponentHand.type.equals("Rock")) this.type = "Paper";
                else if(opponentHand.type.equals("Paper")) this.type = "Scissor";
                else this.type = "Rock";
            }
        }

    }

    public int solve1() {

        RPS myHand, opponentHand;
        int total_score = 0;

        while(sc.hasNextLine()) {
            String arr[] = sc.nextLine().split(" ");
            opponentHand = new RPS(arr[0], 1);
            myHand = new RPS(arr[1], 1);
            total_score += RPS.getScore(myHand, opponentHand);
        }

        return total_score;
    }

    public int solve2() {
        RPS myHand, opponentHand;
        int total_score = 0;

        while(sc.hasNextLine()) {
            String arr[] = sc.nextLine().split(" ");
            opponentHand = new RPS(arr[0], 2);
            myHand = new RPS(arr[1], 2);
            myHand.modifyHand(opponentHand);
            total_score += RPS.getScore(myHand, opponentHand);
        }

        return total_score;
    }


}
