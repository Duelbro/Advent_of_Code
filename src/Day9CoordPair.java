import java.util.Objects;

public class Day9CoordPair {
    private int x;
    private int y;

    public Day9CoordPair(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Day9CoordPair(Day9CoordPair pair){
        this.x = pair.x;
        this.y = pair.y;
    }

    public void move(int deltaX, int deltaY){
        x += deltaX;
        y += deltaY;
    }

    public void moveAfter(Day9CoordPair paired){
        if (this.x > paired.x + 1) {
            move(-1,0);
            if(this.y < paired.y){
                move(0,1);
            }
            else if(this.y > paired.y){
                move(0,-1);
            }
        }
        else if (this.x < paired.x - 1) {
            move(1,0);
            if(this.y < paired.y){
                move(0,1);
            }
            else if(this.y > paired.y){
                move(0,-1);
            }
        }
        else if (this.y > paired.y + 1) {
            move(0,-1);
            if(this.x < paired.x){
                move(1, 0);
            }
            else if(this.x > paired.x){
                move(-1, 0);
            }

        }
        else if (this.y < paired.y - 1) {
            move(0,1);
            if(this.x < paired.x){
                move(1, 0);
            }
            else if(this.x > paired.x){
                move(-1, 0);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Day9CoordPair that = (Day9CoordPair) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}
