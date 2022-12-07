import java.util.*;

public class Day7 {

    private final Scanner sc;

    private static class File {
        private final int size;
        private File(String name, int size) {
            this.size = size;
        }
    }

    private static class Dir implements Comparable<Dir> {
        private final String name;
        private final ArrayList<Dir> dirs;
        private final ArrayList<File> files;
        private Dir parent;
        private Dir(String name) {
            this.name = name;
            dirs = new ArrayList<>();
            files = new ArrayList<>();
        }
        private Dir(String name, Dir parent) {
            this(name);
            this.parent = parent;
        }
        private void addFile(File f) {
            files.add(f);
        }
        private void addDir(Dir d) {
            dirs.add(d);
        }
        private Dir getDir(String name) {
            for(Dir d: dirs) {
                if(d.name.equals(name)) return d;
            }
            return null;
        }
        private int size() {
            int sum = 0;
            for(File f : files) {
                sum += f.size;
            }
            for(Dir d : dirs) {
                sum += d.size();
            }
            return sum;
        }
        @Override
        public int compareTo(Dir d) {
            return Integer.compare(size(), d.size());
        }
    }

    public Day7(Scanner sc) {
        this.sc = sc;
    }

    public HashSet<Dir> getSet() {
        HashSet<Dir> dirs = new HashSet<>();
        String line = sc.nextLine();
        Dir current = new Dir(line.split(" ")[2]);
        line = sc.nextLine();
        while(sc.hasNextLine()) {
            String[] lineSplit = line.split(" ");
            if(lineSplit[0].equals("dir")) {
                current.addDir(new Dir(lineSplit[1], current));
            }
            else if(Character.isDigit(lineSplit[0].charAt(0))) {
                current.addFile(new File(lineSplit[1], Integer.parseInt(lineSplit[0])));
            }
            else if(lineSplit[1].equals("cd")) {
                dirs.add(current);
                while(lineSplit[2].equals("..")) {
                    current = current.parent;
                    lineSplit = sc.nextLine().split(" ");
                }
                current = current.getDir(lineSplit[2]);
            }
            line = sc.nextLine();
        }

        return dirs;

    }

    public int solve1() {
        HashSet<Dir> dirs = getSet();
        int res = 0;
        for(Dir d : dirs) {
            if(d.size() <= 100000) res += d.size();
        }
        return res;
    }

    public int solve2() {
        HashSet<Dir> dirs = getSet();
        int capacity = 70000000, needed = 30000000;
        PriorityQueue<Dir> pq = new PriorityQueue<>();
        pq.addAll(dirs);
        int totalSize = 0;
        for(Dir d: dirs) {
            if(d.name.equals("/")) {
                totalSize = d.size();
                break;
            }
        }
        int res = 0;
        while(!pq.isEmpty()) {
            Dir d = pq.poll();
            if(totalSize - d.size() < capacity - needed) {
                res = d.size();
                break;
            }
        }
        return res;
    }

}
