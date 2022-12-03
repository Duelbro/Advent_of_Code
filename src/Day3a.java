import java.util.Scanner;
public class Day3a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        char find = '\0';

        while(sc.hasNext()){
            String line = sc.nextLine();
            for (int i = 0; i < line.length() / 2; i++) {
                find = line.charAt(i);
                if(line.indexOf(find, line.length() / 2) != -1){
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