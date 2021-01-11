
/**
* <h1>Modular Hashing: hashCode returns an integer between -2^31 and 2^31 -1. Hash function needs to get an int between 0 & M-1 (for use in array index)</h1>
*
* <li> Modelling
* <li> Bins and Balls: Throw balls uniformly random into M bins.
* <li> Birthday Problem: Expect 2 balls in same bin after ~(πM/2)^0.5 tosses.
* <li> Coupon Collector: Expect every bin to have >= 1 ball after ~MlnM tosses
* <li> Load Balancing: After M tosses, expect most loaded bin has ϴ(logM/loglogM) balls
* 
* @author  Mohit Sharma
* @version 1.0
* @since   11-01-2021
* 
*/
	
@SuppressWarnings("unused")
public class Hash<Key> {
	//Each key is equally likely to hash to an integer between 0 & M-1
	
	private int M=10;

	private int hash(Key key)
	{
		return key.hashCode() % M;	//bug as hashCode can be negative
	}
	
	private int hash2(Key key)
	{
		return Math.abs(key.hashCode() % M); //1-in a billion bug -> hashCode of "polygenelubricants" is 2^31
	}

	private int hash3(Key key)
	{
		return (key.hashCode() & 0x7fffffff) % M;		//take 31 bits
	}
	

}
