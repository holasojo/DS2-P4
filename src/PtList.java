/**
 * Special version of linked list to suit PRQuadTree that stores point objects.
 * 
 * @author sshumway
 * @author sohyun
 * @version 3/6/2017
 *
 */

public class PtList {

    private PtLink head;
    private PtLink tail;
    private PtLink curr;
    private int size;

    /**
     * set tail and current to null and head is at the same location as tail
     * size is 0
     */
    public PtList() {
        tail = new PtLink(null);
        curr = new PtLink(null);
        head = new PtLink(tail);
        size = 0;
    }

    /**
     * Append a Point in the list
     * 
     * @param it
     *            is a point
     * @return true when inserted
     */
    public boolean append(Point it) {
        tail.setNext(new PtLink(null));
        tail.setElement(it);
        tail = tail.next();
        size++;
        return true;
    }

    /**
     * Checks to see if there is no duplicates
     * 
     * @param pt
     *            is a point that we are comparing
     * @return true if all the points are the same
     */
    public boolean checkAllSame(Point pt) {
        curr = head.next();
        for (int i = 0; i < size; i++) {
            if (!pt.equalsCoor(curr.value())) {
                return false;
            }
            curr = curr.next();
        }
        return true;
    }

    /**
     * find a point that has the same coordinate as the parameter
     * 
     * @param it
     *            is the point that we are comparing
     * @return the current element when matches
     */
    public Point findbyCoor(Point it) {
        curr = head.next();
        for (int i = 0; i < size; i++) {
            if (it.equalsCoor(curr.value())) {

                return curr.value();
            }
            curr = curr.next();
        }
        return null;
    }

    /**
     * copying points
     * 
     * @return the point array
     */
    public Point[] remove() {
        if (size != 0) {
            Point[] points = new Point[size];
            curr = head.next();
            for (int i = 0; i < size; i++) {
                points[i] = curr.value();
                curr = curr.next();
            }
            return points;
        }
        return null;
    }

    /**
     * remove a point
     * 
     * @param it
     *            the one gets removed
     * @param name
     *            is for when
     * @return if removed
     */
    public Point remove(Point it, boolean name) {
        curr = head.next();
        for (int i = 0; i < size; i++) {
            if (name) {
                if (it.equals(curr.value())) {

                    Point found = curr.value();
                    curr.setElement(curr.next().value());
                    if (curr.next() == tail) {
                        tail = curr;
                    }
                    curr.setNext(curr.next().next());
                    size--;
                    return found;
                }
            }
            else {
                if (it.equalsCoor(curr.value())) {

                    Point found = curr.value();
                    curr.setElement(curr.next().value());
                    if (curr.next() == tail) {
                        tail = curr;
                    }
                    curr.setNext(curr.next().next());
                    size--;
                    return found;
                }
            }
            curr = curr.next();
        }
        return null;
    }

    /**
     * prints out what's in the list
     * 
     * @return the list in string
     */
    public String toString() {

        String str = "";

        curr = head.next();
        for (int i = 0; i < size; i++) {
            str += curr.toString() + "\n";
            curr = curr.next();
        }
        return str;
    }

    /**
     * string array that contains the strings of elements in the list
     * 
     * @return the string array
     */
    public String[] list() {

        if (size != 0) {
            String[] strArray = new String[size];
            curr = head.next();
            for (int i = 0; i < size; i++) {
                strArray[i] = curr.value().toString();
                curr = curr.next();
            }
            return strArray;
        }
        return null;

    }

    /**
     * size of the list
     * 
     * @return size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Link class used to make up a 
     * list of points.
     * 
     * @author sohyun
     * @author sshumway
     * @version 3/7/2016
     *
     */
    private class PtLink {

        private Point point;
        private PtLink next;

//        /**
//         * ptlink constructor
//         * 
//         * @param pt
//         *            is the point
//         * @param nxt
//         *            is the next element
//         */
//        public PtLink(Point pt, PtLink nxt) {
//            this.point = pt;
//            this.next = nxt;
//        }

        /**
         * Constructor 
         * 
         * @param nxt
         *            is the next element
         */
        public PtLink(PtLink nxt) {
            this.next = nxt;
        }

        /**
         * getter for the next
         * 
         * @return next element
         */
        public PtLink next() {
            return next;
        } // Return next field

        /**
         * setter for the next
         * 
         * @param nextval
         *            is the next element
         * @return the next element
         */
        public PtLink setNext(PtLink nextval) // Set next field
        {
            next = nextval;
            return next;
        }

        /**
         * return the value inside.
         * 
         * @return a point
         */
        public Point value() {
            return point;
        }

        /**
         * setter for the element
         * 
         * @param it
         *            is the element that we want to store
         * @return the stored point
         */
        public Point setElement(Point it) {
            point = it;
            return point;
        }

        /**
         * toString
         * 
         * @return string
         */
        public String toString() {
            return point.toString();
        }
    }
}
