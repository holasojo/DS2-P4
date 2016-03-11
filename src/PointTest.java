
public class PointTest extends student.TestCase {

    Point pt1;
    Point pt2;
    Point pt3;
    Point pt4;
    Point pt5;

    public void setUp() {
        pt1 = new Point("A", 1, 1);
        pt2 = new Point("B", 1, 1);
        pt3 = new Point("A", 1, 2);
        pt4 = new Point("A", 2, 1);
        pt5 = new Point("A", 3, 3);
    }

    public void testQuadrant() {

        // if (yPos < centerY && xPos < centerX) {
        // return Direction.NW;
        // }
        // else if (yPos < centerY && xPos >= centerX) {
        // return Direction.NE;
        // }
        // else if (yPos >= centerY && xPos < centerX) {
        // return Direction.SW;
        // }
        // else if (yPos >= centerY && xPos >= centerX) {
        // return Direction.SE;
        // }
        //
        // return Direction.OUTSIDE;
    }

    public void testEquals() {
        // this.getX() == it.getX() && this.getY() == it.getY()
        // && this.getName().equals(it.getName());
    }

    public void testInRegion() {
        // !(this.xPos < x || x + w <= this.xPos || this.yPos < y
        // || y + h <= this.yPos);
    }

    public void testEqualsCoor() {
        // this.getX() == it.getX() && this.getY() == it.getY();
    }
}
