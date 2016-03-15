/**
 * Testing Internal Node
 * 
 * @author sohyun
 * @author sshumway
 * @version 3/7/2016
 */
public class IntlNodeTest extends student.TestCase {

    private IntlNode internal;

    /**
     * setup
     * 
     */
    public void setUp() {
        // empty
        internal = new IntlNode();
    }

    /**
     * check to see if the flyweight in internal node is the same as
     * Flyweight.class
     */
    public void testFlyweight() {

        assertEquals(IntlNode.flyweight().getClass(), Flyweight.class);
        assertEquals(IntlNode.flyweight()
                .remove(new Point(1, 1), 0, 0, 512, false).getClass(),
                Flyweight.class);

    }
    
    /**
     * Tests the insert method.
     */
    public void testInsert() {
        Point it = new Point("a", -7, -10);
        assertEquals(internal, internal.insert(it, 0, 0, 1024));
        assertEquals(internal,
                internal.insert(new Point("b", 512, 512), 0, 0, 1024));
    }
    
    /**
     * Test remove method and search by coord.
     */
    public void testRemove() {
        Point it = new Point("a", -7, -10);
        assertNotNull(internal.remove(it, 0, 0, 1024, false));
        internal = new IntlNode();
        assertEquals(internal,
                internal.insert(new Point("b", 512, 512), 0, 0, 1024));
        assertNotNull(
                internal.remove(new Point("b", 512, 512), 0, 0, 1024, false));
        assertNull(internal.searchbyCoor(it, 0, 0, 1024));

    }

}
