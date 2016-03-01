
public class LeafNode implements QuadNode {

    PtList list;

    public LeafNode() {
        list = new PtList();
    }

    public boolean isLeaf() {
        return true;
    }

    public void dump(int x, int y, int width, int level) {
        int n = 2 * level;
//        String str = String.format("%1$#" + n + "s", "");
        
        System.out.println("Node at " + x + ", " + y + ", " + width + ":");

        System.out.println( list.toString());
    }

    @Override
    public QuadNode insert(Point pt, int x, int y, int width) {
        if(list.size() >= 3 && !list.checkAllSame(pt))
        {
            Point[] points = list.remove();
            IntlNode internal = new IntlNode();
            
            for (Point it : points)
            {
                internal.insert(it, x, y, width);
            }
            internal.insert(pt, x, y, width);
            return internal;    
        }
        list.append(pt);
        return this;
    }

}
