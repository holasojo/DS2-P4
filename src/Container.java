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
    private final int WIDTH = 1024;

    /**
     * constructor. Initializing the SkipList.
     */
    public Container() {
        list = new SkipList<String, Point>();
        tree = new PRQuadTree(0, 0, 1024);

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
     * @param w
     *            is width
     * @param h
     *            is height
     */
    public void insert(String name, int x, int y) {
        // check if the rectangle fits under the requirement
        if (fits(x, y)) {
            // create a rectangle
            Point pt = new Point(name, x, y);
            // create KVPair with the rectangle object
            KVPair<String, Point> kv = new KVPair<String, Point>(name, pt);
            // insert kv into the list
            list.insert(kv);
            tree.insert(pt);
            System.out.println("Point inserted: (" + name + ", " + x + ", " + y + ")");
        }
        else {
            System.out.println("Point rejected: (" + name + ", " + x + ", " + y + ")");
        }
    }

    /**
     * checking bounds of the rectangle
     * 
     * @param x
     *            is x-Position. Has to be greater than 0
     * @param y
     *            is y-Position. Has to be greater than 0
     * @param w
     *            is width of the rectangle
     * @param h
     *            is height of the rectangle
     * @return true if the size of rectangle fits within the unit
     */
    public boolean fits(int x, int y) {

        return (x >= 0 && y >= 0) && ((x < WIDTH) && (y < WIDTH));

    }

    /**
     * remove by name
     * 
     * @param name
     *            is the key value
     */
    public void removebyName(String name) {

        // creating a KVPair to pass into the method
        KVPair<String, Point> toRemove = new KVPair<String, Point>(name, new Point(1, 1));
        // the one actually got removed
        KVPair<String, Point> removed = list.remove(toRemove);

        Point removedInTree = tree.removebyCoor(removed.value());

        // if there was a rectangle and got removed,
        // print out that it was removed
        // if not, print out Rectangle not removed
        if (removedInTree != null && removed != null) {

            System.out.println("Point removed: " + "(" + removedInTree.toString() + ")");
        }
        else {
            System.out.println("Point not found: " + name);
            System.out.println("Point not removed: " + name);
        }
    }

    /**
     * checking bounds of the rectangle
     * 
     * @param x
     *            is x-Position. Has to be greater than 0
     * @param y
     *            is y-Position. Has to be greater than 0
     * @param w
     *            is width of the rectangle
     * @param h
     *            is height of the rectangle
     * @return true if the size of rectangle fits within the unit
     */
    public boolean fits(int x, int y, int w, int h) {

        return (w > 0 && h > 0) && ((x + w <= 1024) && (y + h <= 1024));

    }

    /**
     * calls remove method in skipList class.
     * 
     * @param x
     *            is x-pos
     * @param y
     *            is y-pos
     * @param w
     *            is width
     * @param h
     *            is height
     * 
     */
    public void removebyCoor(int x, int y) {
        // check the values meet conditions
        if (fits(x, y)) {
            // create a new rectangle value with passed in values
            Point pt = new Point(x, y);
            Point removeThis = tree.removebyCoor(pt);
            if (removeThis == null) {
                System.out.println("Point not found: (" + x + ", " + y + ")");
                return;
            }
            // the one got removed
            else {
                KVPair<String, Point> removed = list.remove(removeThis);
                if (removed != null && removeThis != null) {
                    // rectangle was in the skip list and got removed
                    System.out.println("Point removed: (" + removed.toString() + ")");
                }
                // else {
                // // rectangle was not in the skiplist
                // System.out.println("Point not removed: (" + x + ", " + y +
                // ")");
                // }
            }
        }
        // if the rectangle size and position not meet requirements, print out
        // rectangle rejected
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
     * @return false when the rectangle is not within the region.
     */
    public boolean regionSearch(int x, int y, int w, int h) {
        // checking width and height
        if (fits(x, y, w, h)) {
            System.out.println("Points intersecting region (" + x + ", " + y + ", " + w + ", " + h + "):");
            // start region search
            tree.regionSearch(x, y, w, h);
            return true;

        }
        else {
            // print out rejection when w <= 0 and h <= 0
            System.out.println("Rectangle rejected: (" + x + ", " + y + ", " + w + ", " + h + ")");
            return false;
        }

    }

    public void duplicates(){
        
        
        
    }
    /**
     * calls the search method in skipList class.
     * 
     * @param name
     *            is rectangle name
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
