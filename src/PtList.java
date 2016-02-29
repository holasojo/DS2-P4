/**
 * Special version of linked list to suit PRQuadTree that stores point objects.
 * 
 * @author sshumway
 * @sohyun
 *
 */

public class PtList {

    private PtLink head;
    private PtLink tail;
    private PtLink curr;
    private int size;
    
    
    public PtList()
    {
        tail = curr = new PtLink(null);
        head = new PtLink(tail);
        size = 0;
    }
    
    public boolean append(Point it) {
            tail.setNext(new PtLink(null));
            tail.setElement(it);
            tail = tail.next();
            size++;
            return true;
      }
    
    public boolean checkAllSame(Point pt)
    {
        curr = head.next();
        for(int i = 0; i < size; i++)
        {
            if (!pt.equalsCoor(curr.value())) {
                return false;
            }
            curr = curr.next();    
        }
        return true;
    }
    
    public Point[] remove()
    {
        if(size != 0)
        {
            Point[] points = new Point[size];
            curr = head.next();
            for(int i = 0; i < size; i++)
            {
                points[i] = curr.value();
                curr = curr.next();
            }
            return points;
        }
        return null;
    }
    
    public Point remove(Point it) {
        curr = head.next();
        for(int i =0; i<size; i++){
            if(it.equalsCoor(curr.value())){
                
                Point found = curr.value();
                curr.setElement(curr.next().value());
                if(curr.next() == tail) {
                    tail = curr;
                }
                curr.setNext(curr.next().next());
                size--;
                return found;
            }
            curr = curr.next();
        }
        return null;
    }
    
    public String toString()
    {
        String str = "";
        
        curr = head.next();
        for(int i = 0; i < size; i++)
        {
            str += curr.toString() + "\n";
            curr = curr.next();
        }     
        return str;
    }
    
    public int size()
    {
        return size;
    }
  
    

    private class PtLink {

        private Point point;
        private PtLink next;

        public PtLink(Point pt, PtLink nxt) {
            this.point = pt;
            this.next = nxt;
        }
        
        public PtLink(PtLink nxt)
        {
            this.next = nxt;
        }

        public PtLink next() {
            return next;
        } // Return next field

        public PtLink setNext(PtLink nextval) // Set next field
        {
            return next = nextval;
        }

        public Point value() {
            return point;
        }

        public Point setElement(Point it) {
            return point = it;
        }
        
        public String toString()
        {
            return point.toString();
        }
    }
}
