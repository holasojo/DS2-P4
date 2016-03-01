

public class PRQuadTreeTest extends student.TestCase{
    
    Container c;
    
    
    public void setUp(){
        c = new Container();
    }
    
    public void testInsert1(){
        c.tree().dump();
        c.insert("A", 0, 0, 1, 1);
        assertEquals(c.tree().size(), 1);
        c.tree().dump();
        c.insert("B", 1, 1, 1, 1);
        c.tree().dump();
        c.insert("C", 1000, 1000, 1, 1);
        c.tree().dump();
        c.insert("D", 700, 20, 1, 1);
        systemOut().clearHistory();
        c.tree().dump();
        c.insert("E", 2, 800, 1, 3);
        c.tree().dump();
        c.insert("F", 20, 500, 1, 1);
        c.tree().dump();
        c.insert("G", 300, 300, 1, 1);
        c.tree().dump();
        assertFuzzyEquals("Node at 0, 0, 1024: Internal", systemOut().getHistory());
    }
    
    /**
     * testing duplicates
     * and splitting behavior
     * 
     */
    public void testInsert2(){
        
    }

}
