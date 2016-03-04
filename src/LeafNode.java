
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
        list.remove(pt);
        
        if(list.size() == 0)
        {
            return IntlNode.flyweight();
        }
        return this;
    }
    
    public int pointCount()
    {
        return list.size();
    }
    
    public Point[] removeAll()
    {
        return list.remove();
    }

    public Point searchbyCoor(Point pt, int x, int y, int width) {
        
        return list.findbyCoor(pt);
        
    }

    @Override
    public void duplicates(int x, int y, int width) {
        
        String[] elems = list.list();
        
        for (String elem : elems) {
            System.out.println("(" + elem + ")");
        }
        
        
    }
    

}
