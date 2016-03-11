
/**
 * Quadtree class
 * 
 * @author sohyun
 * @author sshumway
 * @version 3/7/2016
 *
 */
public class PRQuadTree {
    private QuadNode root;
    private int size;
    private int x;
    private int y;
    private int width;
    private static int count;

    /**
     * constructor.
     * 
     * @param x1
     *            is the x position
     * @param y1
     *            is the y position
     * @param width1
     *            is the width of world
     */
    public PRQuadTree(int x1, int y1, int width1) {
        root = IntlNode.flyweight();
        size = 0;
        x = x1;
        y = y1;
        width = width1;
    }

    /**
     * inserts a point
     * 
     * @param pt
     *            is the point getting inserted into the tree
     */
    public void insert(Point pt) {
        root = root.insert(pt, x, y, width);
        size++;
    }

    /**
     * number of points
     * 
     * @return is the number of points
     */
    public int size() {
        return size;
    }

    /**
     * prints out all the nodes and points in the tree
     */
    public void dump() {
        System.out.println("QuadTree dump:");
        int nodeCount = root.dump(x, y, width, 0);
        System.out.println(nodeCount + " quadtree nodes printed");

    }

    /**
     * remove a point
     * 
     * @param pt
     *            is the point getting deleted
     * @param name
     *            is false if remove by Coordinates.
     * @return the point got deleted.
     */
    public Point removebyCoor(Point pt, boolean name) {

        Point found = root.searchbyCoor(pt, x, y, width);
        if (found != null) {
            root = root.remove(found, x, y, width, name);
        }
        return found;
    }

    /**
     * Search all the points that are within the region
     * 
     * @param x1
     *            is the x pos
     * @param y1
     *            is the y pos
     * @param w
     *            is the width
     * @param h
     *            is the height
     */
    public void regionSearch(RectangleValue rec) {

        
        int nodes = root.regionSearch(rec, x, y, width, count);
        System.out.println(nodes + " quadtree nodes visited");

    }

    /**
     * prints out duplicates
     */
    public void duplicates() {
        root.duplicates(x, y, width);
    }

}
