import java.util.Scanner;

    public class Day2b {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int points = 0;

            while(sc.hasNext()){
                String line = sc.nextLine();
                switch (line){
                    case "A X":
                        points += 3;
                        break;
                    case "B X":
                        points += 1;
                        break;
                    case "C X":
                        points += 2;
                        break;
                    case "A Y":
                        points += 4;
                        break;
                    case "B Y":
                        points += 5;
                        break;
                    case "C Y":
                        points += 6;
                        break;
                    case "A Z":
                        points += 8;
                        break;
                    case "B Z":
                        points += 9;
                        break;
                    case "C Z":
                        points += 7;
                        break;
                }
            }
            System.out.println(points);
        }
    }
