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
	
	/**
	 * Horner's Method: To hash string of length L: h = s[0]*31^(L-1) + s[1]*31^(L-2) + -------- + s[L-2]*31^1 + s[L-1]*31^0
	 * 
	 * @author _CrY
	 *
	 */
	@SuppressWarnings("unused")
	private final class String{
		/**
		 * Performance optimization: Cache the hash value in an instance variable
		 * Return cached value;
		 * 
		 */
		private int hash=0;
		private final char [] s;
		String(char [] s)
		{
			this.s=s;
		}
		
		public int hashCode()
		{
			int h=hash;
			if(hash!=0)	return hash;
			for(int i=0;i<s.length;i++)
				h=s[i]*(31*h);
			hash=h;
			return hash;
		}
	}
}
