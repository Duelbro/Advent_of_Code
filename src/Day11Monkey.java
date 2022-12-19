import java.util.ArrayList;

public class Day11Monkey {
    private final int throwIndexWhenFalse;
    private final int throwIndexWhenTrue;
    private final ArrayList<Long> items;
    private final String operation;
    private final long testDivBy;
    private long inspectionCount = 0;

    public Day11Monkey(int whenTrue, int whenFalse, long[] items, String operation, long testDivBy){
        throwIndexWhenTrue = whenTrue;
        throwIndexWhenFalse = whenFalse;
        this.items = new ArrayList<>();
        for (long item : items) {
            add(item);
        }
        this.operation = operation;
        this.testDivBy = testDivBy;
    }

    public int getIndexTrue() {
        return throwIndexWhenTrue;
    }

    public int getIndexFalse() {
        return throwIndexWhenFalse;
    }

    public long getInspectionCount() {
        return inspectionCount;
    }

    public void add(long item){
        items.add(item);
    }

    public void shenanigans(Day11Monkey whenTrue, Day11Monkey whenFalse){
        int count = items.size();
        for (int i = 0; i < count; i++) {
            long item = items.remove(0);
            passTo(getBored(inspect(item)), whenTrue, whenFalse);
        }
    }
    public void shenanigansB(Day11Monkey whenTrue, Day11Monkey whenFalse){
        int count = items.size();
        for (int i = 0; i < count; i++) {
            long item = items.remove(0);
            passTo(inspectB(item), whenTrue, whenFalse);
        }
    }
    private void passTo(long item, Day11Monkey whenTrue, Day11Monkey whenFalse){
        if (item % testDivBy == 0){
            whenTrue.add(item);
        }
        else {
            whenFalse.add(item);
        }
    }

    public long inspectB(long old){
        char operator = operation.charAt(0);
        String operandString = operation.substring(2);
        long operand = 0;
        if(!operandString.equals("old")) {
            operand = Long.parseLong(operandString);
        }

        inspectionCount++;
        if(operator == '*'){
            if(operandString.equals("old")){
                return ((old % testDivBy) * (old % testDivBy)) % testDivBy;
            }
            else{
                return ((old % testDivBy) * (operand % testDivBy)) % testDivBy;
            }
        }
        else {
            if(operandString.equals("old")){
                return ((old % testDivBy) + (old % testDivBy)) % testDivBy;
            }
            else{
                return ((old % testDivBy) + (operand % testDivBy)) % testDivBy;
            }
        }
    }

    public long inspect(long old){
        char operator = operation.charAt(0);
        String operandString = operation.substring(2);
        long operand = 0;
        if(!operandString.equals("old")) {
            operand = Long.parseLong(operandString);
        }

        inspectionCount++;
        if(operator == '*'){
            if(operandString.equals("old")){
                return (old * old);
            }
            else{
                return (old * operand);
            }
        }
        else {
            if(operandString.equals("old")){
                return (old + old);
            }
            else{
                return (old + operand);
            }
        }
    }

    public long getBored(long item) {
        return item / 3;
    }
}
