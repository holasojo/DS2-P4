
public class PRQuadTree {
    QuadNode root;
    int size;
    int x;
    int y;
    int width;
    
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
    
}
