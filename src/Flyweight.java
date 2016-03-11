/**
 * Stateless flyweight class.
 * 
 * @author sshumway
 * @author sohyun
 * @version 3/7/2016
 *
 */
public class Flyweight implements QuadNode {

    /**
     * Constructor. It does not do or contains anything.
     */
    public Flyweight() {
        // stateless object
    }

    @Override
    public int dump(int x, int y, int width, int level) {

        String n = QuadNode.spaces(level);
        System.out.println(
                n + "Node at " + x + ", " + y + ", " + width + ": Empty");
        return 1;
    }

    @Override
    public QuadNode insert(Point pt, int x, int y, int width) {

        LeafNode leaf = new LeafNode();
        leaf.insert(pt, x, y, width);

        return leaf;
    }

    @Override
    public QuadNode remove(Point pt, int x, int y, int width, boolean name) {
        return this;
    }

    @Override
    public Point searchbyCoor(Point pt, int x, int y, int width) {

        return null;

    }

    @Override
    public int regionSearch(RectangleValue rec, int xWorld, int yWrold,
            int widthWorld) {
        return 1;

    }

    @Override
    public void duplicates(int x, int y, int width) {
        // not yet

    }

}
