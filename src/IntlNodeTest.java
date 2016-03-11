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

}
