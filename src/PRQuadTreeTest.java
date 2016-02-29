

public class PRQuadTreeTest extends student.TestCase{
    
    Container c;
    
    
    public void setUp(){
        c = new Container();
    }
    
    public void testInsert(){
        c.insert("A", 0, 0, 1024, 1024);
        assertEquals(c.tree().size(), 1);
        c.tree().dump();
    }

}
