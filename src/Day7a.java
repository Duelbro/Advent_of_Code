import java.util.Scanner;

public class Day7a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Day7Directory root = new Day7Directory(null, 0);
        Day7Directory wd = root;
        String nextDirectoryName = null;
        int sum = 0;

        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] words = line.split(" ");
            if (words[0].equals("$")) {
                if (words[1].equals("cd")) {
                    if(words[2].equals("..")){
                        wd = wd.getParent();
                    } else if(words[2].equals("/")){
                        wd = root;
                    } else {
                        nextDirectoryName  = words[2];
                    }
                } else {
                    wd.addSubdirectory(nextDirectoryName, 0);
                    wd = wd.get(nextDirectoryName);
                }
            } else if(!words[0].equals("dir")){
                wd.addSize(Integer.parseInt(words[0]));
            }
        }
        sum = root.sum();
        System.out.println(sum);
    }
}
