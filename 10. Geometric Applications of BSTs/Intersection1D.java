/**
* <h1>Line Segment Intersection: Orthogonal line segment intersection search. Given N horizontal and vertical line segments
* 								 ,find all the intersections</h1>
*
* <li> Quadratic Algorithm: Check all pairs of intersections
* <li>Non Degenerate assumption: All x & y coordinates are different
* 
* @author  Mohit Sharma
* @version 1.0
* @since   11-01-2021
* 
*/

public class Intersection1D {
	
	/**
	 * Sweep line Algorithm from left to right.
	 * <li> h-segment (left end-point): Insert y coordinate into BST.
	 * <li> h-segment (right end-point): Remove y coordinate into BST.
	 * <li> v-segment: Range search for interval of y-end-points.
	 */
	
	/**
	 * The sweep line algorithm takes time NlgN + R to find all R-intersections among N orthogonal line segments.
	 * <li> Proof: Put all x coordinates on PQ (or sort) --> NlgN
	 * <li> Insert y coordinate in BST --> NlgN
	 * <li> Delete y coordinate in BST --> NlgN
	 * <li> Range search in BST --> NlgN+R
	 */
	
	//Sweep line reduces 2d orthogonal line segment intersection search into 1d range search

}
