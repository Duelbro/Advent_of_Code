import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Day7Directory {
    private int size;
    private Day7Directory parent;
    private final HashMap<String, Day7Directory> subdirectories;

    public Day7Directory(Day7Directory parent, int sizeOfFiles) {
        size = sizeOfFiles;
        this.parent = parent;
        subdirectories = new HashMap<>();
    }

    public Day7Directory get(String name) {
        return subdirectories.get(name);
    }

    public void addSubdirectory(String name, int sizeOfFiles) {
        subdirectories.put(name, new Day7Directory(this, sizeOfFiles));
        addSize(sizeOfFiles);
    }

    public void addSize(int addedSize) {
        size += addedSize;
        if (parent != null) {
            parent.addSize(addedSize);
        }
    }

    public Day7Directory getParent() {
        return parent;
    }

    public ArrayList<Integer> directorySizeList(){
        ArrayList<Integer> returnList = new ArrayList<>();
        ArrayList<Integer> subList;

        for (String name: subdirectories.keySet()) {
            subList = subdirectories.get(name).directorySizeList();
            returnList.addAll(subList);
        }
        returnList.add(size);
        return returnList;
    }

    public int deletedFileSize(int totalSize, int spaceNeeded){
        ArrayList<Integer> directorySizes = directorySizeList();
        directorySizes.sort(Comparator.comparingInt(o -> o));
        for (int directorySize : directorySizes) {
            if (totalSize - size + directorySize >= spaceNeeded) {
                return directorySize;
            }
        }
        return -1;
    }
    public int sum(){
        int sum = 0;
        for (String name: subdirectories.keySet()) {
            sum += subdirectories.get(name).sum();
        }
        if(size <= 100000){
            sum += size;
        }
        return sum;
    }
}
