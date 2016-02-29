
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
        assertEquals(p1.toString(), "A, 1, 1");
        assertEquals(list1.toString(), "A, 1, 1\nB, 2, 2\n");
        list1.append(p3);
        list1.append(p4);
        list1.append(p5);
        assertEquals(list1.size(),5);    
      
    }
    
    public void testRemove(){
        assertNull(list1.remove());
        list1.append(p1);
        list1.append(p2);
        assertEquals(list1.size(),2);
        Point[] removed = list1.remove();
        assertEquals(removed[1].toString(),"B, 2, 2");   
        list1.append(p3);
        list1.append(p4);
        list1.append(p5);
        assertEquals(list1.remove(p1).toString(), "A, 1, 1");
        assertEquals(list1.remove(p5).toString(), "F, 0, 0");
        removed = list1.remove();
        assertEquals(removed[0].toString(), "B, 2, 2");
        assertEquals(removed[2].toString(), "D, 5, 5");
        list1.append(new Point("B",2,2));
        assertFalse(list1.checkAllSame(p2));
        
        
    }

}
