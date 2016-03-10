/**
 * Testing PtList
 * 
 * @author sohyun
 * @author sshumway
 * @version 3/7/2016
 *
 */
public class PtListTest extends student.TestCase {
    private PtList list1;
    private PtList list2;
    private PtList list3;
    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;
    private Point p5;
    private Point p6;

    /**
     * set up
     */
    public void setUp() {
        list1 = new PtList();
        list2 = new PtList();
        list3 = new PtList();
        p1 = new Point("A", 1, 1);
        p2 = new Point("B", 2, 2);
        p3 = new Point("C", 1, 1);
        p4 = new Point("D", 5, 5);
        p5 = new Point("F", 0, 0);
        p6 = new Point("G", 1023, 1023);

    }

    /**
     * testing append
     */
    public void testAppend() {
        list1.append(p1);
        list1.append(p2);
        assertEquals(list1.size(), 2);
        assertEquals(p1.toString(), "A, 1, 1");
        assertEquals(list1.toString(), "A, 1, 1\nB, 2, 2\n");
        list1.append(p3);
        list1.append(p4);
        list1.append(p5);
        assertEquals(list1.size(), 5);

    }

    /**
     * testing remove
     */
    public void testRemove() {
        assertNull(list1.remove());
        list1.append(p1);
        list1.append(p2);
        assertEquals(list1.size(), 2);
        Point[] removed = list1.remove();
        assertEquals(removed[1].toString(), "B, 2, 2");
        list1.append(p3);
        list1.append(p4);
        list1.append(p5);
        assertEquals(list1.remove(p1, false).toString(), "A, 1, 1");
        assertEquals(list1.remove(p5, false).toString(), "F, 0, 0");
        removed = list1.remove();
        assertEquals(removed[0].toString(), "B, 2, 2");
        assertEquals(removed[2].toString(), "D, 5, 5");
        list1.append(new Point("B", 2, 2));
        assertFalse(list1.checkAllSame(p2));
        list2.append(new Point("B", 2, 2));
        list2.append(new Point("B", 2, 2));
        assertTrue(list2.checkAllSame(p2));
        
        assertNotNull(list2.findbyCoor(new Point("B", 2, 2)));
        assertNull(list2.findbyCoor(new Point("c", 1000, 1000)));
        
        assertNull(list3.remove(new Point("b", 8, 8), false));
        list3.append(new Point("b", 8 , 8));
        assertNotNull(list3.remove(new Point("b", 8, 8), false));
        list3.append(new Point("b", 8 , 8));
        assertNull(list3.remove(new Point("c", 8, 8), true));
        assertNotNull(list3.remove(new Point("b", 8, 8), true));
        
        assertNull(list3.list());
        

    }
    
    

}
