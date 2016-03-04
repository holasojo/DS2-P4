
public class PRQuadTreeTest extends student.TestCase {

    Container c;

    public void setUp() {
        c = new Container();
        systemOut().clearHistory();
    }

    public void testInsert1() {
        c.tree().dump();
        assertFuzzyEquals("quadtree dump\nnode at 0 0 1024 empty\n1 quadtree nodes printed", systemOut().getHistory());
        c.insert("A", 0, 0);
        assertEquals(c.tree().size(), 1);
        systemOut().clearHistory();
        c.tree().dump();
        assertFuzzyEquals("quadtree dump\nnode at 0 0 1024\na 0 0\n1 quadtree nodes printed", systemOut().getHistory());
        systemOut().clearHistory();
        c.insert("B", 1, 1);
        c.insert("C", 1000, 1000);
        c.insert("D", 700, 20);
        systemOut().clearHistory();
        c.tree().dump();
        assertFuzzyEquals(
                "quadtree dump\nnode at 0 0 1024 internal\nnode at 0 0 512\na 0 0\nb 1 1\nnode at 512 0 512\nd 700 20\nnode at 0 512 512 empty\nnode at 512 512 512\nc 1000 1000\n5 quadtree nodes printed",
                systemOut().getHistory());
        systemOut().clearHistory();
        c.insert("E", 2, 800);
        c.tree().dump();
        c.insert("F", 20, 500);
        c.tree().dump();
        c.insert("G", 300, 300);
        c.tree().dump();
        systemOut().clearHistory();
    }

    /**
     * testing duplicates and splitting behavior
     * 
     */
    public void testInsert2() {
        c.insert("A", 0, 0);
        c.insert("A", 0, 0);
        c.insert("A", 0, 0);
        c.tree().dump();
        c.insert("A", 0, 0);
        c.tree().dump();
        c.insert("A", 0, 0);
        c.tree().dump();
        c.insert("B", 400, 600);
        c.tree().dump();
        c.insert("A", 200, 200);
        c.tree().dump();
    }

    /**
     * testing Syntax Test1
     */
    public void testInsert3() {
        /**
         * insert r_r -1 -20 insert rec 7 -8
         */

        c.insert("r_r", -1, -20);
        c.insert("r_r", 7, -8);
        systemOut().clearHistory();

    }

    /**
     * testing Syntax Test2
     */
    public void testInsert4() {
        /**
         * 
         * insert r_r 1 20 insert rec 10 30 insert r_42 1 20 insert far 200 200
         */
        systemOut().clearHistory();

        c.insert("r_r", 1, 20);
        c.insert("rec", 10, 30);
        c.insert("r_42", 1, 20);
        c.insert("far", 200, 200);
        c.tree().dump();

        systemOut().clearHistory();

    }

}
