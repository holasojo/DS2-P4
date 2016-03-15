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
    /**
     * Prints this nodes contents(empty) with appropriate 
     * indentation by level.
     * @return 1 for node visited.
     */
    public int dump(int x, int y, int width, int level) {

        String n = spaces(level);
        System.out.println(
                n + "Node at " + x + ", " + y + ", " + width + ": Empty");
        return 1;
    }

    @Override
    /**
     * Inserts given point by creating a leaf node, inserting
     * into it and returning the new node.
     * @return the new leaf node.
     */
    public QuadNode insert(Point pt, int x, int y, int width) {

        LeafNode leaf = new LeafNode();
        leaf.insert(pt, x, y, width);

        return leaf;
    }

    @Override
    /**
     * If flyweight is reached, point can't be removed because it is
     * not in the BST.
     * @return Returns flyweight node.
     */
    public QuadNode remove(Point pt, int x, int y, int width, boolean name) {
        return this;
    }

    @Override
    /**
     * Empty method for flyweight node
     * @return null, alerting user that point wasn't found.
     */
    public Point searchbyCoor(Point pt, int x, int y, int width) {

        return null;

    }

    @Override
    /**
     * Does nothing since points aren't contained in flyweight node.
     * @param rec The query region
     * @param xWorld The x coordinate of this region
     * @param yWorld The y coordinate of this region.
     * @param widthWorld, The width of this region.
     * @return 0 because this node isn't visited.
     */
    public int regionSearch(RectangleValue rec, int xWorld, int yWorld,
            int widthWorld) {
        return 0;

    }

    @Override
    /**
     * Does nothing, no duplicates to print.
     */
    public void duplicates(int x, int y, int width) {
        //does nothing
    }
    
    /**
     * used to calculates how many spaces we need when dump()
     * 
     * @param level
     *            of a node
     * @return spaces
     */
    public static String spaces(int level) {
        String spaceStr = "";
        for (int i = 0; i < level; i++) {
            spaceStr += "  ";
        }
        return spaceStr;
    }
    

}
