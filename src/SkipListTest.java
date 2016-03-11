/***
 * Test for SkipList**@author SOJO
 * 
 * @author sshumway
 * @version 02/01/2016
 */
public class SkipListTest extends student.TestCase {

    private SkipList<String, Point> list;
    private Container con;
    private Container con2;
    private Container con3;

    /**
     * constructor. empty.
     */
    public SkipListTest() {

    }

    /**
     * set up for testing
     */
    public void setUp() {
        con = new Container();
        con2 = new Container();

        con3 = new Container();

        con3.insert("A", 0, 0);
        con3.insert("B", 0, 0);
        con3.insert("C", 1, 1);
        con3.insert("E", 1023, 1023);
        con3.insert("E", 0, 1023);
        con3.insert("E", 1023, 0);
        con3.insert("C", 1, 1);
        con3.insert("C", 1, 1);
        con3.insert("C", 1, 2);
        systemOut().clearHistory();
    }

    /**
     * testing search
     */
    public void testSearch() {
        list = con2.getList();
        assertNotNull(list);
        con2.search(null);
        // assertFuzzyEquals("Rectangle not found: null\n",
        // systemOut().getHistory());
        assertEquals(0, list.size());
        systemOut().clearHistory();
        con2.search("A");
        assertFuzzyEquals("Point not found: A\n", systemOut().getHistory());

        con2.insert("A", 0, 0);
        systemOut().clearHistory();
        con2.search("A");
        assertFuzzyEquals("found: A 0, 0\n", systemOut().getHistory());
        assertEquals(1, list.size());
        con2.insert("B", 0, 0);
        assertEquals(2, list.size());
        con2.insert("C", 1, 1);
        assertEquals(3, list.size());
        systemOut().clearHistory();

        con2.search("Z");
        assertFuzzyEquals("Point not found: Z\n", systemOut().getHistory());
        con2.insert("E", 1023, 1023);
        assertEquals(4, list.size());
        con2.insert("E", 0, 1023);
        assertEquals(5, list.size());
        con2.insert("E", 1023, 0);
        systemOut().clearHistory();

        con2.search("E");
        assertFuzzyEquals("found: E 1023, 0\nfound: E 0, 1023"
                + "\nfound: E 1023, 1023\n", systemOut().getHistory());
        assertEquals(6, list.size());
        con2.insert("C", 1, 1);
        con2.insert("C", 1, 1);
        con2.insert("C", 1, 1);
        systemOut().clearHistory();
        con2.search("C");
        assertFuzzyEquals("found: C 1, 1\nfound: C 1, 1\nfound: C "
                + "1, 1\nfound: C 1, 1\n", systemOut().getHistory());
        systemOut().clearHistory();

        con2.search("D");
        assertFuzzyEquals("Point not found: D\n", systemOut().getHistory());

    }

    /**
     * testing removing with x,y,w,h
     */
    public void testRemoveByRegion() {
        // remove from the empty list
        con.removebyCoor(1, 1);
        assertEquals(0, con.getList().size());
        con.removebyCoor(-1, -1);
        assertEquals(0, con.getList().size());
        // list now has rectangles inserted
        list = con3.getList();
        con3.removebyCoor(0, 0);
        assertEquals(8, list.size());
        con3.removebyCoor(1024, 1024);
        assertEquals(7, list.size());
        // not in the list
        con3.removebyCoor(3, 3);
        assertEquals(7, list.size());
        // rectangle not valid
        con3.removebyCoor(-1, -1);
        assertEquals(7, list.size());
        con3.insert("Z", 3, 3);
        con3.removebyCoor(3, 3);
        assertEquals(7, list.size());

    }

    /**
     * test regionSearch
     */
    public void testRegionSearch() {
        // w > 0 && h > 0
        assertTrue(con3.regionSearch(1, 1, 2, 2));
        // w <= 0 && h <= 0
        assertFalse(con3.regionSearch(1, 1, -1, -20));
        assertFalse(con3.regionSearch(1, 1, 0, 0));
        // just w<=0
        assertFalse(con3.regionSearch(1, 1, 0, 1));
        assertFalse(con3.regionSearch(1, 1, -1, 1));
        // just h<=0
        assertFalse(con3.regionSearch(1, 1, 1, 0));
        assertFalse(con3.regionSearch(1, 1, 1, -1));
        // w > 0 && h > 0
        assertTrue(con3.regionSearch(-1, -1, 2, 2));
        // w <= 0 && h <= 0
        assertFalse(con3.regionSearch(-1, -1, -1, -1));
        assertFalse(con3.regionSearch(-1, -1, 0, 0));
        // just w<=0
        assertFalse(con3.regionSearch(-1, -1, 0, 20));
        assertFalse(con3.regionSearch(-1, -1, -1, 20));
        // just h<=0
        assertFalse(con3.regionSearch(-1, -1, 1, 0));
        assertFalse(con3.regionSearch(-1, -1, 1, -1));

    }

    /**
     * Insert rejections.
     */
    public void testInsert1() {
        list = con.getList();
        assertNotNull(list); // not null by default
        assertEquals(list.size(), 0);
        con.insert("hello", -1, -20);
        assertEquals(0, list.size());
        con.insert("it's", 7, -8);
        assertEquals(0, list.size());
        con.insert("me", 0, 0);
        assertEquals(0, list.size());
        con.insert("from", 0, 0);
        assertEquals(0, list.size());
        con.insert("thousand", 1, 1);
        assertEquals(0, list.size());
        con.insert("miles", 1, 1);
        assertEquals(0, list.size());
        con.insert("big", 1, 1);
        assertEquals(0, list.size());
        con.insert("bang", 1, 1);
        assertEquals(0, list.size());
        con.getList().dump();

    }

    /**
     * Insert actual rectangles.
     */
    public void testInsert2() {
        list = con2.getList();
        assertNotNull(list);

    }

    /**
     * testing remove
     */
    public void testRemove() {
        list = con3.getList();
        assertNotNull(list);
        con3.removebyName("C");
        assertEquals(8, list.size());
        con3.removebyName("A");
        assertEquals(7, list.size());
        con3.removebyName("C");
        con3.removebyName("C");
        con3.removebyName("C");
        assertEquals(4, list.size());
        con3.removebyName("C"); // trying to remove when it's not there.
        assertEquals(4, list.size());
        list.dump();
        con3.removebyName("B");
        con3.removebyName("D");
        list.dump();
        con3.removebyName("E");
        assertEquals(2, list.size());
        con3.removebyName("E");
        con3.removebyName("E"); // rmeoved all E's
        assertEquals(0, list.size());
        assertNull(list.remove(new Point(1, 2)));
        assertNull(list.remove(new Point(-1, -1)));
        con3.insert("B", 0, 0);
        con3.insert("B", 0, 0);
        con3.insert("B", 0, 0);

        // Point rec = new Point(0, 0);
        // con3.dump();
        // assertNotNull(list.remove(rec));
        // assertNull(list.remove(new Point(1, 2)));
        // assertEquals(list.remove(rec).value().getWidth(), 1024);
        //
        // assertEquals(1, list.size());
        // list.dump();
        // assertEquals(0, list.remove(rec).value().getPosY());
        //
        // list.dump();

    }

}