/**
 * Internal Node class
 * 
 * @author sohyun
 * @author sshumway
 * @version 3/7/2016
 *
 */
public class IntlNode implements QuadNode {

    private QuadNode nw;
    private QuadNode ne;
    private QuadNode sw;
    private QuadNode se;
    private static Flyweight fly = new Flyweight();

    /**
     * Sets each direction to flyweight
     */
    public IntlNode() {
        nw = fly;
        ne = fly;
        sw = fly;
        se = fly;
    }

    @Override
    public QuadNode insert(Point pt, int x, int y, int width) {

        int centerX = x + width / 2;
        int centerY = y + width / 2;
        Direction quadrant = pt.quadrant(centerX, centerY);

        if (quadrant == Direction.NW) {
            nw = nw.insert(pt, x, y, width / 2);
        }
        else if (quadrant == Direction.NE) {
            ne = ne.insert(pt, centerX, y, width / 2);
        }
        else if (quadrant == Direction.SW) {
            sw = sw.insert(pt, x, centerY, width / 2);

        }
        else if (quadrant == Direction.SE) {
            se = se.insert(pt, centerX, centerY, width / 2);
        }

        return this;

    }

    @Override
    public int dump(int x, int y, int width, int level) {

        String n = QuadNode.spaces(level);

        System.out.println(
                n + "Node at " + x + ", " + y + ", " + width + ": Internal");
        return 1 + nw.dump(x, y, width / 2, level + 1)
                + ne.dump(x + width / 2, y, width / 2, level + 1)
                + sw.dump(x, y + width / 2, width / 2, level + 1)
                + se.dump(x + width / 2, y + width / 2, width / 2, level + 1);

    }

    /**
     * getter for flyweight
     * 
     * @return fly is flyweight
     */
    public static Flyweight flyweight() {
        return fly;
    }

    @Override
    public QuadNode remove(Point pt, int x, int y, int width, boolean name) {
        int centerX = x + width / 2;
        int centerY = y + width / 2;
        Direction quadrant = pt.quadrant(centerX, centerY);

        if (quadrant == Direction.NW) {
            nw = nw.remove(pt, x, y, width / 2, name);
        }
        else if (quadrant == Direction.NE) {
            ne = ne.remove(pt, centerX, y, width / 2, name);
        }
        else if (quadrant == Direction.SW) {
            sw = sw.remove(pt, x, centerY, width / 2, name);

        }
        else if (quadrant == Direction.SE) {
            se = se.remove(pt, centerX, centerY, width / 2, name);
        }

        int pointCount = 0;
        int leafCount = 0;
        int internalCount = 0;

        QuadNode[] children = new QuadNode[] { nw, ne, sw, se };
        for (QuadNode node : children) {
            if (node.getClass() == LeafNode.class) {
                leafCount++;
                pointCount += ((LeafNode) node).pointCount();
            }
            else if (node.getClass() == IntlNode.class) {
                internalCount++;
            }
        }

        if ((pointCount <= 3 || leafCount == 1) && internalCount == 0) {
            LeafNode merged = new LeafNode();
            for (QuadNode node : children) {
                if (node.getClass() == LeafNode.class) {
                    Point[] points = ((LeafNode) node).removeAll();
                    for (Point it : points) {
                        merged.insert(it, x, y, width);
                    }
                }
            }
            return merged;
        }
        return this;
    }

    @Override
    public Point searchbyCoor(Point pt, int x, int y, int width) {
        int centerX = x + width / 2;
        int centerY = y + width / 2;
        Direction quadrant = pt.quadrant(centerX, centerY);

        if (quadrant == Direction.NW) {
            return nw.searchbyCoor(pt, x, y, width / 2);
        }
        else if (quadrant == Direction.NE) {
            return ne.searchbyCoor(pt, centerX, y, width / 2);
        }
        else if (quadrant == Direction.SW) {
            return sw.searchbyCoor(pt, x, centerY, width / 2);

        }
        else if (quadrant == Direction.SE) {
            return se.searchbyCoor(pt, centerX, centerY, width / 2);
        }
        else {
            return null;
        }
    }

    @Override
    public int regionSearch(RectangleValue queryRegion, int xWorld, int yWorld,
            int widthWorld, int nodeCount) {

        int centerX = xWorld + widthWorld / 2;
        int centerY = yWorld + widthWorld / 2;

        RectangleValue nwRegion = new RectangleValue(xWorld, yWorld,
                widthWorld / 2, widthWorld / 2);
        RectangleValue neRegion = new RectangleValue(centerX, yWorld,
                widthWorld / 2, widthWorld / 2);
        RectangleValue swRegion = new RectangleValue(xWorld, centerY,
                widthWorld / 2, widthWorld / 2);
        RectangleValue seRegion = new RectangleValue(centerX, centerY,
                widthWorld / 2, widthWorld / 2);
        

        // Direction quadrant = regionOrigin.quadrant(centerX, centerY);

        if (queryRegion.intersect(nwRegion)) {
            return 1 + nw.regionSearch(queryRegion, xWorld, yWorld,
                    widthWorld / 2, nodeCount++);
        }
        if (queryRegion.intersect(neRegion)) {
            return 1 + ne.regionSearch(queryRegion, centerX, yWorld,
                    widthWorld / 2, nodeCount++);
        }
        if (queryRegion.intersect(swRegion)) {
            return 1 + sw.regionSearch(queryRegion, xWorld, centerY,
                    widthWorld / 2, nodeCount++);
        }
        if (queryRegion.intersect(seRegion)) {
            return 1 + se.regionSearch(queryRegion, centerX, centerY,
                    widthWorld / 2, nodeCount++);
        }
        return 1;

    }

    @Override
    public void duplicates(int x, int y, int width) {

        nw.duplicates(x, y, width / 2);
        ne.duplicates(x + width / 2, y, width / 2);
        sw.duplicates(x, y + width / 2, width / 2);
        se.duplicates(x + width / 2, y + width / 2, width / 2);

    }

}
