
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
        // TODO Auto-generated method stub
        return null;
    }

}
