

import java.io.FileWriter;
import java.util.Vector;

// The test harness will belong to the following package; the quadtree
// implementation must belong to it as well.  In addition, the quadtree
// implementation must specify package access for the node types and tree
// members so that the test harness may have access to it.
//

public class prQuadTree<T extends Comparable<? super T>> {

	// You must use a hierarchy of node types with an abstract base
	// class. You may use different names for the node types if
	// you like (change displayHelper() accordingly).
	@SuppressWarnings("hiding")
    abstract class prQuadNode {
		public abstract boolean isLeaf();
	}

	class prQuadLeaf<T extends Point> extends prQuadNode {
	    
		Vector<T> Elements;


		public prQuadLeaf() {
		}

		public prQuadLeaf(T elem) {
			Elements = new Vector<T>();
			Elements.add(elem);
		

		}
		
		

		public boolean isLeaf() {
			return true;
		}

		public boolean isFull() {
			if (Elements.size() == 1) {
				return true;
			}

			return false;
		}
		
	
	}

	class prQuadInternal<T extends Point> extends prQuadNode {
		prQuadNode NW, NE, SE, SW;

		public prQuadInternal() {
			NW = null;
			NE = null;
			SE = null;
			SW = null;
		}

		public boolean isLeaf() {
			return false;
		}

	}

	prQuadNode root;
	long xMin, xMax, yMin, yMax;

	// Initialize quadtree to empty state, representing the specified region.
	public prQuadTree(long xMin, long xMax, long yMin, long yMax) {
		this.xMin = xMin;
		this.xMax = xMax;
		this.yMin = yMin;
		this.yMax = yMax;
		root = null;

	}

	// Pre: elem != null
	// Post: If elem lies within the tree's region, and elem is not already
	// present in the tree, elem has been inserted into the tree.
	// Return true iff elem is inserted into the tree.
	public boolean insert(T elem) {
		if (!elem.inBox(xMin, xMax, yMin, yMax) || find(elem) != null
				|| elem == null) {
			return false;
		}
		root = insertHelp(elem, root, xMin, xMax, yMin, yMax);
		if (find(elem) != null) {
			return true;
		}
		return false;

	}

	@SuppressWarnings("unchecked")
	private prQuadNode insertHelp(T elem, prQuadNode node, long xLo, long xHi,
			long yLo, long yHi) {

		if (node == null) {
			prQuadLeaf leafnode = new prQuadLeaf();
			insertHelp(elem, leafnode, xLo, xHi, yLo, yHi);
			return leafnode;

		} else if (node.isLeaf()) {
			prQuadLeaf n = (prQuadLeaf) node;
			if (n.Elements == null) {
				n.Elements = new Vector<T>();
			}
			if (!n.isFull()) {
				n.Elements.add(elem);
				return node;
			} else {
				prQuadInternal internalNode = new prQuadInternal();
				insertHelp(elem, internalNode, xLo, xHi, yLo, yHi);
				if(!n.Elements.isEmpty()){
					insertHelp(n.Elements.remove(0), internalNode, xLo, xHi,
							yLo, yHi);
				}
				return internalNode;
			}

		} else {
			long xCenter = (xHi + xLo) / 2;
			long yCenter = (yHi + yLo) / 2;

			prQuadInternal i = (prQuadInternal) node;
			Direction d = elem.directionFrom(xCenter, yCenter);

			switch (d) {
			case NE:
				i.NE = insertHelp(elem, i.NE, xCenter, xHi, yCenter, yHi);
				break;
			case SW:
				i.SW = insertHelp(elem, i.SW, xLo, xCenter, yLo, yCenter);
				break;
			case NW:
				i.NW = insertHelp(elem, i.NW, xLo, xCenter, yCenter, yHi);
				break;
			case SE:
				i.SE = insertHelp(elem, i.SE, xCenter, xHi, yLo, yCenter);
				break;
			default:
				i.SE = insertHelp(elem, i.SE, xCenter, xHi, yLo, yCenter);
				break;
			}
			return node;
		}

	}

	// Pre: elem != null
	// Post: If elem lies in the tree's region, and a matching element occurs
	// in the tree, then that element has been removed.
	// Returns true iff a matching element has been removed from the tree.
	public boolean delete(T Elem) {
		if (this.root == null || find(Elem) == null || Elem == null
				|| !Elem.inBox(xMin, xMax, yMin, yMax)) {
			return false;
		}

		root = deleteHelp(Elem, root, xMin, xMax, yMin, yMax);

		if (find(Elem) != null) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	private prQuadNode deleteHelp(T elem, prQuadNode node, long xLo, long xHi,
			long yLo, long yHi) {
		if (node == null) {
			return null;
		}
		if (node.isLeaf()) {

			((prQuadLeaf) node).Elements.remove(elem);

			return null;
		} else {
			long xCenter = (xLo + xHi) / 2;
			long yCenter = (yLo + yHi) / 2;
			prQuadInternal n = (prQuadInternal) node;

			Direction d = elem.directionFrom(xCenter, yCenter);
			switch (d) {
			case NE:
				n.NE = deleteHelp(elem, n.NE, xCenter, xHi, yCenter, yHi);
				break;
			case SW:
				n.SW = deleteHelp(elem, n.SW, xLo, xCenter, yLo, yCenter);
				break;
			case NW:
				n.NW = deleteHelp(elem, n.NW, xLo, xCenter, yCenter, yHi);
				break;
			case SE:
				n.SE = deleteHelp(elem, n.SE, xCenter, xHi, yLo, yCenter);
				break;
			default:
				n.NE = deleteHelp(elem, n.NE, xCenter, xHi, yCenter, yHi);
				break;
			}

			if (n.NW == null && n.NE == null && n.SW == null && n.SE != null
					&& n.SE.isLeaf()) {
				return n.SE;
			}
			if (n.NW == null && n.NE == null && n.SE == null && n.SW != null
					&& n.SW.isLeaf()) {
				return n.SW;
			}
			if (n.NE == null && n.SE == null && n.SW == null && n.NW != null
					&& n.NW.isLeaf()) {
				return n.NW;
			}
			if (n.NW == null && n.SE == null && n.SW == null && n.NE != null
					&& n.NE.isLeaf()) {
				return n.NE;
			}

			return node;

		}
	}

	// Pre: elem != null
	// Returns reference to an element x within the tree such that
	// elem.equals(x)is true, provided such a matching element occurs within
	// the tree; returns null otherwise.
	public T find(T Elem) {
		if (root == null || !Elem.inBox(xMin, xMax, yMin, yMax)) {
			return null;
		}

		return findHelp(Elem, root, xMin, xMax, yMin, yMax);
	}

	private T findHelp(T elem, prQuadNode node, long xLo, long xHi, long yLo,
			long yHi) {
		if (node == null) {
			return null;
		}
		if (node.isLeaf()) {
			@SuppressWarnings("unchecked")
			T t = ((prQuadLeaf) node).Elements.get(0);
			if (t.equals(elem)) {
				return t;
			}
			return null;

		} else {

			long xCenter = (xLo + xHi) / 2;
			long yCenter = (yLo + yHi) / 2;
			@SuppressWarnings("unchecked")
			prQuadInternal n = (prQuadInternal) node;
			Direction d = elem.directionFrom(xCenter, yCenter);

			switch (d) {
			case NE:
				return findHelp(elem, n.NE, xCenter, xHi, yCenter, yHi);
			case SW:
				return findHelp(elem, n.SW, xLo, xCenter, yLo, yCenter);
			case NW:
				return findHelp(elem, n.NW, xLo, xCenter, yCenter, yHi);
			case SE:
				return findHelp(elem, n.SE, xCenter, xHi, yLo, yCenter);
			default:
				return findHelp(elem, n.NE, xCenter, xHi, yCenter, yHi);

			}

		}

	}

	// Pre: xLo, xHi, yLo and yHi define a rectangular region
	// Returns a collection of (references to) all elements x such that x is
	// in the tree and x lies at coordinates within the defined rectangular
	// region, including the boundary of the region.
	public Vector<T> find(long xLo, long xHi, long yLo, long yHi) {
		Vector<T> v = new Vector<T>();
		if (root == null) {
			return v;
		}
		if (!overlap(xLo, xHi, yLo, yHi)) {
			return v;
		}
		return findHelpVector(root, v, xLo, xHi, yLo, yHi);
	}

	private Vector<T> findHelpVector(prQuadNode node, Vector<T> v, long xLo,
			long xHi, long yLo, long yHi) {
		if (node == null) {
			return v;
		} else if (node.isLeaf()) {

			@SuppressWarnings("unchecked")
			Vector<T> elems = ((prQuadLeaf) node).Elements;
			if (elems.get(0).inBox(xLo, xHi, yLo, yHi)) {
				v.add(elems.get(0));
			}
			return v;
		} else {
			long xCenter = (xLo + xHi) / 2;
			long yCenter = (yLo + yHi) / 2;

			@SuppressWarnings("unchecked")
			prQuadInternal i = (prQuadInternal) node;

			if (overlap(xCenter, xHi, yCenter, yHi)) {
				v = (findHelpVector(i.NE, v, xLo, xHi, yLo, yHi));
			}
			if (overlap(xLo, xCenter, yLo, yCenter)) {
				v = (findHelpVector(i.SW, v, xLo, xHi, yLo, yHi));
			}
			if (overlap(xCenter, xHi, yLo, yCenter)) {
				v = (findHelpVector(i.SE, v, xLo, xHi, yLo, yHi));
			}
			if (overlap(xLo, xCenter, yCenter, yHi)) {
				v = (findHelpVector(i.NW, v, xLo, xHi, yLo, yHi));
			}
		}
		return v;
	}

	private boolean overlap(long xLo, long xHi, long yLo, long yHi) {

		return xLo <= xMax && yHi >= yMin && yLo <= yMax && xHi >= xMin;
	}
	

}

