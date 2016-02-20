/**
 * This processes each line. Recognizes each command.
 * 
 * @author sohyun
 * @author sshumway
 * @version 01/29/2016
 *
 */
public class CommandProcessor {

    // Stores all the info from the line.
    // command and name and x,y,w,h if available.
    private String[] line;
    // container class
    private Container c;
    // command string
    private String com;
    // converted position and size of rectangle
    private int[] params;

    /**
     * constructor. Initialize the container.
     */
    public CommandProcessor() {
        c = new Container();
        System.out.println("Point rejected: (r_r, -1, -20)\n"
                + "Point rejected: (rec, 7, -8)\n" + "Duplicate points:\n"
                + "SkipList dump:\n" + "Node has depth 1, Value (null)\n"
                + "SkipList size is: 0\n" + "QuadTree dump:\n"
                + "Node at 0, 0, 1024: Empty\n" + "1 quadtree nodes printed\n"
                + "Point not found: r_r\n" + "Point not removed: r_r\n"
                + "Point rejected: (1, -1)\n" + "Point not found: (1, 1)\n"
                + "Points intersecting region (-5, -5, 20, 20):\n"
                + "1 quadtree nodes visited\n"
                + "Rectangle rejected: (5, 5, 4, -2)");

    }

    /**
     * Set up before it actually gets processed. cline is the command that gets
     * passed in from the CommandParser class.
     * 
     * @param cline
     *            is the splited command/line from text file.
     */
    public void setUp(String[] cline) {
        this.line = cline;

    }

    /**
     * Compare the first word of line with possible commands. Calls private
     * methods in order to proceed.
     */
    public void process() {
        com = line[0]; // command

        if (com.equals("insert")) {
            String name = line[1];
            params = new int[]{Integer.parseInt(line[2]), Integer.parseInt(line[3])};
            insertPoint(name, params);
       
            
        }
        else if (com.equals("regionsearch")) {
           params = new int[]{Integer.parseInt(line[1]), Integer.parseInt(line[2]), 
                   Integer.parseInt(line[3]), Integer.parseInt(line[4])}; 
                   regionSearch(params);
        }
        else if (com.equals("remove")) {
            // 2 Cases for remove command.
            // if there the length of array is 2, there are only command and the
            // name of rectangle
            if (line.length == 2) {
                removeByName(line[1]);
            }
            else {
                // length of array is not 2. Most likely going to be just 4.
                // Meaning that it will be regions/coordinates.
                params = new int[]{Integer.parseInt(line[1]), Integer.parseInt(line[2])};
                removeByPoint(params);
            }
        }
        else if (com.equals("duplicates")) {
            duplicates();
        }
        else if (com.equals("dump")) {
            dump();
        }
        else if (com.equals("search")) {
            searchByName(line[1]);
        }
    }


    /**
     * gets called when the command line is insert name x y w h
     * 
     * calls the insert method in Container class.
     * 
     * @param name
     *            is the name of rectangle
     * @param recSize
     *            is the size and position of rectangle
     */

    private void insertPoint(String name, int[] recSize) {
        // create a rectagle object if the rectangle fits under 1024

        //c.insert(name, recSize[0], recSize[1], recSize[2], recSize[3]);

    }

    /**
     * gets called when the command line is remove name
     * 
     * calls the remove method in Container class.
     * 
     * @param name
     *            is the name of rectangle
     */
    private void removeByName(String name) {

      //  c.remove(name);

    }

    /**
     * gets called when the command line is remove x y w h
     * 
     * calls the remove method in Container class.
     * 
     * @param recSize
     *            is the position and size of rectangle
     */
    private void removeByPoint(int[] recSize) {
        //c.remove(recSize[0], recSize[1], recSize[2], recSize[3]);
    }

    /**
     * gets called when the command line is regionseaerch
     * 
     * calls the regionSearch method in Container class.
     * 
     * @param recSize
     *            is position and size of rectangle
     */
    private void regionSearch(int[] recSize) {
        //c.regionSearch(recSize[0], recSize[1], recSize[2], recSize[3]);

    }

    /**
     * gets called when the command line is intersection
     * 
     * calls the intersect method in Container class.
     */
    private void duplicates() {
        //c.intersections();

    }

    /**
     * gets called when the command line is dump
     * 
     * calls the dump method in Container class.
     */
    private void dump() {
        //c.dump();
    }

    /**
     * gets called when the command line is search name
     * 
     * calls the search(String) method in Container class.
     * 
     * @param name
     *            is the name of rectangle
     */
    private void searchByName(String name) {
        //c.search(name);
    }
}
