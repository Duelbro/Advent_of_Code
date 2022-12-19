import java.util.*;

public class Day11a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] items = new long[2];
        int div = 0;
        int[] monkeyThrowIndices = new int[2];
        String operation = "";
        ArrayList<Day11Monkey> monkeys = new ArrayList<>();

        while(sc.hasNext()){
            String line = sc.nextLine();
            line = line.trim();
            String[] substrings = line.split(" ");
            switch(substrings[0]){
                case "Starting" :
                    String[] itemStrings = line.substring(16).split(", ");
                    items = new long[itemStrings.length];
                    for (int i = 0; i < items.length; i++) {
                        items[i] = Long.parseLong(itemStrings[i]);
                    }
                    break;
                case "Operation:":
                    operation = substrings[4] + " " + substrings[5];
                    break;
                case "Test:" :
                    div = Integer.parseInt(substrings[3]);
                    break;
                case "If" :
                    if (substrings[1].equals("true:")) {
                        monkeyThrowIndices[0] = Integer.parseInt(substrings[5]);
                    }
                    else {
                        monkeyThrowIndices[1] = Integer.parseInt(substrings[5]);
                        monkeys.add(new Day11Monkey(monkeyThrowIndices[0], monkeyThrowIndices[1], items, operation, div));
                    }
                    break;
                default:
            }
        }

        for (int i = 0; i < 20; i++) {
            for (Day11Monkey monkey : monkeys) {
                monkey.shenanigans(monkeys.get(monkey.getIndexTrue()), monkeys.get(monkey.getIndexFalse()));
            }
        }

        ArrayList<Long> monkeyInspections = new ArrayList<>();
        for (Day11Monkey monkey : monkeys) {
            monkeyInspections.add(monkey.getInspectionCount());
        }
        long max = 0;
        for (long inspectionCount : monkeyInspections) {
            if(inspectionCount > max) {
                max = inspectionCount;
            }
        }
        monkeyInspections.remove(max);
        long max2 = 0;
        for (long inspectionCount : monkeyInspections) {
            if(inspectionCount > max2) {
                max2 = inspectionCount;
            }
        }
        System.out.println(max * max2);
    }
}
