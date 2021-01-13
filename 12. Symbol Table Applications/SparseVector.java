import java.util.Enumeration;
import java.util.Hashtable;

/**
* <h1>Sparse Vector: When too many 0's in matrix products, use better data structure to store vectors</h1>
*
* <li> Assumption: Matrix dimension is 10000, average number of nonzero entries per row ~10
* <li> Symbol Table representation: Key=Index, Value=entry, Effecient iterator needed. 
* <li> Space = Number of non zero entries
* 
* @author  Mohit Sharma
* @version 1.0
* @since   12-01-2021
* 
*/

public class SparseVector {
	
	//Hash table as order not important
	private Hashtable<Integer, Double> v;

	//empty hash table represents everything as 0 vector
	public SparseVector()
	{
		v=new Hashtable<>();
	}
	
	//a[i]=value;
	public void put(int i, double x)
	{
		v.put(i, x);
	}
	
	//return a[i]
	public double get(int i)
	{
		if(!v.contains(i))	return 0.0;
		else 	return v.get(i);
	}
	
	public Enumeration<Integer> indices()
	{
		return v.keys();
	}
	
	public double dot(double [] that)
	{
		double sum=0.0;
		while(indices().hasMoreElements())
		{
			int param=indices().nextElement();
			sum+=that[param]*this.get(param);
		}
		return sum;
	}
}
