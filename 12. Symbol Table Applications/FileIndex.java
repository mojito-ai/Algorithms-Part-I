import java.util.TreeMap;
import java.util.TreeSet;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

import java.io.File;

/**
* <h1>Indexing Clients: Like file indexing. Index a PC or web</h1>
* 
* <li> Goal: Given a list of files specified, create an index so that you can effeciently find all the files containing a given query string.
* <li> Solution: Key=Query string, Value= SET of files containing that string.
* 
* @author  Mohit Sharma
* @version 1.0
* @since   12-01-2021
* 
*/

public class FileIndex {
	
	public static void main(String [] args)
	{
		TreeMap<String, TreeSet<File>> st=new TreeMap<>();
		for(String filename: args)
		{
			File file=new File(filename);
			In in=new In(file);
			while(!in.isEmpty())
			{
				String key=in.readString();
				if(!st.containsKey(key))
					st.put(key, new TreeSet<File> ());		//for each word in file, add file to corresponding list
				TreeSet<File> set=st.get(key);
				set.add(file);
			}
		}
		while(!StdIn.isEmpty())
		{
			String query=StdIn.readString();
			System.out.println(st.get(query));
		}
	}
}
