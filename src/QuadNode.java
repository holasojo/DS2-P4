/**
 * Interface that will be implemented by all node types for the QuadTree.
 * Utilized for nodecentric implementation of the QuadTree.
 * 
 * @author sshumway
 * @author sohyun
 * @version 3/7/2016
 */
public interface QuadNode {

    /**
     * Inserting a point
     * 
     * @param pt
     *            is the one getting inserted
     * @param x
     *            pos of region
     * @param y
     *            pos of region
     * @param width
     *            of region
     * @return the subtree or leaf or flyweight depends on the situation
     */
    public QuadNode insert(Point pt, int x, int y, int width);

    /**
     * Removing a point
     * 
     * @param pt
     *            is the one getting inserted
     * @param x
     *            pos of region
     * @param y
     *            pos of region
     * @param width
     *            of region
     * @param name
     *            to see if we are comparing name too or not
     * @return the subtree or leaf or flyweight depends on the situation
     */
    public QuadNode remove(Point pt, int x, int y, int width, boolean name);

    /**
     * prints out the tree
     * 
     * @param x
     *            pos of region
     * @param y
     *            pos of region
     * @param width
     *            of region
     * @param level
     *            of each node
     * @return returns the number of node
     */
    public int dump(int x, int y, int width, int level);

    /**
     * used to calculates how many spaces we need when dump()
     * 
     * @param level
     *            of a node
     * @return spaces
     */
    public static String spaces(int level) {
        String str = "";
        for (int i = 0; i < level; i++) {
            str += "  ";
        }
        return str;
    }

    /**
     * Looking for a point
     * 
     * @param pt
     *            the one we are looking for
     * @param x
     *            of region
     * @param y
     *            of region
     * @param width
     *            of region
     * @return the point if found
     */
    public Point searchbyCoor(Point pt, int x, int y, int width);

    /**
     * looking for all points within the region
     * 
     * @param x
     *            d
     * @param y
     *            d
     * @param w
     *            d
     * @param h
     *            d
     * @param xWorld
     *            d
     * @param yWorld
     *            d
     * @param widthWorld
     *            d
     * @param nodeCount
     *            d
     * @return the number of node visited
     */
    public int regionSearch(RectangleValue rec1, int xWorld, int yWorld,
            int widthWorld);

    /**
     * find duplicates
     * 
     * @param x
     *            d
     * @param y
     *            d
     * @param width
     *            d
     */
    public void duplicates(int x, int y, int width);

}
