/**
 * { your description of the project here }
 */

/**
 * The class containing the main method, the entry point of the application.
 *
 * @author {your name here}
 * @version {put something here}
 */
public class Point2
{


    /**
     * The entry point of the application.
     *
     * @param args
     *            The name of the command file passed in as a command line
     *            argument.
     */
    public static void main(String[] args) {

        // checks if the length of argument is 1 and args[0] is available.
        if (args != null&& args.length == 1 && args[0] != null) {
            // continue to run. Passing arguments into the control class.
            Control cont = new Control(args);
            cont.setup();
        }
        else {
            // A warning message if argument is not right.
            System.out.println("Check your arguments");

        }
    }
}
