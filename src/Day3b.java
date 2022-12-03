import java.util.Scanner;

public class Day3b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        char find = '\0';

        while(sc.hasNext()){
            String line1 = sc.nextLine();
            String line2 = sc.nextLine();
            String line3 = sc.nextLine();

            for (int i = 0; i < line1.length(); i++) {
                find = line1.charAt(i);
                if(line2.contains("" + find) && line3.contains("" + find)){
                    break;
                }
            }
            if(Character.isLowerCase(find)){
                sum += ((int)find) - 96;
            }
            else{
                sum += ((int)find) - 38;
            }
        }
        System.out.println(sum);
    }
}
