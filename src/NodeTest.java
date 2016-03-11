
public class NodeTest extends student.TestCase {

    private PRQuadTree tree;

    public void setUp() {
        tree = new PRQuadTree(0, 0, 1024);
    }

    /**
     * testing removing flyweight
     */
    public void testRemove() {
        
        tree.removebyCoor(new Point(1,1), false);

    }
}
