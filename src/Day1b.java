import java.util.Scanner;

public class Day1b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int[] max = {0,0,0};

        while(sc.hasNext()){
            String line = sc.nextLine();
            if(line.equals("")){
                if(sum > max[2]){
                    max[0] = max[1];
                    max[1] = max[2];
                    max[2] = sum;
                }
                else if(sum > max[1]){
                    max[0] = max[1];
                    max[1] = sum;
                }
                else if(sum > max[0]){
                    max[0] = sum;
                }
                sum = 0;
            } else{
                sum += Integer.parseInt(line);
            }
        }
        System.out.println(max[0] + max[1] + max[2]);
    }
}
