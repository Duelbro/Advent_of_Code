import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day9a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Day9CoordPair> tailCoords = new HashSet<>();
        Day9CoordPair head = new Day9CoordPair(0, 0);
        Day9CoordPair tail = new Day9CoordPair(0, 0);

        while(sc.hasNext()){
            String line = sc.nextLine();
            char direction = line.charAt(0);
            int stepCount = Integer.parseInt(line.substring(2));

            for (int i = 0; i < stepCount; i++) {
                switch (direction){
                    case 'U':
                        head.move(0, 1);
                        break;
                    case 'R':
                        head.move(1, 0);
                        break;
                    case 'D':
                        head.move(0, -1);
                        break;
                    case 'L':
                        head.move(-1, 0);
                        break;
                }
                tail.moveAfter(head);
                tailCoords.add(new Day9CoordPair(tail));
            }
        }
        System.out.println(tailCoords.size());
    }
}
