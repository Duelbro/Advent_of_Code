import java.util.ArrayList;

public class Day8Forest {
    private Day8Tree nextTop;
    private Day8Tree nextLeft;
    private final ArrayList<ArrayList<Day8Tree>> trees;
    private ArrayList<Day8Tree> currentRow;

    public Day8Forest() {
        trees = new ArrayList<>();
        nextTop = null;
        nextLeft = null;
    }

    public void newRow() {
        if (trees.size() != 0) {
            ArrayList<Day8Tree> previousRow = trees.get(trees.size() - 1);
            nextTop = previousRow.get(0);
        }
        currentRow = new ArrayList<>();
        trees.add(currentRow);
        nextLeft = null;
    }

    public void add(int height) {
        Day8Tree newTree = new Day8Tree(height, nextTop, nextLeft);

        currentRow.add(newTree);
        nextLeft = newTree;
        if (nextTop != null) {
            nextTop = nextTop.right;
        }
    }

    public int countVisible() {
        int count = 0;

        for (ArrayList<Day8Tree> row : trees) {
            for (Day8Tree tree : row) {
                if (tree.isVisible()) {
                    count++;
                }
            }
        }
        return count;
    }

    public int maxScenicScore() {
        int max = 0;

        for (ArrayList<Day8Tree> row : trees) {
            for (Day8Tree tree : row) {
                max = Math.max(max, tree.scenicScore());
            }
        }
        return max;

    }

    private class Day8Tree {
        private final int height;
        private final Day8Tree top;
        private final Day8Tree left;
        private Day8Tree right;
        private Day8Tree bottom;

        private Day8Tree(int height, Day8Tree top, Day8Tree left) {
            this.height = height;
            this.top = top;
            if (top != null) {
                top.bottom = this;
            }
            this.left = left;
            if (left != null) {
                left.right = this;
            }
            right = null;
            bottom = null;
        }


        private boolean isVisible() {
            return isVisibleFromTheTop() || isVisibleFromTheLeft() || isVisibleFromTheRight() || isVisibleFromTheBottom();
        }

        private boolean isVisibleFromTheTop() {
            Day8Tree marker = top;

            while (marker != null) {
                if (marker.height >= this.height) {
                    return false;
                }
                marker = marker.top;
            }
            return true;
        }

        private boolean isVisibleFromTheLeft() {
            Day8Tree marker = left;

            while (marker != null) {
                if (marker.height >= this.height) {
                    return false;
                }
                marker = marker.left;
            }
            return true;
        }

        private boolean isVisibleFromTheRight() {
            Day8Tree marker = right;

            while (marker != null) {
                if (marker.height >= this.height) {
                    return false;
                }
                marker = marker.right;
            }
            return true;
        }

        private boolean isVisibleFromTheBottom() {
            Day8Tree marker = bottom;

            while (marker != null) {
                if (marker.height >= this.height) {
                    return false;
                }
                marker = marker.bottom;
            }
            return true;
        }

        private int scenicScore() {
            return scenicScoreTop() * scenicScoreLeft() * scenicScoreRight() * scenicScoreBottom();
        }

        private int scenicScoreTop() {
            Day8Tree marker = top;
            int scenicScore = 0;

            while (marker != null) {
                scenicScore++;
                if (marker.height >= this.height) {
                    break;
                }
                marker = marker.top;
            }
            return scenicScore;
        }

        private int scenicScoreLeft() {
            Day8Tree marker = left;
            int scenicScore = 0;

            while (marker != null) {
                scenicScore++;
                if (marker.height >= this.height) {
                    break;
                }
                marker = marker.left;
            }
            return scenicScore;
        }

        private int scenicScoreRight() {
            Day8Tree marker = right;
            int scenicScore = 0;

            while (marker != null) {
                scenicScore++;
                if (marker.height >= this.height) {
                    break;
                }
                marker = marker.right;
            }
            return scenicScore;
        }

        private int scenicScoreBottom() {
            Day8Tree marker = bottom;
            int scenicScore = 0;

            while (marker != null) {
                scenicScore++;
                if (marker.height >= this.height) {
                    break;
                }
                marker = marker.bottom;
            }
            return scenicScore;
        }

    }
}