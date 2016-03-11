/**
 * LeafNode class
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
    public int dump(int x, int y, int width, int level) {
        String n = QuadNode.spaces(level);

        System.out.println(n + "Node at " + x + ", " + y + ", " + width + ":");

        String[] elems = list.list();

        for (String elem : elems) {
            System.out.println(n + "(" + elem + ")");
        }

        return 1;

    }

    @Override
    public QuadNode insert(Point pt, int x, int y, int width) {
        if (list.size() >= 3 && !list.checkAllSame(pt)) {
            Point[] points = list.remove();
            IntlNode internal = new IntlNode();

            for (Point it : points) {
                internal.insert(it, x, y, width);
            }
            internal.insert(pt, x, y, width);
            return internal;
        }
        list.append(pt);
        return this;
    }

    @Override
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
     * 
     * @return r
     */
    public Point[] removeAll() {
        return list.remove();
    }

    @Override
    public Point searchbyCoor(Point pt, int x, int y, int width) {

        return list.findbyCoor(pt);

    }

    @Override
    public int regionSearch(RectangleValue rec, int xWorld, int yWorld,
            int widthWorld) {
        Point[] points = list.remove();
        // RectangleValue rec2 = null;
        for (Point it : points) {
            if (it.inRegion(rec.getPosX(), rec.getPosY(), rec.getWidth(),
                    rec.getHeight())) {
                System.out.println("Point found: (" + it.toString() + ")");
            }
        }
        return 1;

    }

    @Override
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
