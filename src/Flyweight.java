/**
 * Stateless flyweight class.
 * 
 * @author sshumway
 * @author sohyun
 *
 */
public class Flyweight implements QuadNode {
    
    public Flyweight()
    {
        //stateless object
    }

    @Override
    public int dump(int x, int y, int width, int level) {
        
        String n = QuadNode.spaces(level);   
        System.out
                .println(n+ "Node at " + x + ", " + y + ", " + width + ": Empty");
        return 1;
    }

    @Override
    public QuadNode insert(Point pt, int x, int y, int width) {

        LeafNode leaf = new LeafNode();
        leaf.insert(pt, x, y, width);

        return leaf;
    }

    @Override
    public QuadNode remove(Point pt, int x, int y, int width) {
       
        return this;
    }

    public Point searchbyCoor(Point pt, int x, int y, int width) {
        
        return null;
        
    }


    public int regionSearch(int x, int y, int w, int h, int xWorld, int yWrold,
            int widthWorld, int nodeCount) {
        return 1;
//        System.out.println(nodeCount + " quadtree nodes printed");
        
    }

    @Override
    public void duplicates(int x, int y, int width) {
        // TODO Auto-generated method stub
        
    }

}
