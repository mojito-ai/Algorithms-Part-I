import java.util.Comparator;

/**
* <h1>Point 2D: Class to create objects of points in a 2-D plane. Accepts the x & y coordinate and offers multiple ways of comparing two points </h1>
* <li>Compare by polar order
* <li>Compare by Y-order
* <li>Compare by X-order
*
* 
* @author  Mohit Sharma
* @version 1.0
* @since   06-01-2021
* 
*/

public final class Point2D implements Comparable<Point2D> {
	
	private double x;
	private double y;
	
	public Point2D(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public static int ccw(Point2D a, Point2D b, Point2D c)
	{
		double area2=(b.x-a.x)*(c.y-a.y)-(b.y-a.y)*(c.x-a.x);
		if(area2<0)	return -1;			//CW
		else if(area2>0)	return +1;	//CCW
		else	return 0;				//collinear
	}

	@Override
	public int compareTo(Point2D that) {
		/*
		 * Compares two points by y-coordinate, breaking ties by x-coordinate.
		 * Formally, the invoking point (x0, y0) is less than the argument point (x1, y1)
		 * if and only if either {@code y0 < y1} or if {@code y0 == y1} and {@code x0 < x1}.
		 */
		if (this.y < that.y) return -1;
        if (this.y > that.y) return +1;
        if (this.x < that.x) return -1;
        if (this.x > that.x) return +1;
        return 0;	
        
	}
	
	 public Comparator<Point2D> polarOrder() {
	        return new PolarOrder();
	    }
	 
	 private class PolarOrder implements Comparator<Point2D> {
	        public int compare(Point2D q1, Point2D q2) {
	            double dx1 = q1.x - x;
	            double dy1 = q1.y - y;
	            double dx2 = q2.x - x;
	            double dy2 = q2.y - y;

	            if      (dy1 >= 0 && dy2 < 0) return -1;    // q1 above; q2 below
	            else if (dy2 >= 0 && dy1 < 0) return +1;    // q1 below; q2 above
	            else if (dy1 == 0 && dy2 == 0) {            // 3-collinear and horizontal
	                if      (dx1 >= 0 && dx2 < 0) return -1;
	                else if (dx2 >= 0 && dx1 < 0) return +1;
	                else                          return  0;
	            }
	            else return -ccw(Point2D.this, q1, q2);     // both above or below

	            // Note: ccw() recomputes dx1, dy1, dx2, and dy2
	        }
	    }

}
