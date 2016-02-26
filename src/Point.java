

public class Point  {

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


