import java.util.Scanner;

public class Day6b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean solved;
        int solution = 0;
        final int MARKER_SIZE = 14;

        while(sc.hasNext()){
            String line = sc.nextLine();
            char[] chars = line.toCharArray();
            for (int i = (MARKER_SIZE - 1); i < line.length(); i++) {
                solved = true;
                for(int j = i - (MARKER_SIZE - 1); j < i + 1; j++){
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
