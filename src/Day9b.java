import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day9b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Day9CoordPair> tailCoords = new HashSet<>();
        Day9CoordPair[] rope = new Day9CoordPair[10];
        for (int i = 0; i < rope.length; i++) {
            rope[i] = new Day9CoordPair(0,0);
        }

        while(sc.hasNext()){
            String line = sc.nextLine();
            char direction = line.charAt(0);
            int stepCount = Integer.parseInt(line.substring(2));

            for (int i = 0; i < stepCount; i++) {
                switch (direction){
                    case 'U':
                        rope[0].move(0, 1);
                        break;
                    case 'R':
                        rope[0].move(1, 0);
                        break;
                    case 'D':
                        rope[0].move(0, -1);
                        break;
                    case 'L':
                        rope[0].move(-1, 0);
                        break;
                }
                for (int j = 0; j < rope.length - 1; j++) {
                    rope[j + 1].moveAfter(rope[j]);
                }
                tailCoords.add(new Day9CoordPair(rope[rope.length - 1]));
            }
        }
        System.out.println(tailCoords.size());
    }
}
