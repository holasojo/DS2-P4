/**
 * Interface that will be implemented by all node types for the QuadTree. Utilized for nodecentric 
 * implementation of the QuadTree.
 * 
 * @author sshumway
 * @author sohyun
 *
 */
public interface QuadNode {
     
    public QuadNode insert(Point pt, int x, int y, int width);
    
    public void dump(int x, int y, int width, int level);
    
    
}
