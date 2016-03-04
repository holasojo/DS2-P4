
public class IntlNode implements QuadNode {

    private QuadNode NW;
    private QuadNode NE;
    private QuadNode SW;
    private QuadNode SE;
    private static Flyweight fly = new Flyweight();

    public IntlNode() {
        NW = fly;
        NE = fly;
        SW = fly;
        SE = fly;
    }

    @Override
    public QuadNode insert(Point pt, int x, int y, int width) {

        int centerX = x + width / 2;
        int centerY = y + width / 2;
        Direction quadrant = pt.quadrant(centerX, centerY);

        if (quadrant == Direction.NW) {
            NW = NW.insert(pt, x, y, width / 2);
        }
        else if (quadrant == Direction.NE) {
            NE = NE.insert(pt, centerX, y, width / 2);
        }
        else if (quadrant == Direction.SW) {
            SW = SW.insert(pt, x, centerY, width / 2);

        }
        else if (quadrant == Direction.SE) {
            SE = SE.insert(pt, centerX, centerY, width / 2);
        }

        return this;

    }

    public int dump(int x, int y, int width, int level) {

        String n = QuadNode.spaces(level);

        System.out.println(n + "Node at " + x + ", " + y + ", " + width + ": Internal");
        return 1 + NW.dump(x, y, width / 2, level + 1) 
            + NE.dump(x + width / 2, y, width / 2, level + 1)
                + SW.dump(x, y + width / 2, width / 2, level + 1)
                + SE.dump(x + width / 2, y + width / 2, width / 2, level + 1);

       
    }

    public static Flyweight flyweight() {
        return fly;
    }

    @Override
    public QuadNode remove(Point pt, int x, int y, int width) {
        int centerX = x + width / 2;
        int centerY = y + width / 2;
        Direction quadrant = pt.quadrant(centerX, centerY);
        
        if (quadrant == Direction.NW) {
            NW = NW.remove(pt, x, y, width / 2);
        }
        else if (quadrant == Direction.NE) {
            NE = NE.remove(pt, centerX, y, width / 2);
        }
        else if (quadrant == Direction.SW) {
            SW = SW.remove(pt, x, centerY, width / 2);

        }
        else if (quadrant == Direction.SE) {
            SE = SE.remove(pt, centerX, centerY, width / 2);
        }
        
        int pointCount = 0;
        int leafCount = 0;
        
        QuadNode[] children = new QuadNode[]{NW, NE, SW, SE};
        for(QuadNode node : children)
        {
            if(node.getClass() == LeafNode.class)
            {
                leafCount++;
                pointCount  += ((LeafNode)node).pointCount();
            }
        }
        
        if(pointCount <= 3 || leafCount == 1) {
            LeafNode merged = new LeafNode();
            for(QuadNode node : children)
            {
                if(node.getClass() == LeafNode.class)
                {
                    Point[] points = ((LeafNode)node).removeAll();
                    for(Point it : points)
                    {
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
            return NW.searchbyCoor(pt, x, y, width / 2);
        }
        else if (quadrant == Direction.NE) {
           return NE.searchbyCoor(pt, centerX, y, width / 2);
        }
        else if (quadrant == Direction.SW) {
            return SW.searchbyCoor(pt, x, centerY, width / 2);

        }
        else if (quadrant == Direction.SE) {
            return SE.searchbyCoor(pt, centerX, centerY, width / 2);
        }
        else {
            return null;
        }
    }

    @Override
    public void duplicates(int x, int y, int width) {
        NW.duplicates(x, y, width/2);
        NE.duplicates(x, y, width/2);
        SW.duplicates(x, y, width/2);
        NE.duplicates(x, y, width/2);
        
    }

  
}
