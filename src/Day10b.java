import java.util.Scanner;

public class Day10b {
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

                int drawPos = cycleCount % 40;
                if((drawPos >= x - 1) && (drawPos <= x + 1)){
                    System.out.print("#");
                }
                else {
                    System.out.print(".");
                }
                cycleCount++;
                if(drawPos == 39){
                    System.out.println();
                }
            }
            else {
                int drawPos = cycleCount % 40;
                if((drawPos >= x - 1) && (drawPos <= x + 1)){
                    System.out.print("#");
                }
                else {
                    System.out.print(".");
                }
                cycleCount++;
                if(drawPos == 39){
                    System.out.println();
                }
                x += toAdd;
                adding = false;
            }
        }
        System.out.println(sum);
    }
}
