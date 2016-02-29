<<<<<<< HEAD

public class Point {

    private String name;
    private int xPos;
    private int yPos;

    public Point(int x, int y) {
        xPos = x;
        yPos = y;
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    
    public String getName() 
    {
        return name;
    }
    
    public Direction quadrant(int centerX, int centerY) {

        if (yPos < centerY && xPos < centerX) {
            return Direction.NW;
        }
        else if (yPos < centerY && xPos >= centerX) {
            return Direction.NE;
        }
        else if (yPos >= centerY && xPos < centerX) {
            return Direction.SW;
        }
        else if (yPos >= centerY && xPos >= centerX) {
            return Direction.SE;
        }
        else {
            return Direction.OUTSIDE;
        }
    }

    
    // public boolean inBox();

    public String toString() {
        return name + ", " + xPos + ", " + yPos;
    }

    public boolean equals(Object o) {
        if (!o.getClass().equals(this.getClass())) {
            return false;
        }
        Point it = (Point) o;
        return this.getX() == it.getX() && this.getY() == it.getY() && this.getName().equals(it.getName());
    }
    
    public boolean equalsCoor(Point it)
    {
        return this.getX() == it.getX() && this.getY() == it.getY();
    }
    
    

}
=======


public class Point implements Comparable<Point>  {

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

    @Override
    public int compareTo(Point o) {
        // TODO Auto-generated method stub
        return 0;
    }

}


>>>>>>> branch 'master' of https://web-cat.cs.vt.edu/Web-CAT/WebObjects/Web-CAT.woa/git/StudentProject/b8ce28b3-0aa2-4fcc-937b-abbd5785b3cb
