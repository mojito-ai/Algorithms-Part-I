import java.util.TreeMap;
import java.util.TreeSet;
import edu.princeton.cs.algs4.StdIn;

/**
* <h1>Concordance: Preprocess a text corpus to support concordance queries. Given a word find all the occurances with their immediate contexts.</h1>
* 
* <li> Application: Book Index=Index for an e-book
* <li> Goal: Given a list of files specified, create an index so that you can effeciently find all the files containing a given query string.
* <li> Solution: Key=Query string, Value= SET of files containing that string.
* 
* @author  Mohit Sharma
* @version 1.0
* @since   12-01-2021
* 
*/

public class Concordance {

	public static void main(String [] args)
	{
		String [] words=StdIn.readAll().split("\\s+");
		TreeMap<String, TreeSet<Integer>> st=new TreeMap<>();
		for(int i=0; i<words.length;i++)
		{
			String s=words[i];
			if(!st.containsKey(s))
				st.put(s, new TreeSet<Integer>());
			TreeSet<Integer> pages=st.get(s);
			pages.add(i);
		}
		
		while(!StdIn.isEmpty())
		{
			String query=StdIn.readString();
			TreeSet<Integer> set=st.get(query);
			for(int k: set)
				System.out.println(k);
		}
	}
}
