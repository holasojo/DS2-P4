/**
 * Point test class
 * 
 * @author sohyun
 * @author sshumway
 * @version 3/11/2016
 *
 */
public class PointTest extends student.TestCase {

    private Point pt1;
    private Point pt2;
    private Point pt3;
    private Point pt4;
    private Point pt5;

    /**
     * setup
     */
    public void setUp() {
        pt1 = new Point("A", 1, 1);
        pt2 = new Point("B", 1, 1);
        pt3 = new Point("A", 1, 2);
        pt4 = new Point("A", 2, 1);
        pt5 = new Point("A", 3, 3);
    }

    /**
     * testing equals() method
     */
    public void testEquals() {
        // this.getX() == it.getX() && this.getY() == it.getY()
        // && this.getName().equals(it.getName());
        assertTrue(pt1.equals(pt1));
        // this.getX() != it.getX() && this.getY() == it.getY()
        // && this.getName().equals(it.getName());
        assertFalse(pt1.equals(pt4));
        // this.getX() == it.getX() && this.getY() != it.getY()
        // && this.getName().equals(it.getName());
        assertFalse(pt1.equals(pt3));
        // this.getX() == it.getX() && this.getY() == it.getY()
        // && !this.getName().equals(it.getName());
        assertFalse(pt1.equals(pt2));
        // this.getX() != it.getX() && this.getY() != it.getY()
        // && this.getName().equals(it.getName());
        assertFalse(pt1.equals(pt5));
        // this.getX() != it.getX() && this.getY() == it.getY()
        // && !this.getName().equals(it.getName());
        assertFalse(pt1.equals(new Point("B", 2, 1)));
        // this.getX() == it.getX() && this.getY() != it.getY()
        // && !this.getName().equals(it.getName());
        assertFalse(pt1.equals(new Point("B", 1, 2)));
        // this.getX() != it.getX() && this.getY() != it.getY()
        // && !this.getName().equals(it.getName());
        assertFalse(pt1.equals(new Point("B", 2, 2)));
    }

    /**
     * testing equalsCoor() method
     */
    public void testEqualsCoor() {
        // this.getX() == it.getX() && this.getY() == it.getY();
        assertTrue(pt1.equalsCoor(pt1));
        // this.getX() != it.getX() && this.getY() == it.getY();
        assertFalse(pt1.equalsCoor(pt4));
        // this.getX() == it.getX() && this.getY() != it.getY();
        assertFalse(pt1.equalsCoor(pt3));
        // this.getX() != it.getX() && this.getY() != it.getY();
        assertFalse(pt1.equalsCoor(pt5));

    }

    /**
     * testing inRegion() method
     */
    public void testInRegion() {

        Point pt6 = new Point("A", 8, 8);
        Point pt7 = new Point("A", 2, 15);
        Point pt8 = new Point("A", 15, 2);
        Point pt9 = new Point("A", 15, 15);
        Point pt10 = new Point("A", 8, 15);
        Point pt11 = new Point("A", 15, 8);
        Point pt12 = new Point("A", 2, 2);
        // !(this.xPos < x || x + w <= this.xPos || this.yPos < y
        // || y + h <= this.yPos);
        assertTrue(pt6.inRegion(5, 5, 5, 5));
        assertFalse(pt7.inRegion(5, 5, 5, 5));
        assertFalse(pt8.inRegion(5, 5, 5, 5));
        assertFalse(pt9.inRegion(5, 5, 5, 5));
        assertFalse(pt10.inRegion(5, 5, 5, 5));
        assertFalse(pt11.inRegion(5, 5, 5, 5));
        assertFalse(pt12.inRegion(5, 5, 5, 5));

    }

    /**
     * testing quadrant()
     */
    public void testQuadrant() {
        Point pt6 = new Point(1, 1);
        Point pt7 = new Point(8, 2);
        Point pt8 = new Point(2, 8);
        Point pt9 = new Point(15, 2);
        Point pt10 = new Point(15, 8);
        Point pt11 = new Point(15, 15);
        Point pt12 = new Point(8, 15);
        Point pt13 = new Point(2, 15);
        Point pt14 = new Point(2, 8);
        Point pt15 = new Point(8, 8);

        // if (yPos < centerY && xPos < centerX) {
        // return Direction.NW;
        // }
        // if (yPos < centerY && xPos >= centerX) {
        // return Direction.NE;
        // }
        // if (yPos >= centerY && xPos < centerX) {
        // return Direction.SW;
        // }
        //
        // return Direction.SE;

        assertEquals(pt6.quadrant(8, 8), Direction.NW);
        assertEquals(pt7.quadrant(8, 8), Direction.NE);
        assertEquals(pt8.quadrant(8, 8), Direction.SW);
        assertEquals(pt9.quadrant(8, 8), Direction.SE);
        assertEquals(pt10.quadrant(8, 8), Direction.SE);
        assertEquals(pt11.quadrant(8, 8), Direction.SE);
        assertEquals(pt12.quadrant(8, 8), Direction.SE);
        assertEquals(pt13.quadrant(8, 8), Direction.SE);
        assertEquals(pt14.quadrant(8, 8), Direction.SE);
        assertEquals(pt15.quadrant(8, 8), Direction.SE);

    }

}
