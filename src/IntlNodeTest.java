
public class IntlNodeTest extends student.TestCase {
    
    IntlNode internal;
    
    public void setUp()
    {
        
    }
    
    public void testFlyweight()
    {
        assertEquals(IntlNode.flyweight().getClass(), Flyweight.class);
    }

}
