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

    public void setUp() {
        pt1 = new Point("A", 1, 1);
        pt2 = new Point("B", 1, 1);
        pt3 = new Point("A", 1, 2);
        pt4 = new Point("A", 2, 1);
        pt5 = new Point("A", 3, 3);
    }

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

    public void testInRegion() {
        // !(this.xPos < x || x + w <= this.xPos || this.yPos < y
        // || y + h <= this.yPos);
        assertTrue(pt1.inRegion(0, 0, 10, 10));

    }

    public void testQuadrant() {
        Point pt6 = new Point(1, 1);
        Point pt7 = new Point(1, 8);
        Point pt8 = new Point(8, 1);
        Point pt9 = new Point(8, 8);
        Point pt10 = new Point(5, 5);
        Point pt11 = new Point(5, 2);
        Point pt12 = new Point(2, 5);

        // (yPos < centerY && xPos < centerX)
        assertEquals(pt6.quadrant(5, 5), Direction.NW);
        // (yPos > centerY && xPos < centerX)
        // (yPos < centerY && xPos > centerX)
        // (yPos > centerY && xPos > centerX)
        assertEquals(pt7.quadrant(5, 5), Direction.SW);
        assertEquals(pt8.quadrant(5, 5), Direction.NE);
        assertEquals(pt9.quadrant(5, 5), Direction.SE);

        // else if (yPos < centerY && xPos >= centerX) {
        // return Direction.NE;
        // }
        assertEquals(pt12.quadrant(5, 5), Direction.SW);
        // else if (yPos >= centerY && xPos < centerX) {
        // return Direction.SW;
        // }
        assertEquals(pt11.quadrant(5, 5), Direction.NE);
        
        // else if (yPos >= centerY && xPos >= centerX) {
        // return Direction.SE;
        // }
        assertEquals(pt10.quadrant(5, 5), Direction.SE);
    }

}
