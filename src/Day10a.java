import java.util.Scanner;

public class Day10a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean adding = false;
        int cycleCount = 0;
        int toAdd = 0;
        int x = 1;
        int sum = 0;

        while(sc.hasNext()){
            if(!adding){
                String line = sc.nextLine();
                String[] strings = line.split(" ");
                if(strings[0].equals("addx")) {
                    toAdd = Integer.parseInt(strings[1]);
                    adding = true;
                }
                cycleCount++;
                if((cycleCount - 20) % 40 == 0) {
                    sum += x * cycleCount;
                }
            }
            else {
                cycleCount++;
                if((cycleCount - 20) % 40 == 0) {
                    sum += x * cycleCount;
                }
                x += toAdd;
                adding = false;
            }
        }
        System.out.println(sum);
    }
}
