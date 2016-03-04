
public class PRQuadTree {
    private QuadNode root;
    private int size;
    private int x;
    private int y;
    private int width;

    public PRQuadTree(int x1, int y1, int width1) {
        root = IntlNode.flyweight();
        size = 0;
        x = x1;
        y = y1;
        width = width1;
    }

    public void insert(Point pt) {
        root = root.insert(pt, x, y, width);
        size++;
    }

    public int size() {
        return size;
    }

    public void dump() {
        System.out.println("QuadTree dump:");
        int nodeCount = root.dump(x, y, width, 0);
        System.out.println(nodeCount + " quadtree nodes printed");

    }

    public QuadNode remove(int x, int y) {

        Point found = root.searchbyCoor(new Point("dummy", x, y), x, y, width);
        if (found != null) {
            root = root.remove(found, x, y, width);
        }
        return root;

    }
}
