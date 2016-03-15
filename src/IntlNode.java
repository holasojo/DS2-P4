/**
 * Internal Node class, has 4 children representing quadrants
 * of the world.
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
     * Sets each child to flyweight
     */
    public IntlNode() {
        nw = fly;
        ne = fly;
        sw = fly;
        se = fly;
    }

    @Override
    /**
     * Inserts a point into the internal node.
     * @return This node.
     */
    public QuadNode insert(Point pt, int x, int y, int width) {

        int centerX = x + width / 2;
        int centerY = y + width / 2;
        Direction quadrant = pt.quadrant(centerX, centerY);
        
        /**
         * Determines which quadrant the point belongs.
         */
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
    /**
     * Prints the points stored in an internal nodes
     * children.
     * @return The number of nodes visited.
     */
    public int dump(int x, int y, int width, int level) {
        
        String n = spaces(level);

        System.out.println(
                n + "Node at " + x + ", " + y + ", " + width + ": Internal");
        return 1 + nw.dump(x, y, width / 2, level + 1)
                + ne.dump(x + width / 2, y, width / 2, level + 1)
                + sw.dump(x, y + width / 2, width / 2, level + 1)
                + se.dump(x + width / 2, y + width / 2, width / 2, level + 1);

    }

    /**
     * getter for the flyweight object.
     * 
     * @return fly is flyweight
     */
    public static Flyweight flyweight() {
        return fly;
    }

    @Override
    /**
     * Removes the point from the appropriate child
     * if it exists.
     * @return The node resulting from the removal.
     */
    public QuadNode remove(Point pt, int x, int y, int width, boolean name) {
        int centerX = x + width / 2;
        int centerY = y + width / 2;
        Direction quadrant = pt.quadrant(centerX, centerY);
        
        //Determines Quadrant to be searched
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
        //Checks the point counts and node type counts
        //after the remove operation.
        for (QuadNode node : children) {
            if (node.getClass() == LeafNode.class) {
                leafCount++;
                pointCount += ((LeafNode) node).pointCount();
            }
            else if (node.getClass() == IntlNode.class) {
                internalCount++;
            }
        }
        
        //Merges the children into one leaf node if appropriate.
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
    /**
     * Searches for the point. Used when removing to obtain the 
     * desired point before the remove operation is carried out.
     * @return The point that will be removed.
     */
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

        return null;

    }

    @Override
    /**
     * Prints and returns the nodes contained in this nodes children
     * that intersect with the given region.
     * @return The number of nodes visited.
     */
    public int regionSearch(RectangleValue queryRegion, int xWorld, int yWorld,
            int widthWorld) {

        int count = 1;
        
        //Coordinates of regions center point.
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
        
        //Checks for intersections and searches child nodes
        //for points that intersect with the query region.
        if (queryRegion.intersect(nwRegion)) {
            count += nw.regionSearch(queryRegion, xWorld, yWorld,
                    widthWorld / 2);
        }
        if (queryRegion.intersect(neRegion)) {
            count += ne.regionSearch(queryRegion, centerX, yWorld,
                    widthWorld / 2);
        }
        if (queryRegion.intersect(swRegion)) {
            count += sw.regionSearch(queryRegion, xWorld, centerY,
                    widthWorld / 2);
        }
        if (queryRegion.intersect(seRegion)) {
            count += se.regionSearch(queryRegion, centerX, centerY,
                    widthWorld / 2);
        }
        return count;

    }

    @Override
    /**
     * Prints duplicate points contained in this nodes
     * children.
     */
    public void duplicates(int x, int y, int width) {

        nw.duplicates(x, y, width / 2);
        ne.duplicates(x + width / 2, y, width / 2);
        sw.duplicates(x, y + width / 2, width / 2);
        se.duplicates(x + width / 2, y + width / 2, width / 2);

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
