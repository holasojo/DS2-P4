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
    public void dump(int x, int y, int width, int level) {
        
        int n = 2 * level;
        String str = String.format("%1$#" + n + "s", "");
        System.out
                .println(str + "Node at " + x + ", " + y + ", " + width + ": Empty");
    }

    @Override
    public QuadNode insert(Point pt, int x, int y, int width) {

        LeafNode leaf = new LeafNode();
        leaf.insert(pt, x, y, width);

        return leaf;
    }

}
