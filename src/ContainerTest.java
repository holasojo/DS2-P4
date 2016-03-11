/**
 * Tests container class.
 * 
 * 
 * @author sshumway
 * @author sohyun
 * @version 3/11/2016
 *
 */
public class ContainerTest extends student.TestCase {

    private Container box;

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
        // w > 0 && h > 0
        // (w > 0 && h > 0) && (x + w > 0) && (y + h > 0);
        systemOut().clearHistory();
        assertTrue(box.regionSearch(100, 200, 10, 12));
        assertFuzzyEquals("Points intersecting region (100, 200, 10, 12):\n0 "
                + "quadtree nodes visited", systemOut().getHistory());
        // w > 0 && h > 0 && not (x + w > 0) && (y + h > 0);
        systemOut().clearHistory();
        assertFalse(box.regionSearch(-200, 200, 10, 10));
        assertFuzzyEquals("Rectangle Rejected (-200, 200, 10, 10)",
                systemOut().getHistory());
        // w > 0 && h > 0 && (x + w > 0) && not (y + h > 0);
        systemOut().clearHistory();
        assertFalse(box.regionSearch(200, -200, 10, 10));
        assertFuzzyEquals("Rectangle Rejected (200, -200, 10, 10)",
                systemOut().getHistory());
        // w > 0 && h > 0 && not (x + w > 0) && not (y + h > 0);
        systemOut().clearHistory();
        assertFalse(box.regionSearch(200, -200, 10, 10));
        assertFuzzyEquals("Rectangle Rejected (-200, -200, 10, 10)",
                systemOut().getHistory());
        
        // w < 0 && h > 0
        // (w < 0 && h > 0) && (x + w > 0) && (y + h > 0);
        systemOut().clearHistory();
        assertFalse(box.regionSearch(200, 200, -10, 10));
        assertFuzzyEquals("Rectangle Rejected (200, 200, -10, 10)",
                systemOut().getHistory());
        // w < 0 && h > 0 && not (x + w > 0) && (y + h > 0);
        systemOut().clearHistory();
        assertFalse(box.regionSearch(-200, 200, -10, 10));
        assertFuzzyEquals("Rectangle Rejected (-200, 200, -10, 10)",
                systemOut().getHistory());
        // w < 0 && h > 0 && (x + w > 0) && not (y + h > 0);
        systemOut().clearHistory();
        assertFalse(box.regionSearch(200, -200, -10, 10));
        assertFuzzyEquals("Rectangle Rejected (200, -200, -10, 10)",
                systemOut().getHistory());
        // w < 0 && h > 0 && not (x + w > 0) && not (y + h > 0);
        systemOut().clearHistory();
        assertFalse(box.regionSearch(-200, -200, -10, 10));
        assertFuzzyEquals("Rectangle Rejected (-200, -200, -10, 10)",
                systemOut().getHistory());
        
        
        // w > 0 && h < 0
        // w > 0 && h < 0 && (x + w > 0) && (y + h > 0);
        systemOut().clearHistory();
        assertFalse(box.regionSearch(200, 200, 10, -10));
        assertFuzzyEquals("Rectangle Rejected (200, 200, 10, -10)",
                systemOut().getHistory());
        // w > 0 && h < 0 && not (x + w > 0) && (y + h > 0);
        systemOut().clearHistory();
        assertFalse(box.regionSearch(-200, 200, 10, -10));
        assertFuzzyEquals("Rectangle Rejected (-200, 200, 10, -10)",
                systemOut().getHistory());
        // w > 0 && h < 0 && (x + w > 0) && not (y + h > 0);
        systemOut().clearHistory();
        assertFalse(box.regionSearch(200, -200, 10, -10));
        assertFuzzyEquals("Rectangle Rejected (200, -200, 10, -10)",
                systemOut().getHistory());
        // w > 0 && h < 0 && not (x + w > 0) && not (y + h > 0);
        systemOut().clearHistory();
        assertFalse(box.regionSearch(-200, -200, 10, -10));
        assertFuzzyEquals("Rectangle Rejected (-200, -200, 10, -10)",
                systemOut().getHistory());
        

        // w < 0 && h < 0
        // w < 0 && h < 0 && (x + w > 0) && (y + h > 0);
        systemOut().clearHistory();
        assertFalse(box.regionSearch(200, 200, -10, -10));
        assertFuzzyEquals("Rectangle Rejected (200, 200, -10, -10)",
                systemOut().getHistory());
        // w < 0 && h < 0 && not (x + w > 0) && (y + h > 0);
        systemOut().clearHistory();
        assertFalse(box.regionSearch(-200, 200, -10, -10));
        assertFuzzyEquals("Rectangle Rejected (-200, 200, -10, -10)",
                systemOut().getHistory());
        // w < 0 && h < 0 && (x + w > 0) && not (y + h > 0);
        systemOut().clearHistory();
        assertFalse(box.regionSearch(200, -200, -10, -10));
        assertFuzzyEquals("Rectangle Rejected (200, -200, -10, -10)",
                systemOut().getHistory());
        // w < 0 && h < 0 && not (x + w > 0) && not (y + h > 0);
        systemOut().clearHistory();
        assertFalse(box.regionSearch(-200, -200, -10, -10));
        assertFuzzyEquals("Rectangle Rejected (-200, -200, -10, -10)",
                systemOut().getHistory());
        

        // w > 0 && h < 0 && (x + w > 0) && (y + h > 0);
        systemOut().clearHistory();
        assertFalse(box.regionSearch(100, 200, 10, -12));
        assertFuzzyEquals("Rectangle Rejected (100, 200, 10, -12)",
                systemOut().getHistory());

        // w < 0 && h > 0 && (x + w > 0) && (y + h > 0);
        systemOut().clearHistory();
        assertFalse(box.regionSearch(100, 200, -10, 12));
        assertFuzzyEquals("Rectangle Rejected (100, 200, -10, 12)",
                systemOut().getHistory());
        // w < 0 && h < 0 && (x + w > 0) && (y + h > 0);
        systemOut().clearHistory();
        assertFalse(box.regionSearch(100, 200, -10, -12));
        assertFuzzyEquals("Rectangle Rejected (100, 200, -10, -12)",
                systemOut().getHistory());

        // w < 0 && h < 0
        // (x + w > 0) && (y + h > 0);
        systemOut().clearHistory();
        assertTrue(box.regionSearch(-100, -200, 300, 300));
        assertFuzzyEquals(
                "Points intersecting region (-100, -200, 300, 300):\n0 "
                        + "quadtree nodes visited",
                systemOut().getHistory());
        // (x + w > 0) && not (y + h > 0);
        systemOut().clearHistory();
        assertFalse(box.regionSearch(-100, -200, 200, -30));
        assertFuzzyEquals("Rectangle Rejected (-100, -200, 200, -30)",
                systemOut().getHistory());
        // not (x + w > 0) && (y + h > 0);
        systemOut().clearHistory();
        assertFalse(box.regionSearch(-100, -200, 20, 300));
        assertFuzzyEquals("Rectangle Rejected (-100, -200, 20, 300)",
                systemOut().getHistory());
        // not (x + w > 0) && not (y + h > 0);
        systemOut().clearHistory();
        assertFalse(box.regionSearch(-100, -200, 20, 30));
        assertFuzzyEquals("Rectangle Rejected (-100, -200, 20, 30)",
                systemOut().getHistory());

        // 0
        systemOut().clearHistory();
        assertFalse(box.regionSearch(0, 0, 0, 0));
        assertFuzzyEquals("Rectangle Rejected (0, 0, 0, 0)",
                systemOut().getHistory());
        systemOut().clearHistory();
        // positive and 0s
        assertFalse(box.regionSearch(1, 1, 0, 0));
        assertFuzzyEquals("Rectangle Rejected (1, 1, 0, 0)",
                systemOut().getHistory());
        systemOut().clearHistory();
        assertFalse(box.regionSearch(1, 0, 0, 0));
        assertFuzzyEquals("Rectangle Rejected (1, 0, 0, 0)",
                systemOut().getHistory());
        systemOut().clearHistory();
        assertFalse(box.regionSearch(0, 1, 0, 0));
        assertFuzzyEquals("Rectangle Rejected (0, 1, 0, 0)",
                systemOut().getHistory());
        systemOut().clearHistory();
        assertFalse(box.regionSearch(0, 0, 1, 0));
        assertFuzzyEquals("Rectangle Rejected (0, 0, 1, 0)",
                systemOut().getHistory());
        systemOut().clearHistory();
        assertFalse(box.regionSearch(0, 0, 0, 1));
        assertFuzzyEquals("Rectangle Rejected (0, 0, 0, 1)",
                systemOut().getHistory());
        systemOut().clearHistory();
        assertTrue(box.regionSearch(0, 0, 1, 1));
        assertFuzzyEquals("Points intersecting region (0, 0, 1, 1):\n0 "
                + "quadtree nodes visited", systemOut().getHistory());

        // negative and 0s
        systemOut().clearHistory();
        assertFalse(box.regionSearch(0, -1, 0, 0));
        assertFuzzyEquals("Rectangle Rejected (0, -1, 0, 0)",
                systemOut().getHistory());
        systemOut().clearHistory();
        assertFalse(box.regionSearch(-1, 0, 0, 0));
        assertFuzzyEquals("Rectangle Rejected (-1, 0, 0, 0)",
                systemOut().getHistory());
        systemOut().clearHistory();
        assertFalse(box.regionSearch(-1, -1, 0, 0));
        assertFuzzyEquals("Rectangle Rejected (-1, -1, 0, 0)",
                systemOut().getHistory());
        systemOut().clearHistory();
        assertFalse(box.regionSearch(0, 0, -1, 0));
        assertFuzzyEquals("Rectangle Rejected (0, 0, -1, 0)",
                systemOut().getHistory());
        systemOut().clearHistory();
        assertFalse(box.regionSearch(0, 0, 0, -1));
        assertFuzzyEquals("Rectangle Rejected (0, 0, 0, -1)",
                systemOut().getHistory());
        systemOut().clearHistory();
        assertFalse(box.regionSearch(0, 0, -1, -1));
        assertFuzzyEquals("Rectangle Rejected (0, 0, -1, -1)",
                systemOut().getHistory());
        assertNotNull(box.getList());

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
