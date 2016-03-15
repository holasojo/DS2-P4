/**
 * LeafNode class, stores point objects.
 * 
 * @author sohyun
 * @author sshumway
 * @version 3/7/2016
 *
 */
public class LeafNode implements QuadNode {

    private PtList list;

    /**
     * LeafNode contains a list
     */
    public LeafNode() {
        list = new PtList();
    }

    @Override
    /**
     * Prints the points that are stored in this leaf node,
     * if any, and returns 1 for the node visited.
     * @return Count for this node.
     */
    public int dump(int x, int y, int width, int level) {
        String n = spaces(level);

        System.out.println(n + "Node at " + x + ", " + y + ", " + width + ":");

        String[] elems = list.list();

        for (String elem : elems) {
            System.out.println(n + "(" + elem + ")");
        }

        return 1;

    }

    @Override
    /**
     * Insert a point into the leaf node.
     * @return The node being inserted, possibly an internal node
     * if a split is required.
     */
    public QuadNode insert(Point pt, int x, int y, int width) {
        //Splits into inernal with children if greater than 3
        //unique points
        if (list.size() >= 3 && !list.checkAllSame(pt)) {
            Point[] points = list.remove();
            IntlNode internal = new IntlNode();

            for (Point it : points) {
                internal.insert(it, x, y, width);
            }
            internal.insert(pt, x, y, width);
            return internal;
        }
        //otherwise adds to this leaf node.
        list.append(pt);
        return this;
    }

    @Override
    /**
     * Removes given point from this leaf node.
     * @return this node or flyeweight if empty.
     */
    public QuadNode remove(Point pt, int x, int y, int width, boolean name) {

        list.remove(pt, name);

        if (list.size() == 0) {
            return IntlNode.flyweight();
        }
        return this;
    }

    /**
     * getter for the number of points in the list
     * 
     * @return number of points in the list
     */
    public int pointCount() {
        return list.size();
    }

    /**
     * Returns all points stored in list.
     * @return r
     */
    public Point[] removeAll() {
        return list.remove();
    }

    @Override
    /**
     * Returns the given point from list if it exists.
     * Used to obtain point when performing a removal.
     * @return The point being removed.
     */
    public Point searchbyCoor(Point pt, int x, int y, int width) {

        return list.findbyCoor(pt);

    }

    @Override
    /**
     * Finds points in the list that intersect with
     * the given search region and prints them.
     * @return The count for node visits.
     */
    public int regionSearch(RectangleValue rec, int xWorld, int yWorld,
            int widthWorld) {
        
        Point[] points = list.remove();
        for (Point it : points) {
            if (it.inRegion(rec.getPosX(), rec.getPosY(), rec.getWidth(),
                    rec.getHeight())) {
                System.out.println("Point found: (" + it.toString() + ")");
            }
        }
        return 1;

    }

    @Override
    /**
     * Prints duplicate points in this node, if they
     * exist.
     */
    public void duplicates(int x, int y, int width) {

        Point[] elems = list.remove();

        for (Point elem1 : elems) {
            for (Point elem2 : elems) {
                if (elem1 != elem2 && elem1.equalsCoor(elem2)) {
                    System.out.println(
                            "(" + elem1.getX() + ", " + elem1.getY() + ")");
                    return;
                }

            }
        }
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
