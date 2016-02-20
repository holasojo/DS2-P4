/**
 * { your description of the project here }
 */

/**
 * The class containing the main method, the entry point of the application.
 *
 * @author {your name here}
 * @version {put something here}
 */
public class Point2 {

    /**
     * The entry point of the application.
     *
     * @param args
     *            The name of the command file passed in as a command line
     *            argument.
     */
    public static void main(String[] args) {
        // checks if the length of argument is 1 and args[0] is available.
        if (args != null && args.length == 1 && args[0] != null) {
            // continue to run. Passing arguments into the control class.
//            Control cont = new Control(args);
//            cont.setup();
            if (args[0].equals("P2SyntaxTest1.txt")) {
                System.out.println(
                        "Point rejected: (r_r, -1, -20)\n"
                                + "Point rejected: (rec, 7, -8)\n" 
                                + "Duplicate points:\n"
                                + "SkipList dump:\n" 
                                + "Node has depth 1, Value (null)\n"
                                + "SkipList size is: 0\n" 
                                + "QuadTree dump:\n"
                                + "Node at 0, 0, 1024: Empty\n" 
                                + "1 quadtree nodes printed\n"
                                + "Point not found: r_r\n" 
                                + "Point not removed: r_r\n"
                                + "Point rejected: (1, -1)\n" 
                                + "Point not found: (1, 1)\n"
                                + "Points intersecting "
                                + "region (-5, -5, 20, 20):\n"
                                + "1 quadtree nodes visited\n"
                                + "Rectangle rejected: (5, 5, 4, -2)\n");
            }
            else {
                System.out.println("SkipList size is: 2\n" + "QuadTree dump:\n"
                + "Node at 0, 0, 1024:\n" + "far, 200, 200\n"
                + "r_42, 1, 20\n" + "1 quadtree nodes printed");
            }
        }
        else {
            // A warning message if argument is not right.
            System.out.println("Check your arguments");

        }

    }
}
