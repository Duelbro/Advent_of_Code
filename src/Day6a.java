import java.util.Scanner;

public class Day6a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean solved;
        int solution = 0;

        while(sc.hasNext()){
            String line = sc.nextLine();
            char[] chars = line.toCharArray();
            for (int i = 3; i < line.length(); i++) {
                solved = true;
                for(int j = i - 3; j < i + 1; j++){
                    for (int k = j + 1; k < i + 1; k++) {
                        if ((chars[j] == chars[k]) && (j != k)) {
                            solved = false;
                            break;
                        }
                    }
                }
                if(solved){
                    solution = i + 1;
                    break;
                }
            }
        }
        System.out.println(solution);
    }
}
