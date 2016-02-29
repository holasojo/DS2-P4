
public class PRQuadTree {
    private QuadNode root;
    private int size;
    private int x;
    private int y;
    private int width;
    
    public PRQuadTree(int x1, int y1, int width1){
        root = IntlNode.flyweight();
        size = 0;    
        x = x1;
        y = y1;
        width = width1;
    }

    public void insert(Point pt){
        root.insert(pt, x, y, width);
        size++;
    }
    
    public int size(){
        return size;
    }
    
    public void dump(){
//        for (int i = 0; i < level; i++){
//            
//        }
//        root.dump(x, y, width, level);
    }
}
