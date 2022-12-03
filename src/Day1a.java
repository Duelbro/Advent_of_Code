import java.util.Scanner;

public class Day1a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int max = 0;

        while(sc.hasNext()){
            String line = sc.nextLine();
            if(line.equals("")){
                if(sum > max){
                    max = sum;
                }
                sum = 0;
            } else{
                sum += Integer.parseInt(line);
            }
        }
        System.out.println(max);
    }
}