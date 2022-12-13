import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day11 {

    private Scanner sc;
    private int test_product = 1;

    private class Monkey implements Comparable<Monkey> {
        private int nr, throwTrue, throwFalse, test, inspects;
        private boolean part1;
        private ArrayList<Long> items;
        private String operation;

        Monkey(int nr, int t, int f, int test, String op, boolean part1) {
            this.nr = nr;
            throwTrue = t;
            throwFalse = f;
            items = new ArrayList<>();
            this.test = test;
            operation = op;
            inspects = 0;
            this.part1 = part1;
        }

        long[] inspect() {
            inspects++;
            long tmpItem = items.remove(0);
            tmpItem = operate(tmpItem);
            if(part1) tmpItem /= 3;
            if(tmpItem % test == 0) return new long[] {throwTrue, tmpItem};
            return new long[] {throwFalse, tmpItem};
        }

        long operate(long old) {
            long x;
            if(operation.split(" ")[1].equals("old")) x = old;
            else x = Integer.parseInt(operation.split(" ")[1]);
            return switch (operation.split(" ")[0]) {
                case "+" -> old + x;
                case "-" -> old - x;
                case "*" -> old * x;
                default -> 0;
            };
        }

        @Override
        public int compareTo(Monkey o) {
            return Integer.compare(inspects, o.inspects);
        }

    }

    // Requires that scanner has not read any lines
    private ArrayList<Monkey> createMonkeys(boolean part1) {
        ArrayList<Monkey> monkeys = new ArrayList<>();
        int nr = 0;
        while (sc.hasNextLine()) {
            sc.nextLine();
            String[] items = sc.nextLine().strip().split(" ");
            String operation = sc.nextLine().split(" = old ")[1];
            String[] tmpString = sc.nextLine().split(" ");
            int test = Integer.parseInt(tmpString[tmpString.length-1]);
            tmpString = sc.nextLine().split(" ");
            int testTrue = Integer.parseInt(tmpString[tmpString.length-1]);
            tmpString = sc.nextLine().split(" ");
            int testFalse = Integer.parseInt(tmpString[tmpString.length-1]);
            Monkey m = new Monkey(nr, testTrue, testFalse, test, operation, part1);
            for(int i = 2; i < items.length-1; i++) {
                m.items.add(Long.parseLong(items[i].substring(0, items[i].length()-1)));
            }
            m.items.add(Long.parseLong(items[items.length-1]));
            nr++;
            if(sc.hasNextLine()) sc.nextLine();
            monkeys.add(m);
        }
        for(Monkey m : monkeys) {
            test_product *= m.test;
        }
        return monkeys;
    }

    private BigInteger getMonkeyBusiness(ArrayList<Monkey> monkeys, int turns) {
        BigInteger monkey_business;
        for(int i = 0; i < turns; i++) {
            for(Monkey m : monkeys) {
                int size = m.items.size();
                for(int j = 0; j < size; j++) {
                    long[] res = m.inspect();
                    monkeys.get((int)res[0]).items.add(res[1]%test_product);
                }
            }
        }
        Monkey n1, n2;
        if(monkeys.get(0).compareTo(monkeys.get(1)) > 0) {
            n1 = monkeys.remove(0);
            n2 = monkeys.remove(1);
        }
        else {
            n1 = monkeys.remove(1);
            n2 = monkeys.remove(0);
        }
        for(Monkey m : monkeys) {
            if(m.compareTo(n1) > 0) {
                n2 = n1;
                n1 = m;
            }
            else if(m.compareTo(n2) > 0) n2 = m;
        }

        monkey_business = new BigInteger(String.valueOf(n1.inspects));
        return monkey_business.multiply(new BigInteger(String.valueOf(n2.inspects)));
    }

    public Day11(Scanner sc) {
        this.sc = sc;
    }

    public String solve1() {
        ArrayList<Monkey> monkeys = createMonkeys(true);
        return getMonkeyBusiness(monkeys, 20).toString();
    }

    public String solve2() {
        ArrayList<Monkey> monkeys = createMonkeys(false);
        return getMonkeyBusiness(monkeys, 10000).toString();
    }
}
