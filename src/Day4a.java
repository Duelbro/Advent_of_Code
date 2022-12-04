import java.util.Scanner;

public class Day4a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int[] a = new int[2];
        int[] b = new int[2];

        while(sc.hasNext()){
            String line = sc.nextLine();
            String[] strings = line.split("-|,");
            a[0] = Integer.parseInt(strings[0]);
            a[1] = Integer.parseInt(strings[1]);
            b[0] = Integer.parseInt(strings[2]);
            b[1] = Integer.parseInt(strings[3]);
            if(!(((a[0] < b[0]) && (a[1] < b[1])) || ((a[0] > b[0]) && (a[1] > b[1])))){
                sum++;
            }
        }
        System.out.println(sum);
    }
}
