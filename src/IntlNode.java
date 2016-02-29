
public class IntlNode implements QuadNode {
    
    private QuadNode NW;
    private QuadNode NE;
    private QuadNode SW;
    private QuadNode SE;
    private static Flyweight fly = new Flyweight();
    
    
    public IntlNode()
    {
        NW = fly;
        NE = fly;
        SW = fly;
        SE = fly;
    }

    @Override
    public QuadNode insert(Point pt, int x, int y, int width) {
        
        int centerX = x + width/2;
        int centerY = y + width/2;
        Direction quadrant = pt.quadrant(centerX, centerY);
        
       if (quadrant == Direction.NW) {
           NW = NW.insert(pt, x, y , width /2);
       }
       else if (quadrant == Direction.NE) {
           NE = NE.insert(pt, x + width/2, y, width/2);
       }
       else if (quadrant == Direction.SW) {
           SW = SW.insert(pt, x, y + width/2, width/2);
           
       }
       else if (quadrant == Direction.SE) {
           SE = SE.insert(pt, x + width/2, y + width/2, width/2);
       }
           
       return this;
        
    }

    @Override
    public void dump(int x, int y, int width, int level) {
        // TODO Auto-generated method stub
        
    }
    
    public static Flyweight flyweight()
    {
        return fly;
    }

   

}
