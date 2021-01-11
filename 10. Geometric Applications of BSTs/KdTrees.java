/**
* <h1>Kd-Trees: Extension of BSTs that allow us to do effecient processing of sets of points in space</h1>
*
* <li> Extension of ordered symbol tables
* <li> Insert a 2d key
* <li> Search for a 2d key
* <li> Delete a 2d key
* <li> Range Search: Find all keys that lie in 2d range
* <li> Range Count: Number of keys that lie in a 2d range
* 
* <li>Application: Networking, Circuit Design, Databases
* 
* @author  Mohit Sharma
* @version 1.0
* @since   11-01-2021
* 
*/

public class KdTrees {
	
	/**
	 * Keys are points in a plane.
	 * Find/Count points in a given h-v rectangle.
	 * 
	 */
	
	/*Grid Implementation: 2d orthogonal range search
	 * 
	 * Divide space into M*M grid of squares.
	 * Create list of points in each square.
	 * Use 2d array to directly index the relevant square.
	 * Insert (x,y) to list for particular square.
	 * Range Search: Examine only squares that intersect 2-D range search query.
	 * Space = M^2 + N
	 * Time = 1 + N/M^2
	 * Rule of thumb: N^0.5 * N^0.5 grid
	 * 
	 * Caveat: Clustering
	 */
	
	/**
	 * Space Partitioning Trees: Use a tree to represent a recursive subdivision of 2d space.
	 * Grid: Divide space uniformly into squares.
	 * 2d trees: Divide into 2 half planes
	 * Quad trees: Divide into 4 quadrants.
	 * BSP tree: Divide space into 2 regions
	 * 
	 * <li> Applications: Ray tracing, acclerate rendering, mesh generation.
	 * 
	 * <li> Implementation: BST, but alternate x and y as key
	 */

}
