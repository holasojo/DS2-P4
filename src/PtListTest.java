
public class PtListTest extends student.TestCase {
    PtList list1;
    PtList list2;
    Point p1;
    Point p2;
    Point p3;
    Point p4;
    Point p5;
    Point p6;
    
    
    public void setUp(){
        list1 = new PtList();
        list2 = new PtList();
        p1 = new Point("A",1,1);
        p2 = new Point("B",2,2);
        p3 = new Point("C",1,1);
        p4 = new Point("D",5,5);
        p5 = new Point("F",0,0);
        p6 = new Point("G",1023,1023);
        
    }
    
    public void testAppend(){
        list1.append(p1);
        list1.append(p2);
        assertEquals(list1.size(),2);
        assertEquals(list1.toString(), "A, 1, 1\nB, 2, 2\n");
      
    }

}
