
public class LeafNode implements QuadNode {

    PtList list;

    public LeafNode() {
        list = new PtList();
    }

    public boolean isLeaf() {
        return true;
    }

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
    public QuadNode remove(Point pt, int x, int y, int width) {
        // TODO Auto-generated method stub
        return null;
    }

}
