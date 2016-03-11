/**
 * Point class
 * 
 * @author sohyun
 * @author sshumway
 * @version 3/7/2016
 */
public class Point {

    private String name;
    private int xPos;
    private int yPos;

    /**
     * Constructor
     * 
     * @param x
     *            is the x position
     * @param y
     *            is the y position
     */
    public Point(int x, int y) {

        xPos = x;
        yPos = y;
    }

    /**
     * constructor
     * 
     * @param n
     *            is the name of point
     * @param x
     *            is x position
     * @param y
     *            is y position
     */
    public Point(String n, int x, int y) {
        name = n;
        xPos = x;
        yPos = y;
    }

    /**
     * getter for x
     * 
     * @return x position
     */
    public int getX() {
        return xPos;
    }

    /**
     * getter for y
     * 
     * @return y position
     */
    public int getY() {
        return yPos;
    }

    /**
     * getter for name
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Used to see if the point is in which quadrant compare to centerX and
     * centerY position
     * 
     * @param centerX
     *            the center of world
     * @param centerY
     *            the center of y
     * @return the which quadrant it is
     */
    public Direction quadrant(int centerX, int centerY) {

        if (yPos < centerY && xPos < centerX) {
            return Direction.NW;
        }
        if (yPos < centerY && xPos >= centerX) {
            return Direction.NE;
        }
        if (yPos >= centerY && xPos < centerX) {
            return Direction.SW;
        }

        return Direction.SE;

    }

    /**
     * toString
     * 
     * @return the point in string form
     */
    public String toString() {
        return name + ", " + xPos + ", " + yPos;
    }

    /**
     * Compares two points
     *
     * @param o
     *            is the one gets compared
     * @return true of name and coordinates are the same
     */
    public boolean equals(Object o) {
        // if (!o.getClass().equals(this.getClass())) {
        // return false;
        // }
        Point it = (Point) o;
        return this.getX() == it.getX() && this.getY() == it.getY()
                && this.getName().equals(it.getName());
    }

    /**
     * Compares coordinates of two points
     * 
     * @param it
     *            is the one gets compared
     * @return true if coordinates are the same
     */
    public boolean equalsCoor(Point it) {
        return this.getX() == it.getX() && this.getY() == it.getY();
    }

    /**
     * checks if the point is within the region
     * 
     * @param x
     *            is the x position of world
     * @param y
     *            is the y position of world
     * @param w
     *            is the width of world
     * @param h
     *            is the height of world
     * @return true if it is not outside of the region
     */
    public boolean inRegion(int x, int y, int w, int h) {
        return !(this.xPos < x || x + w <= this.xPos || this.yPos < y
                || y + h <= this.yPos);
    }

}
