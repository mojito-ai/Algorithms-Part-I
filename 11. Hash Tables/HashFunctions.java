/**
* <h1>Hash Functions: Method for computing array index from key. Scramble the keys uniformly to produce a table index</h1>
*
* <li> Effeciently computable.
* <li> Each table index equally likely for each key.
* <li> Need different approach for each key type. 
* <li> Used in Hash Tables: Saving items in a key-indexed array. [Index is a function of key -> Index=f(key) ]
* <li> Each table undex should be equally likely.
* 
* @author  Mohit Sharma
* @version 1.0
* @since   11-01-2021
* 
*/

public class HashFunctions {
	
	/**
	 * Issues: Computing the hash function:
	 * 
	 * <li> Equality test: Method for checking whether two keys are equal.
	 * <li> Collision resolution: Algorithm and data structure to handle two keys that hash to the same index.
	 * 
	 * <li> Requirement: if x.equals(y) then x.hashCode(y) == y.hashCode(x)
	 * <li> Highly desirable property: If !x.equals(y) then x.hashCode(y) != y.hashCode(x) </li>
	 * 
	 * Default: Memory address of x. But is not uniformly random in selection.
	 * 
	 */
	
	/*
	 * Classic Space-Time tradeoff:
	 * 
	 * <li> No space limitation: Trivial hash function with key as index.
	 * <li> No Time limitation: Trivial collision resolution with sequential search. Just hash everything to the same place.
	 * Hashing is the real world space v.s. time tradeoff
	 * 
	 */
	@SuppressWarnings("unused")
	private final class Integer{
		private final int value;
		Integer(int value)
		{
			this.value=value;
		}
		
		public int hashCode()
		{
			return value;
		}
	}
	
	@SuppressWarnings("unused")
	private final class Boolean{
		private final boolean value;
		Boolean(boolean value)
		{
			this.value=value;
		}
		
		public int hashCode()
		{
			if(value)	return 1231;
			else 		return 1237;
		}
	}
	
	@SuppressWarnings("unused")
	private final class duble{
		private final double value;
		duble(double value)
		{
			this.value=value;
		}
		
		public int hashCode()
		{
			long bits=Double.doubleToLongBits(value);
			return (int)	(bits ^ (bits>>>32));
		}
	}
	
}
