import java.util.Scanner;

public class Day8a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Day8Forest forest = new Day8Forest();
        String line;

        while (sc.hasNext()) {
            line = sc.nextLine();
            forest.newRow();
            for (char c: line.toCharArray()){
                forest.add(c - '0');
            }
        }
        System.out.println(forest.countVisible());
    }
}
