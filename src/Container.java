/**
 * Communicate with SkipList and another data structure that will be added for
 * project2.
 * 
 * @author sohyun
 * @author sshumway
 * @version 01/29/2016
 *
 */
public class Container {

    // skiplist
    private SkipList<String, Point> list;
    private PRQuadTree tree;
    private final int worldWidth = 1024;

    /**
     * constructor. Initializing the SkipList.
     */
    public Container() {
        list = new SkipList<String, Point>();
        tree = new PRQuadTree(0, 0, worldWidth);

    }

    /**
     * Insert method. Creates Point and KVPair. Calls insert() method in
     * SkipList class.
     * 
     * @param name
     *            is the key
     * @param x
     *            is x-pos
     * @param y
     *            is y-pos
     */
    public void insert(String name, int x, int y) {
        // check if the points fits under the requirement
        if (fits(x, y)) {
            // create a points
            Point pt = new Point(name, x, y);
            // create KVPair with the points object
            KVPair<String, Point> kv = new KVPair<String, Point>(name, pt);
            // insert kv into the list
            list.insert(kv);
            tree.insert(pt);
            System.out.println(
                    "Point inserted: (" + name + ", " + x + ", " + y + ")");
        }
        else {
            System.out.println(
                    "Point rejected: (" + name + ", " + x + ", " + y + ")");
        }
    }

    /**
     * checking bounds of the points
     * 
     * @param x
     *            is x-Position. Has to be greater than 0
     * @param y
     *            is y-Position. Has to be greater than 0
     * @return true if the size of points fits within the unit
     */
    private boolean fits(int x, int y) {

        return (x >= 0 && y >= 0) && ((x < worldWidth) && (y < worldWidth));

    }

    /**
     * remove by name
     * 
     * @param name
     *            is the key value
     */
    public void removebyName(String name) {

        // creating a KVPair to pass into the method
        KVPair<String, Point> toRemove = new KVPair<String, Point>(name,
                new Point(1, 1));
        // the one actually got removed
        KVPair<String, Point> removed = list.remove(toRemove);

        if (removed != null) {
            Point removedInTree = tree.removebyCoor(removed.value(), true);

            // if there was a points and got removed,
            // print out that it was removed
            // if not, print out points not removed

            System.out.println(
                    "Point removed: " + "(" + removedInTree.toString() + ")");
        }
        else {
            System.out.println("Point not removed: " + name);
        }

    }

    /**
     * Checks to make sure search region is valid.
     * 
     * @param x
     *            is x-Position. Has to be greater than 0
     * @param y
     *            is y-Position. Has to be greater than 0
     * @param w
     *            is width of the points
     * @param h
     *            is height of the points
     * @return true if the size of points fits within the unit
     */
    public boolean fits(int x, int y, int w, int h) {

        return (w > 0 && h > 0) && (x + w > 0) && (y + h > 0);

    }

    /**
     * calls remove method in skipList class.
     * 
     * @param x
     *            is x-pos
     * @param y
     *            is y-pos
     * 
     */
    public void removebyCoor(int x, int y) {
        // check the values meet conditions
        if (fits(x, y)) {
            // create a new points value with passed in values
            Point pt = new Point(x, y);
            Point removeThis = tree.removebyCoor(pt, false);
            if (removeThis == null) {
                System.out.println("Point not found: (" + x + ", " + y + ")");
                return;
            }
            // the one got removed
            else {
               
                if (removeThis != null) {
                    KVPair<String, Point> removed = list.remove(removeThis);
                    // points was in the skip list and got removed
                    System.out.println(
                            "Point removed: (" + removed.toString() + ")");
                }
             
            }
        }
        // if the points size and position not meet requirements, print out
        // points rejected
        else {

            System.out.println("Point rejected: (" + x + ", " + y + ")");
        }

    }

    /**
     * calls the regionSearch method in skipList class.
     * 
     * 
     * @param x
     *            is x-pos
     * @param y
     *            is y-pos
     * @param w
     *            is width
     * @param h
     *            is height
     * @return false when the points is not within the region.
     */
    public boolean regionSearch(int x, int y, int w, int h) {
        // checking width and height
        if (fits(x, y, w, h)) {

            System.out.println("Points intersecting region (" + x + ", " + y
                    + ", " + w + ", " + h + "):");
            // start region search
            RectangleValue rec = new RectangleValue(x, y, w, h);
            tree.regionSearch(rec);
            return true;

        }
        else {
            // print out rejection when w <= 0 and h <= 0
            System.out.println("Rectangle Rejected: (" + x + ", " + y + ", " + w
                    + ", " + h + ")");
            return false;
        }

    }

    /**
     * duplicates
     */
    public void duplicates() {
        System.out.println("Duplicate points:");
        tree.duplicates();

    }

    /**
     * calls the search method in skipList class.
     * 
     * @param name
     *            is points name
     * 
     */
    public void search(String name) {
        list.search(name);
    }

    /**
     * calls the dump method in skipList class.
     */
    public void dump() {
        list.dump();
        tree.dump();
    }

    /**
     * for testing
     * 
     * @return the list.
     */
    public SkipList<String, Point> getList() {
        return list;
    }

    /**
     * for testing
     * 
     * @return the tree.
     */
    public PRQuadTree tree() {
        return tree;
    }

}
