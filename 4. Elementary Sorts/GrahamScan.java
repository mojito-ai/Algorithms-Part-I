import edu.princeton.cs.algs4.Stack;

import java.util.Arrays;

import edu.princeton.cs.algs4.Point2D;
/**
* <h1>Convex Hull: The convex hull of a set of N points in a plane is the smallest perimeter fence enclosing the points  </h1>
* <li>It is the smallest convex set containing all the points or the smallest area polygon enclosing all the points.
* <li>Applications: Robot Motion Planning, Farthest Pair Problem
* 
* 
* @author  Mohit Sharma
* @version 1.0
* @since   06-01-2021
* 
*/

public class GrahamScan {

	/**Convex Hull properties:
	 * <li>Can traverse the convex hull by making only counter clockwise turns.
	 * <li>The vertices of a convex hull appear in increasing order of their polar angle with respect to point p with lowest y-coordinate
	 * 
	 */
	
	private Stack<Point2D> hull=new Stack<>();
	
	public GrahamScan(Point2D [] points)
	{
		// defensive copy
        int n = points.length;
        Point2D[] a = new Point2D[n];
        for (int i = 0; i < n; i++) {
            if (points[i] == null)
                throw new IllegalArgumentException("points[" + i + "] is null");
            a[i] = points[i];
        }
        
        Arrays.sort(a);
        Arrays.sort(a,a[0].polarOrder());
        
        hull.push(a[0]); //definitely on Hull
        hull.push(a[1]);
        
        for(int i=2;i<n;i++)
        {
        	Point2D top=hull.pop();
        	while(Point2D.ccw(hull.peek(), top, a[i])<=0) //disregard points with CW turn
        		top=hull.pop();
        	
        	hull.push(top);
        	hull.push(a[i]);
        }
	}
	
	public Iterable<Point2D> hull() {
        Stack<Point2D> s = new Stack<Point2D>();
        for (Point2D p : hull) s.push(p);
        return s;
    }
	
} 
