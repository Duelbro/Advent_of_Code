import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Day5b {
    public static void main(String[] args) {
        char parseChar;
        ArrayList<String> stackLines = new ArrayList<>();
        ArrayList<Stack<Character>> stacks = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean scanningStack = true;
        int[] nums = new int[3];

        while(sc.hasNext()){
            String line = sc.nextLine();
            if(line.charAt(1) == '1'){
                for (int i = 1; i < line.length(); i += 4) {
                    stacks.add(new Stack<>());
                }
                for (String parseLine : stackLines) {
                    for (int i = 1; i < parseLine.length(); i += 4) {
                        parseChar = parseLine.charAt(i);
                        if(parseChar != ' '){
                            stacks.get(i / 4).push(parseChar);
                        }
                    }
                }
                scanningStack = false;
                sc.nextLine();
            }
            else if(scanningStack){
                stackLines.add(0,line);
            }
            else{
                String[] numStrings = line.split("move | from | to ");

                for (int i = 1; i < numStrings.length; i++) {
                    nums[i - 1] = Integer.parseInt(numStrings[i]);
                }
                for (int i = 0; i < nums[0]; i++) {
                    Stack<Character> stackA = stacks.get(nums[1] - 1);
                    Stack<Character> stackB = stacks.get(nums[2] - 1);
                    stackB.push(stackA.remove(stackA.size() - nums[0] + i));
                }
            }
        }
        for (Stack<Character> s : stacks) {
            System.out.print(s.pop());
        }
        System.out.println();
    }
}
