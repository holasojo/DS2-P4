

public class Point<K extends Comparable<?>>  {

	private long xcoord;
	private long ycoord;

	public Point() {
		xcoord = 0;
		ycoord = 0;
	}

	public Point(long x, long y) {
		xcoord = x;
		ycoord = y;
	}

	public long getX() {
		return xcoord;
	}

	public long getY() {
		return ycoord;
	}

	public Direction directionFrom(long X, long Y) {

		if (Y < ycoord && xcoord <= X) {
			return Direction.NW;
		} else if (xcoord < X && ycoord <= Y) {
			return Direction.SW;
		} else if (ycoord < Y && X <= xcoord) {
			return Direction.SE;
		} else if (Y <= ycoord && X < xcoord) {
			return Direction.NE;
		}

		return Direction.NOQUADRANT;
	}

	public Direction inQuadrant(double xLo, double xHi, double yLo, double yHi) {
		if (!inBox(xLo, xHi, yLo, yHi)) {
			return Direction.NOQUADRANT;
		}

		Direction dir = directionFrom((long) (xLo + xHi) / 2,
				(long) (yLo + yHi) / 2);

		if (dir != Direction.NOQUADRANT) {
			return dir;
		}
		return Direction.NE;

	}

	public boolean inBox(double xLo, double xHi, double yLo, double yHi) {
		if (ycoord < yLo || xcoord < xLo || yHi < ycoord || xHi < xcoord) {
			return false;
		}

		return true;
	}

	public String toString() {
		return "X:" + xcoord + ", " + " Y:" + ycoord;
	}

	public boolean equals(Object o) {
		if (!o.getClass().equals(this.getClass())) {
			return false;
		}
		Point it = (Point) o;
		if (this.getX() == it.getX() && this.getY() == it.getY()) {
			return true;
		}
		return false;

	}

}

/**
 * On my honor:
 * 
 * I have not discussed the Java language code in my program with anyone other
 * than my instructor or the teaching assistants assigned to this course. I have
 * not used Java language code obtained from another student, or any other
 * unauthorized source, either modified or unmodified. If any Java language code
 * or documentation used in my program was obtained from another source, such as
 * a text book or course notes, that has been clearly noted with a proper
 * citation in the comments of my program. I have not designed this program in
 * such a way as to defeat or interfere with the normal operation of the Curator
 * System.
 * 
 * So Hyun Jo
 */
