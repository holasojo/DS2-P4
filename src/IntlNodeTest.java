/**
 * Testing Internal Node
 * @author sohyun
 * @author sshumway
 *
 */
public class IntlNodeTest extends student.TestCase {
    
    IntlNode internal;
    
    /**setup
     * 
     */
    public void setUp()
    {
        //empty
    }
    
    /**
     * check to see if the flyweight in internal node is the same as 
     * Flyweight.class
     */
    public void testFlyweight()
    {
        assertEquals(IntlNode.flyweight().getClass(), Flyweight.class);
    }

}
