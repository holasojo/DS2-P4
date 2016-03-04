
public class Point {

    private String name;
    private int xPos;
    private int yPos;

    public Point(int x, int y) {

        xPos = x;
        yPos = y;
    }

    public Point(String n, int x, int y) {
        name = n;
        xPos = x;
        yPos = y;
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    public String getName() {
        return name;
    }

    public Direction quadrant(int centerX, int centerY) {

        if (yPos < centerY && xPos < centerX) {
            return Direction.NW;
        }
        else if (yPos < centerY && xPos >= centerX) {
            return Direction.NE;
        }
        else if (yPos >= centerY && xPos < centerX) {
            return Direction.SW;
        }
        else if (yPos >= centerY && xPos >= centerX) {
            return Direction.SE;
        }
        else {
            return Direction.OUTSIDE;
        }
    }

    // public boolean inBox();

    public String toString() {
        return name + ", " + xPos + ", " + yPos;
    }

    public boolean equals(Object o) {
        if (!o.getClass().equals(this.getClass())) {
            return false;
        }
        Point it = (Point) o;
        return this.getX() == it.getX() && this.getY() == it.getY() && this.getName().equals(it.getName());
    }

    public boolean equalsCoor(Point it) {
        return this.getX() == it.getX() && this.getY() == it.getY();
    }
    
    public boolean inRegion(int x, int y, int w, int h)
    {
        return !(this.xPos < x
                || x + w <= this.xPos
                || this.yPos < y || y
                + h <= this.yPos);
    }

}
