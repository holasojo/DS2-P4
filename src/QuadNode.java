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
    
    public QuadNode remove(Point pt, int x, int y, int width);
    
    public int dump(int x, int y, int width, int level);
    
    public static String spaces(int level){
        String str = "";
        for (int i = 0; i < level; i++){
            str += "  ";
        }
        return str;
    }
    
   public Point searchbyCoor(Point pt, int x, int y, int width);
   
   public void duplicates(int x, int y, int width);
}
