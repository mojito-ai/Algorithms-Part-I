import java.util.Hashtable;
//import java.util.TreeMap;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

/**
* <h1>Dictionary Clients: Like symbol tables but used in command line arguments or a csv file</h1>
* 
* <li> Use hash-table with linear probing instead of BST: A BST may become unbalanced due to ordered data whereas ordered 
* 	   operations are not required so hash table suitable
* 
* @author  Mohit Sharma
* @version 1.0
* @since   12-01-2021
* 
*/

public class Dictionary {
	
	public static void main(String [] args)
	{
		In in=new In(args[0]);
		int keyfield=Integer.parseInt(args[1]);
		int valfield=Integer.parseInt(args[2]);
		Hashtable<String, String> dict=new Hashtable<>();
		while(!in.isEmpty())
		{
			String line=in.readLine();
			String [] tokens=line.split(",");
			String key=tokens[keyfield];
			String val=tokens[valfield];
			dict.put(key, val);
		}
		while(!StdIn.isEmpty())
		{
			String s=StdIn.readString();
			if(!dict.contains(s))	System.out.println("Not found");
			else					System.out.println(dict.get(s));
		}
	}
}
