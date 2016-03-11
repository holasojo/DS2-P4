/**
 * Tests container class.
 * 
 * 
 * @author sshumway
 * @author sohyun
 *
 */
public class ContainerTest extends student.TestCase {

    Container box;

    /**
     * Sets up the test fixture.
     */
    public void setUp() {
        box = new Container();
    }

    /**
     * tests the fits method to see if points fit in the "world".
     */
    public void testFits() {
        box.insert("sam", -20, 1);
        box.insert("sam", 20, 45);
        box.insert("sam", 20, 45);
        box.insert("sam", 2000, 45);
        box.insert("sam", 20, 5000);
        assertEquals(box.getList().size(), 2);
    }

    /**
     * Tests regionSearch.
     */
    public void testRegionSearch() {
        // (w > 0 && h > 0) && (x + w > 0) && (y + h > 0);
        // (w > 0 && h > 0)
        systemOut().clearHistory();
        assertFalse(box.regionSearch(100, 200, 10, 12));
        assertFuzzyEquals("Rectangle Rejected (100, 200, -10, 12)",
                systemOut().getHistory());
        // (w > 0 || h > 0)
        systemOut().clearHistory();
        assertFalse(box.regionSearch(100, 200, -10, 12));
        assertFuzzyEquals("Rectangle Rejected (100, 200, -10, 12)",
                systemOut().getHistory());
        assertFalse(box.regionSearch(100, 200, -10, -12));
        assertFalse(box.regionSearch(100, 200, 20, -5));
        assertFalse(box.regionSearch(-10, 200, 5, 10));
        assertFalse(box.regionSearch(10, -5, 20, -2));
        assertFalse(box.regionSearch(0, 0, 0, 0));
        assertFalse(box.regionSearch(-200, -200, -10, -10));
        assertNotNull(box.getList());

        systemOut().clearHistory();

    }

    /**
     * Tests the skiplist.
     */
    public void testSkipList() {
        KVPair<String, Point> it = new KVPair<String, Point>("Bob",
                new Point("Bob", 10, 20));
        assertNull(box.getList().remove(it));
        box.getList().insert(it);
        KVPair<String, Point> dummy = new KVPair<String, Point>("Scott",
                new Point("Scott", 10, 20));
        assertNull(box.getList().remove(dummy));

        box.getList().remove(new Point("asdf", 21, 20));
        box.getList().remove(new Point("asdffff", 100, 100));
    }

}
